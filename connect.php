<?php

$host = 'localhost';
$user= 'root';
$pass= '';
$db='medicloud';

$conn = mysqli_connect($host,$user,$pass,$db);
if($conn)
echo "Connected to Cloud. ";

?>