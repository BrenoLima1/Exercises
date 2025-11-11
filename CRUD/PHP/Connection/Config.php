<?php

function ConnectionPDO(): PDO {
    $host = "localhost";
    $dbname = "crud";
    $user = "root";
    $password = "";

    $dsn = "mysql:host=$host;dbname=$dbname;charset=utf8";

    try {
        return new PDO($dsn, $user, $password, [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION
        ]);
    } catch (PDOException $e) {
        die("Connection failed: " . $e->getMessage());
    }
}
