<?php
require "connect.php";

$email = $_POST["email"];
$password = $_POST["password"];

$n = $_POST["name"];
$d = $_POST["dob"];
$bg = $_POST["blood_group"];
$x = $_POST["sex"];
$p = $_POST["phone_number"];
$ad = $_POST["address"];

/*$email = "qweqwe";
$password = "qweqwe";

$n = "qweqwe";
$d = "1231";
$bg = "B";
$x = "yes";
$p = "24235";
$ad = "asdasdffsdfs";*/

$query_matching = "SELECT * FROM accounts WHERE email = '$email'";
$result = mysqli_query($conn, $query_matching);
$numof_tupples = mysqli_num_rows($result);

$query_find_id = "SELECT (COUNT(email)+1) AS cid FROM accounts WHERE isDoctor = 0";
$find_id = mysqli_query($conn, $query_find_id);
$row = mysqli_fetch_array($find_id, MYSQLI_ASSOC);
$new_id = $row['cid'];

$query_insert_newacc = "INSERT INTO accounts (email,password,generalID,isDoctor) values ('$email', '$password', '$new_id', 0)";

$query_insert_newpat = "INSERT INTO patients_info (pID, name, dob, blood_group, sex, phone_number, address) values ('$new_id', '$n', '$d', '$bg', '$x', '$p', '$ad')";


if($numof_tupples == 0){
	$sqlacc = mysqli_query($conn, $query_insert_newacc);
	$sqlpat = mysqli_query($conn, $query_insert_newpat);
	if($sqlacc && $sqlpat) echo "New Account No.".$new_id." Created for ".$n;
	else echo "Something went Wrong during Insert";
}else
	echo "Query Error";

?>