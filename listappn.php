<?php

$mysqli = new mysqli("localhost", "root", "", "medicloud");
$x = 1;
$pid = $_POST["pid"];
$return_arr = array();
$result = $mysqli->query("SELECT doctor_info.dID, name, date, time\n"

    . "FROM appointments, doctor_info\n"

    . "WHERE appointments.dID=doctor_info.dID AND pID='$pid'\n"

    . "ORDER BY date, time");
while( $obj = $result->fetch_object() ) {
   $row_array[$x]['did'] = $obj->dID;
   $row_array[$x]['docname'] = $obj->name;
   $row_array[$x]['date'] = $obj->date;
   $row_array[$x]['time'] = $obj->time;
   $x++;
}
$result->close();
array_push($return_arr,$row_array);
echo json_encode($return_arr);

?>