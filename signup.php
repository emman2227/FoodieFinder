<?php
session_start();

header("Content-Type: application/json", true, 200);
include "db_connect.php";

// Read JSON input
$input = json_decode(file_get_contents('php://input'), true);

if (!$input) {
    error_log("Response: " . json_encode(["status" => "error", "message" => "Invalid JSON format"]));
    echo json_encode(["status" => "error", "message" => "Invalid JSON format"]);
    exit;
}

// Ensure POST request
if ($_SERVER["REQUEST_METHOD"] !== "POST") {
    echo json_encode(["status" => "error", "message" => "Invalid request method"]);
    exit;
}

// Check required fields
if (empty($input["username"]) || empty($input["email"]) || empty($input["password"])) {
    echo json_encode(["status" => "error", "message" => "All fields are required"]);
    exit;
}

$username = trim($input["username"]);
$email = trim($input["email"]);
$password = $input["password"];

// Check if email exists
$user = $conn->prepare("SELECT id FROM users WHERE email = ?");
$user->bind_param("s", $email);
$user->execute();
$user->store_result();

if ($user->num_rows > 0) {
    echo json_encode(["status" => "error", "message" => "Email already exists!"]);
    exit;
}
$user->close();

// Hash the password
$hashed_password = password_hash($password, PASSWORD_DEFAULT);

// Insert new user
$stmt = $conn->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
$stmt->bind_param("sss", $username, $email, $hashed_password);

if ($stmt->execute()) {
    echo json_encode(["status" => "success", "message" => "Registered Successfully"]);
} else {
    error_log("Signup Error: " . $stmt->error);
    echo json_encode(["status" => "error", "message" => "Database error. Try again later."]);
}

// Close connection
$stmt->close();
$conn->close();
?>
