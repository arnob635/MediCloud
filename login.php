<?php
require "connect.php";
$username = $_POST["username"];
$user_pass = $_POST["password"];
$test_sql_query = "SELECT * FROM doctors WHERE dName like '$username' AND dPass = '$user_pass'";

$result = mysqli_query($conn, $test_sql_query);
$is_loggedin = mysqli_num_rows($result) > 0;
if($is_loggedin){
	echo "Login Succeeded. ";
}
else echo "Login Incorrect. ";
?>