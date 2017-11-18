<?php
require "connect.php";
$email = $_POST["email"];
$password = $_POST["password"];
//$cpassword =$_POST["cpassword"];

$con=mysqli_connect($host,$user,$pass,$db);
if($con)
echo "connected";

$sql = "insert into accounts (email,password) values ($email,$password)";

$query= mysqli_query($con,$sql);

if($query)
	echo " insert succesful ";

?>