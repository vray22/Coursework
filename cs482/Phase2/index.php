<?php
/**
 * Created by PhpStorm.
 * User: vic
 * Date: 10/29/18
 * Time: 11:40 AM
 */
?>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> CS482 DATABASE</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>NFL Players</h1>

<form action="index.php" method="POST" enctype="multipart/form-data">
    select file to upload for bulk-loading
    <input type="file" name="text" id="text" /><input type="submit" value="Upload text" name="submit"/></form>


<?php
/**
 * Created by PhpStorm.
 * User: vic
 * Date: 10/25/18
 * Time: 4:21 PM
 */

$db = mysqli_connect('127.0.0.1','root', 'PoloFresh03','NFLPlayers')
or die('Error connecting to MySQL server.');




?>
<?php
if(isset($_POST["submit"])){
    if (is_uploaded_file($_FILES['text']['tmp_name'])){
        $fileData2 = ($_FILES['text']['name']);
        if($fileData2 == 'Players.txt'){
            $sql = "LOAD DATA LOCAL INFILE '$fileData2'
                    INTO TABLE Players
                    FIELDS TERMINATED BY ','
                    LINES TERMINATED BY '\\n'
                    (Name, PlayerID, TeamName, Position, Touchdowns, TotalYards, Salary)";
            $time_pre = microtime(true);

            if(mysqli_query($db,$sql)){
                //echo "New record created successfully <br>";

            }else{
                echo "Error: " . $sql . "<br>" . mysqli_error($db);
            }
            $time_post = microtime(true);
            $exec_time = $time_post - $time_pre;
            echo "Time to insert file: $exec_time seconds";
            echo "Data inserted successfully<br>";

        }

        if($fileData2 == 'Games.txt'){
            $sql = "LOAD DATA LOCAL INFILE '$fileData2'
                    INTO TABLE Games
                    FIELDS TERMINATED BY ','
                    LINES TERMINATED BY '\\n'
                    (GameID, Date, Stadium, Result, Attendance, TicketRevenue)";
            $time_pre = microtime(true);

            if(mysqli_query($db,$sql)){
                //echo "New record created successfully <br>";

            }else{
                echo "Error: " . $sql . "<br>" . mysqli_error($db);
            }
            $time_post = microtime(true);
            $exec_time = $time_post - $time_pre;
            echo "Time to insert file: $exec_time seconds";
            echo "Data inserted successfully<br>";

        }

        if($fileData2 == 'Play.txt'){
            $sql = "LOAD DATA LOCAL INFILE '$fileData2'
                    INTO TABLE Play
                    FIELDS TERMINATED BY ','
                    LINES TERMINATED BY '\\n'
                    (PlayerID, GameID)";
            $time_pre = microtime(true);

            if(mysqli_query($db,$sql)){
                //echo "New record created successfully <br>";

            }else{
                echo "Error: " . $sql . "<br>" . mysqli_error($db);
            }
            $time_post = microtime(true);
            $exec_time = $time_post - $time_pre;
            echo "Time to insert file: $exec_time seconds<br>";
            echo "Data inserted successfully<br>";
        }
    }
}

?>


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

<?php
include "deleteForm.html";
?>

</body>
</html>





