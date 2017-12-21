<?php
header('Content-Type: application/json');
$host = 'localhost';
$user= 'root';
$pass= '';
$db='medicloud';

$conn = mysqli_connect($host,$user,$pass,$db);
$username = $_POST["username"];
$user_pass = $_POST["password"];
//$username = "abir69@gmail.com";
//$user_pass = "123";

$test_sql_query = "SELECT isDoctor, generalID FROM accounts WHERE email = '$username' AND password = '$user_pass'";
$result = mysqli_query($conn, $test_sql_query);
$query_array = mysqli_fetch_array($result);
$isdoc = $query_array['isDoctor'];
$user_id = $query_array['generalID'];

$login_array = array();
$login_array["isDoc"] = $query_array['isDoctor'];
if(!$isdoc){
	$login_query = "SELECT * FROM accounts, patients_info WHERE accounts.generalID=patients_info.pID AND isDoctor = '$isdoc' AND pID = '$user_id'";
	$result_p = mysqli_query($conn, $login_query);
	$query_array_p = mysqli_fetch_array($result_p,MYSQLI_ASSOC);
	$login_array["patname"] = $query_array_p["name"];
	$login_array["dob"] = $query_array_p['dob'];
	$login_array["bg"] = $query_array_p['blood_group'];
	$login_array["sex"] = $query_array_p['sex'];
	$login_array["phone"] = $query_array_p['phone_number'];
	$login_array["address"] = $query_array_p['address'];
}else{
	$login_query = "SELECT * FROM accounts, doctor_info WHERE accounts.generalID=doctor_info.dID AND isDoctor = '$isdoc' AND dID = '$user_id'";
	$result_d = mysqli_query($conn, $login_query);
	$query_array_p = mysqli_fetch_array($result_d,MYSQLI_ASSOC);
	$login_array["patname"] = $query_array_p['name'];
	$login_array["dob"] = $query_array_p['dob'];
	$login_array["bg"] = $query_array_p['blood_group'];
	$login_array["sex"] = $query_array_p['sex'];
	$login_array["phone"] = $query_array_p['phone_number'];
	$login_array["address"] = $query_array_p['address'];
}
mysqli_close($conn);

$is_loggedin = mysqli_num_rows($result) > 0;
$login_array["success"] = $is_loggedin;
echo json_encode($login_array);
?>