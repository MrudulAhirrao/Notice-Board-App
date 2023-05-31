<?php
  include_once('./dbconnection.php');
if(isset($_POST['id']) && isset($_POST['name']) && isset($_POST['email']) && isset($_POST['department']) && isset($_POST['password']))
{
 
    $id = $_POST["id"];
    $name = $_POST["name"];
    $email = $_POST["email"];
    $department = $_POST["department"];
    $password = $_POST["password"];
    
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "insert into teacher values('$id','$name','$email','$department','$password')";
        if(mysqli_query($con,$que))
        {
            echo json_encode(1);
        }
        else
            echo json_encode(0);
    }
}



?>