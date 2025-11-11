<?php

require_once(__DIR__ . '/User/UserController.php');
require_once(__DIR__ . '/Connection/Config.php');

$pdo = ConnectionPDO();
$repo = new UserRepositoryPDO($pdo);
$view = new UserView();
$controller = new UserController($repo, $view);

echo "Welcome to the User Management System" . PHP_EOL;
while (1) {
    echo "1. Show all users" . PHP_EOL;
    echo "2. Show user by ID" . PHP_EOL;
    echo "3. Create new user" . PHP_EOL;
    echo "4. Remove user by ID" . PHP_EOL;
    echo "5. Update user by ID" . PHP_EOL;
    echo "6. Exit" . PHP_EOL;
    $choice = (int)readline("Enter your choice: ");

    if ($choice === 1) {
        $controller->showAllUsers();
    }elseif ($choice === 2) {
        $id = (int)readline("Type the user ID: ");
        $controller->showUserById($id);
    }elseif ($choice === 3) {
        echo "Creating new user" . PHP_EOL;
        $user = $controller->createUser($view->askUserData());
        $controller->saveUser($user);
    }elseif ($choice === 4) {
        $id = (int)readline("Type the user ID: ");
        $controller->removeUser($id);
    }elseif ($choice === 5) {
        $id = (int)readline("Type the user ID: ");
        $user = $controller->createUser($view->askUserData());
        $controller->updateUser($id, $user);
    }
    elseif ($choice == 6) {
        echo "Goodbye!" . PHP_EOL;
        break;
    }
    else {
        echo "Invalid choice." . PHP_EOL;
    }
}

?>
