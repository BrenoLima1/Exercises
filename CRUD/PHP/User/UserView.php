<?php

require_once('User.php');

class UserView{
    public function __construct(){}

    public function showUser(User $user){
        echo PHP_EOL . $user . PHP_EOL . PHP_EOL;
    }

    public function showUsers(array $users){
        if (empty($users)) {
            echo "No users found." . PHP_EOL;
            return;
        }

        foreach ($users as $user) {
            $this->showUser($user);
        }
    }

    public function showMessage(string $message){
        echo $message . PHP_EOL;
    }

}
?>
