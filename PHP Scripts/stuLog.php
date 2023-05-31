<?php
include_once('./dbconnection.php');
if(isset($_POST['name']) && isset($_POST['password']))
{
 
    $name = $_POST["name"];
    $password = $_POST["password"];
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "SELECT * FROM student where name = '$name' AND password = '$password'";
        $result = mysqli_query($con,$que);
        
        $count = mysqli_num_rows($result);
        
        if(count === 1)
            echo "Success";
        else
            echo "Failed";
    }
}



?>