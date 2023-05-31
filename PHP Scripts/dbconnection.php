<?php
$db_host = "localhost";
$db_user = "id20816673_admin";
$db_pass = "Root@2003";
$db_name = "id20816673_noticeboard";

$con=mysqli_connect($db_host,$db_user,$db_pass,$db_name);

if(!$con)
    mysqli_error();
    

?>