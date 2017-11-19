<?php
require "connect.php";
//$email = $_POST["email"];
//$password = $_POST["password"];
//$cpassword =$_POST["cpassword"];

$con=mysqli_connect($host,$user,$pass,$db);

$test_sql_query = "SELECT * FROM accounts WHERE email = 'arnob69@gmail.com'";
$result = mysqli_query($con, $test_sql_query);
$has_tupples = mysqli_num_rows($result) > 0;

$sql = "INSERT INTO accounts (email,password) values ('arnob69@gmail.com',123,1,0)";

$query= mysqli_query($con,$sql);

if($query && !has_tupples)
	echo " insert succesful ";

else
	echo "Error";

?>