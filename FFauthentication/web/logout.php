<?php
session_start();
session_destroy();

echo json_encode(["message" => "Logout successful"]);
header("Location: web_login.php");
exit();
?>
