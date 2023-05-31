<?php
include_once('./dbconnection.php');
if(isset($_POST['id']) && isset($_POST['password']))
{
 
    $id = $_POST["id"];
    $password = $_POST["password"];
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "SELECT * FROM teacher where id = '$id' AND password = '$password'";
        $result = mysqli_query($con,$que);
        
        $count = mysqli_num_rows($result);
        
        if(count === 1)
            echo "Success";
        else
            echo "Failed";
    }
}



?>