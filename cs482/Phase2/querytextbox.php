<!DOCTYPE html PUBLIC >  
<head>  
 
<meta http-equiv="content-type"  
    content="text/html; charset=utf-8"/>  
</head>  
<body>  
<p>  
  <?php

  //Resolves magic quotes conflict
  if (get_magic_quotes_gpc())   
  {   
    function stripslashes_deep($value)   
    {   
      $value = is_array($value) ?   
          array_map('stripslashes_deep', $value) :   
          stripslashes($value);   
     
      return $value;   
    }   
     
    $_POST = array_map('stripslashes_deep', $_POST);   
    $_GET = array_map('stripslashes_deep', $_GET);   
    $_COOKIE = array_map('stripslashes_deep', $_COOKIE);   
    $_REQUEST = array_map('stripslashes_deep', $_REQUEST);   
  }
  
  ?> 
</p>
  <!-- Query textbox -->
  
  <style type = "text/css">
  Textarea {
    display: block;
    width: 100%;
  }
  </style>
  <p>
  <form action = "query.php" method="post">
    <div>
      <label for="querystring">Enter a query:</label>
      <textarea id="querystring" name="querystring" rows="4" cols="30"></textarea>
    </div>
    <div><input type="submit" value="Query"/></div>
  </form>
  </p>

  <form action = "delete.php" method="post">
    <div>
      <label for="deletestring">Delet a table:</label>
      <textarea id="deletestring" name="deletestring"></textarea>
    </div>
    <div><input type="submit" value="Delete"/></div>
  </form>
</body>  
</html>

