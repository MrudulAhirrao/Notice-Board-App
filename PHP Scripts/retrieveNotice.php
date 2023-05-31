<?php
  include_once('./dbconnection.php');
  
  $result = array();
  $result['notice'] = array(); 
  $select = "SELECT * from notice";
  $response = mysqli_query($con,$select);
  
  while($row = mysqli_fetch_array($response))
  {
      $index['id'] = $row['0'];
      $index['title'] = $row['1'];
      $index['desc'] = $row['2'];
      $index['date'] = $row['3'];
      
      array_push($result['notice'], $index);
  }
  $result['success'] = "1";
  echo json_encode($result);
?>