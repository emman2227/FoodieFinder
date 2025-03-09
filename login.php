<?php
include 'db_connect.php'; // Include database connection

// Read JSON input
$data = json_decode(file_get_contents("php://input"), true);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $email = $data['email'];
    $password = $data['password'];

    // Check if email exists
    $check = $conn->prepare("SELECT id, username, password FROM users WHERE email = ?");
    $check->bind_param("s", $email);
    $check->execute();
    $check->store_result();
    
    if ($check->num_rows > 0) {
        $check->bind_result($id, $username, $hashed_password);
        $check->fetch();
        
        // Verify password
        if (password_verify($password, $hashed_password)) {
            echo json_encode(["status" => "success", "message" => "Login successful!", "user_id" => $id, "username" => $username]);
        } else {
            echo json_encode(["status" => "error", "message" => "Invalid password!"]);
        }
    } else {
        echo json_encode(["status" => "error", "message" => "Email not found!"]);
    }

    $check->close();
    $conn->close();
}
?>
