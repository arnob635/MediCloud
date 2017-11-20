<?php

$host = 'localhost';
$user= 'jawadak';
$pass= 'medicloud';
$db='jawadak_medicloud';

$conn = mysqli_connect($host,$user,$pass,$db);
if($conn)
echo "Connected to Cloud. ";

?>