<?php
require "connect.php";
$email = $_POST["email"];
$password = $_POST["password"];
//$cpassword =$_POST["cpassword"];

//$con=mysqli_connect($host,$user,$pass,$db);

$query_matching = "SELECT * FROM accounts WHERE email = '$email'";
$result = mysqli_query($con, $query_matching);
$has_tupples = mysqli_num_rows($result) > 0;

$query_find_id = "SELECT (COUNT(email)+1) AS cid FROM accounts WHERE isDoctor = 0";
$find_id = mysqli_query($query_find_id);
$row = mysqli_fetch_array($find_id);
$new_id = $row['cid'];

$sql = "INSERT INTO accounts (email,password,generalID,isDoctor) values ('$email', '$password', '$new_id', 0)";

$query= mysqli_query($conn, $sql);

if($query && !has_tupples){
	$response = array();
	$response["id"] = $new_id;
	echo json_encode($response);
}

else
	echo "Error";

?>