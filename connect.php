<?php

$host = 'localhost';
$user= 'root';
$pass= '';
$db='testdb';

$con=mysqli_connect($host,$user,$pass,$db);
if($con)
echo "connected";

?>