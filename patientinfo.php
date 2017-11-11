<?php
//connect code
$host = 'localhost';
$user= 'root';
$pass= '';
$db='testdb';
$con=mysqli_connect($host,$user,$pass,$db);
if($con)
echo "connected" ."<br>";
//query code
$sql = "SELECT * FROM patient";
$result= mysqli_query($con,$sql);
//$result = mysqli_query($con,$query);
if($result)
	echo " succes  " ."<br>";
if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) {
        echo "Name: " . $row["Name"]. "  - ID: " . $row["ID"]. "  - Phone Number " . $row["Phone_Number"]. "<br>";
    }
} else {
    echo "0 results";
}
?>