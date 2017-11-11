<?php
require "login.php";
if($is_loggedin){
	$sql = "INSERT INTO patients (pName,age,gender) VALUES ('Guy Dudeson',25,'m')";
	$query= mysqli_query($conn, $sql);
	if($query)
		echo "Insertion by ".$username." Successful. ";
}
?>