<?php
header('Content-Type: application/json');
$host = 'localhost';
$user= 'root';
$pass= '';
$db='medicloud';

$conn = mysqli_connect($host,$user,$pass,$db);
//$docname = $_POST["docname"];
$did = $_POST["did"];

//$docname = "Abir Rahman";
//$did = "1";

$test_sql_query = "SELECT * FROM doctor_info WHERE dID = '$did'";
$result = mysqli_query($conn, $test_sql_query);
$query_array = mysqli_fetch_array($result);

mysqli_close($conn);

$doc_array = array();
$doc_array["name"] = $query_array['name'];
$doc_array["did"] = $query_array['dID'];
$doc_array["spec"] = $query_array['specialty'];
$doc_array["sex"] = $query_array['sex'];
$doc_array["phone"] = $query_array['phone'];
$doc_array["address"] = $query_array['clinic_address'];
$doc_array["qual"] = $query_array['qualifications'];

$doc_array["success"] = mysqli_num_rows($result) > 0;

echo json_encode($doc_array);
?>