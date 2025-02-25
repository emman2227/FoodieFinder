<?php
session_start();
include "connector.php";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = trim($_POST["email"]);
    $password = trim($_POST["password"]);

    // Checker for existing email
    $stmt = $conn->prepare("SELECT * FROM authentication WHERE email = ?");
    $stmt->execute([$email]);
    $user = $stmt->fetch(PDO::FETCH_ASSOC);

    // Verify password
    if ($user && password_verify($password, $user["password"])) {
        // Set session variables
        $_SESSION["user_id"] = $user["id"];
        $_SESSION["email"] = $user["email"];

        $_SESSION["success"] = "Login successful!";
         // Redirect to dashboard
        header("Location: dashboard.php");
        exit();
    } else {
        $_SESSION["error"] = "Invalid email or password!";
        header("Location: login_db.php");
        exit();
    }
}
?>