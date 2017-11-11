<?php

$host = 'localhost';
$user= 'root';
$pass= '';
$db='testdb';

$con=mysqli_connect($host,$user,$pass,$db);
if($con)
echo "connected";

$sql = "insert into patient (Name,ID,Phone_Number) values ('someone',11225,01676895)";

$query= mysqli_query($con,$sql);

if($query)
	echo " insert succesful ";

?>