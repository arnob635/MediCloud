<?php

$mysqli = new mysqli("localhost", "root", "", "medicloud");
$x = 1;
$return_arr = array();
$result = $mysqli->query("SELECT * FROM doctor_info");
while( $obj = $result->fetch_object() ) {
   $row_array[$x]['name'] = $obj->name;
   $row_array[$x]['did'] = $obj->dID;
   $row_array[$x]['spec'] = $obj->specialty;
   $row_array[$x]['qual'] = $obj->qualifications;
   $row_array[$x]['sex'] = $obj->sex;
   $row_array[$x]['phone'] = $obj->phone;
   $row_array[$x]['clinadd'] = $obj->clinic_address;
   $x++;
}
$result->close();
array_push($return_arr,$row_array);
echo json_encode($return_arr);

?>