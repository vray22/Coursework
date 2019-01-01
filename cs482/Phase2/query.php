<?php   
ini_set('memory_limit', '-1');
//connect to DB
$link = mysqli_connect('127.0.0.1','root', 'PoloFresh03','NFLPlayers')
or die('Error connecting to MySQL server.');

//checks if the database was connected to
if (!$link)   
{   
  $error = 'Unable to connect to the database server.';   
  include 'error.html.php';   
  exit();   
}

//Checks to make sure the encoding is utf8
if (!mysqli_set_charset($link, 'utf8'))   
{   
  $output = 'Unable to set database connection encoding.';   
  include 'output.html.php';   
  exit();   
}

//Checks to make sure the database was located
if (!mysqli_select_db($link, 'NFLPlayers'))
{   
  $error = 'Unable to locate the database.';   
  include 'error.html.php';   
  exit();   
}

//Variables for query
$querystring = $_POST['querystring'];
$starttime = microtime(true);
$queryresult = mysqli_query($link, $querystring);
$endtime = microtime(true);
$elapsedtime = $endtime - $starttime;
$fieldinfo = mysqli_fetch_fields($queryresult);
$numrows = $queryresult->num_rows;

//If query is not valid
if (!$queryresult)  
{  
  $error = 'Error with Query: ' . mysqli_error($link);  
  include 'error.html.php';  
  exit();  
}

//Get the results from the query and store as an array of arrays
$post = array();
while($row = mysqli_fetch_array($queryresult, MYSQLI_NUM)) {
    $post[] = $row;
}

//Make sure we have results
if ($numrows > 0) {

    //Styling for the results table
    //1px black border around each cell
    echo "<style> table, th, td { border: 1px solid black; } </style>";
    echo "<table><tr>";

    //Print the column titles
    foreach($fieldinfo as $val) 
    { 
    
        echo "<th>$val->name</th>"; //<th></th> represents header of table
    
    } 
    echo "</tr>";
    
    /*  
    Print the query results in a table
    code between <tr></tr> represents one row 
    code between <td></td> represents one cell in a row
    */
    
    foreach($post as $row) {
        echo "<tr>";
        foreach($row as $element) {
            echo "<td>".$element. "</td>";
        }
        echo "</tr>";
    }
    echo "</table>";

//Display the time it took to run the query
echo "<p>It took " .$elapsedtime. " seconds to run this query.</p>";
}

//We had no results
else {
    echo "<p> 0 Results </p>";
}
?>

<!-- Link to previous page -->
<a href="javascript:history.back()">Go Back</a>