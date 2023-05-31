<?php
  include_once('./dbconnection.php');
if(isset($_POST['name']) && isset($_POST['prn']) && isset($_POST['email']) && isset($_POST['year']) &&isset($_POST['division'])&& isset($_POST['password']))
{
 
    $name = $_POST["name"];
    $prn = $_POST["prn"];
    $email = $_POST["email"];
    $year = $_POST["year"];
    $division = $_POST["division"];
    $password = $_POST["password"];
    
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "insert into student values('$name','$prn','$email','$year','$division','$password')";
        
        $result = mysqli_query($con, $que);
        
        $count = mysqli_num_rows($result);
        
        if($count === 1)
        {
            echo "Success";
        }
        else
        {
            echo "Failed";
        }
    }
}



?>