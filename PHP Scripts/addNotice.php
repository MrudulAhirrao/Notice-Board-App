<?php
  include_once('./dbconnection.php');
if(isset($_POST['title']) && isset($_POST['desc']) && isset($_POST['date']))
{
 
    $title = $_POST["title"];
    $desc = $_POST["desc"];
    $date = $_POST["date"];
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "INSERT INTO notice(notice.title,notice.desc,notice.date) VALUES('$title','$desc','$date')";
        if(mysqli_query($con,$que))
        {
            echo json_encode(1);
        }
        else
            echo json_encode(0);
    }
}



?>