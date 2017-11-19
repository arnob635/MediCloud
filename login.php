<?php
require "connect.php";
$username = $_POST["username"];
$user_pass = $_POST["password"];
$test_sql_query = "SELECT isDoctor FROM accounts WHERE email = '$username' AND password = '$user_pass'";
$result = mysqli_query($conn, $test_sql_query);
$query_array = mysqli_fetch_array($result);
$isdoc = $query_array['isDoctor'];

$is_loggedin = mysqli_num_rows($result) > 0;
if($is_loggedin){
	echo "Login Succeeded. ";
}
else echo "Login Incorrect. ";
?>