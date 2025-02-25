<?php
session_start();
include "connector.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = trim($_POST["txtEmail"]);
    $password = trim($_POST["txtPw"]);
    $confirm_password = trim($_POST["txtConfirmPw"]);

    // Check if passwords match
    if ($password !== $confirm_password) {
        $_SESSION["error"] = "Passwords do not match!";
        header("Location: register.php");
        exit();
    }

    // Hash the password
    $hashed_password = password_hash($password, PASSWORD_DEFAULT);

    // Check if email is already registered
    $stmt = $conn->prepare("SELECT id FROM authentication WHERE email = ?");
    $stmt->execute([$email]);

    if ($stmt->rowCount() > 0) {
        $_SESSION["error"] = "Email already exists!";
        header("Location: register.php");
        exit();
    }

    // Inserting into database
    $stmt = $conn->prepare("INSERT INTO authentication (email, password) VALUES (?, ?)");
    
    if ($stmt->execute([$email, $hashed_password])) {
        $_SESSION["success"] = "Registration successful. Please log in.";
        // Redirect to login page
        header("Location: login.php");
        exit();
    } else {
        $_SESSION["error"] = "Registration failed. Try again.";
    }
}
?>