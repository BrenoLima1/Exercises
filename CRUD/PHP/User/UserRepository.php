<?php

interface UserRepository {
    public function findById(int $id): ?User;
    public function findAll(): array;
    public function saveUser(User $user): void;
    public function removeUser(int $id): void;
}

?>
