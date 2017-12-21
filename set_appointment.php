<?php
$host = 'localhost';
$user= 'root';
$pass= '';
$db='medicloud';

$conn = mysqli_connect($host,$user,$pass,$db);

$pID= $_POST["pID"];
$dID = $_POST["dID"];
$date = $_POST["apnDate"];

date_default_timezone_set('Asia/Dhaka');
$today = date("Y-m-d");
if($today>$date){
	mysqli_close($conn);
	exit("Date Set has Already Passed");
}

$query = "SELECT COUNT(time) AS c FROM appointments WHERE date = '$date' and dID = '$dID'";
$query_check = mysqli_query($conn, $query);
$query_check = mysqli_fetch_array($query_check , MYSQLI_ASSOC)['c'];


$timevar = 0;
if ($query_check<1) $timevar = 1;
else if($query_check>=1 && $query_check<12){
	$time = "SELECT MAX(time)+1 AS max FROM appointments WHERE 1";
	$timevar = mysqli_query($conn, $time);
	$timevar = mysqli_fetch_array($timevar, MYSQLI_ASSOC)['max'];
}
else{
	mysqli_close($conn);
	exit("Sorry NO Vacancies Today!");
}

if($timevar>0){
	$query_insert = "INSERT INTO appointments (pID, dID, date, time) VALUES ('$pID', '$dID', '$date', '$timevar')";
	$sqlsapnt = mysqli_query($conn, $query_insert);
	if($sqlsapnt) echo "Appointment Set for ".$date."\n"."with DocNo.".$dID." Slot:".$timevar;
	else echo "You already have an appointment that day";
}
else echo "Something went wrong";
mysqli_close($conn);
?>