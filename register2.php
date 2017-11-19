<?php
require "connect.php";
$id = $_POST["id"];
$name = $_POST["name"];
$dob = $_POST["dob"];
$blood_group = $_POST["blood_group"];
$sex = $_POST["sex"];
$phone_number = $_POST["phone_number"];
$address =$_POST["address"];

//$con=mysqli_connect($host,$user,$pass,$db);


$sql = "INSERT INTO patients_info (pID, name, dob, blood_group, sex, phone_number, address) values ('$id', '$name', '$dob', '$blood_group', '$sex', '$phone_number', '$address')";

$query= mysqli_query($conn, $sql);

if($query)
	echo "Registration Succesful ";

else
	echo "Could NOT Register";

?>