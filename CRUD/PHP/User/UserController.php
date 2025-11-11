<?php

require_once('User.php');
require_once('UserView.php');
require_once('UserRepositoryPDO.php');

class UserController{
    private $userRepository;
    private $userView;

    public function __construct(UserRepository $userRepository, UserView $userView){
        $this->userRepository = $userRepository;
        $this->userView = $userView;
    }

     public function showUserById(int $id): void {
        $user = $this->userRepository->findById($id);
        if ($user) {
            $this->userView->showUser($user);
        } else {
            echo "User not found." . PHP_EOL;
        }
    }

    public function showAllUsers(): void {
        $users = $this->userRepository->findAll();
        $this->userView->showUsers($users);
    }

    public function saveUser(User $user): void {
        try {
            $this->userRepository->saveUser($user);
            $this->userView->showMessage("User saved successfully.");
        }catch (PDOException $th) {
            $this->userView->showMessage($th->getMessage());
            throw $th;
        }
    }

    public function removeUser(int $id): void {
        try {
            $this->userRepository->removeUser($id);
            $this->userView->showMessage("User removed successfully.");
        }catch (PDOException $th) {
            $this->userView->showMessage($th->getMessage());
            throw $th;
        }
    }

}


?>
