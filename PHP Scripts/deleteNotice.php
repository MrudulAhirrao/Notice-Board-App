<?php
  include_once('./dbconnection.php');

$id = $_POST["id"];
$sql = "DELETE FROM notice WHERE id = '$id'";

$result = mysqli_query($con,$sql);
if($result)
{
    echo "Data Deleted";
}
else{
    echo "failed";
}
?>