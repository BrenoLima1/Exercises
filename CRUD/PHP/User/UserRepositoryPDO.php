<?php

require_once('User.php');
require_once('UserRepository.php');
require_once('./Connection/Config.php');

class UserRepositoryPDO implements UserRepository {

    private $pdo;

    public function __construct(PDO $pdo) {
        $this->pdo = $pdo;
    }

    public function findById(int $id): ?User {
        $stmt = $this->pdo->prepare("SELECT * FROM user WHERE iduser = :id");
        $stmt->execute(['id' => $id]);
        $user = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($user) {
            return new User($user['name'], $user['login'], $user['email'],
             $user['password'], $user['iduser']);
        }
        return null;
    }

    public function findAll(): array {
        $stmt = $this->pdo->query("SELECT * FROM user");
        $users = [];
        while ($user = $stmt->fetch(PDO::FETCH_ASSOC)) {
            $users[] = new User( $user['name'], $user['login'], $user['email'], $user['password'], $user['iduser']);
        }
        return $users;
    }

    public function saveUser(User $user): void {
    try {
        $stmt = $this->pdo->prepare("
            INSERT INTO user (name, login, email, password)
            VALUES (:name, :login, :email, :password)
        ");

        $stmt->execute([
            'name' => $user->getName(),
            'login' => $user->getLogin(),
            'email' => $user->getEmail(),
            'password' => $user->getPassword()
        ]);
    } catch (PDOException $e) {
        echo "Erro ao salvar usuário: " . $e->getMessage() . PHP_EOL;
        throw $e;
    }
}

    public function removeUser(int $id): void {
        try {
            $this->pdo->beginTransaction();
            $stmt = $this->pdo->prepare("DELETE FROM user WHERE iduser = :id");
            $stmt->execute(['id' => $id]);
            $this->pdo->commit();
        } catch (\Throwable $th) {
            $this->pdo->rollBack();
            throw $th;
        }
    }

    public function update(int $id, User $user): bool {
        try {
            $this->pdo->beginTransaction();
            $stmt = $this->pdo->prepare("UPDATE user SET name = :name, login = :login, email = :email, password = :password WHERE iduser = :id");
            $stmt->execute([
                'name' => $user->getName(),
                'login' => $user->getLogin(),
                'email' => $user->getEmail(),
                'password' => $user->getPassword(),
                'id' => $id
            ]);
            $this->pdo->commit();
            return $stmt->rowCount() > 0;

        } catch (\Throwable $th) {
            $this->pdo->rollBack();
            throw $th;
        }

    }
}





?>
