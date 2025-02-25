<?php

$host="localhost";
$database="ff_database";
$user="root";
$password="";


try {
    $conn = new PDO("mysql:host=$host;database=$database", $user, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $exception) {
    echo json_encode(["message" => "Database connection failed: " . $exception->getMessage()]);
    exit();
}
?>