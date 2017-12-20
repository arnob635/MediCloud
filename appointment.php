<?php
require "connect.php";

//$Date = $_POST["Date"];
//$Time = $_POST["Time"];
//$dID = $_POST["dID"];
//$pID = $_POST["pID"];

$Date = "2017-07-02";
$Time = "08:30:00";

$p = "2";
$do = "1";

$query_matching = "SELECT * FROM appointments WHERE pID = '$p' and dID='$do' ";
$result = mysqli_query($conn, $query_matching);
$numof_tupples = mysqli_num_rows($result);

/*$query_find_id = "SELECT (COUNT(email)+1) AS cid FROM accounts WHERE isDoctor = 0";
$find_id = mysqli_query($conn, $query_find_id);
$row = mysqli_fetch_array($find_id, MYSQLI_ASSOC);
$new_id = $row['cid'];*/

//$query_insert_newapnt = "INSERT INTO appointments (pID,dID,Date,Time) values ('$pID', '$dID', '$Date', '$Time')";

$query_insert_newapnt = "INSERT INTO appointments (pID,dID,Date,Time) values ('$p', '$do', '$Date', '$Time')";
/*$query_insert_newpat = "INSERT INTO patients_info (pID, name, dob, blood_group, sex, phone_number, address) values ('$new_id', '$n', '$d', '$bg', '$x', '$p', '$ad')";*/


if($numof_tupples == 0){
	$sqlapnt = mysqli_query($conn, $query_insert_newapnt);
	if($sqlapnt) echo "New Appointment Schedeuled for.".$Date. " at " .$Time ;
	else echo "Something went Wrong during Insert";
}else
	echo "Query Error";

mysqli_close($conn);

?>
