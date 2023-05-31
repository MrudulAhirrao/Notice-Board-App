<?php
  include_once('./dbconnection.php');
if(isset($_POST['id']) && isset($_POST['title']) && isset($_POST['desc']) && isset($_POST['date']))
{
 
    $id = $_POST["id"];
    $title = $_POST["title"];
    $desc = $_POST["desc"];
    $date = $_POST["date"];
    
    if(!$con)
    {
        mysqli_error();
    }
    else
    {
        $que = "Update notice SET notice.title = '$title', notice.desc= '$desc', notice.date = '$date' Where notice.id = '$id'";
        if(mysqli_query($con,$que))
        {
            echo json_encode(1);
        }
        else
            echo json_encode(0);
    }
}



?>