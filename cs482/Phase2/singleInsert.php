<?php
#TODO Create button so user can delete from appropriate table.
#Do we want the users to enter the table name or do we assume it's only  'Players'?

   $dbhost = '127.0.0.1';
   $dbuser = 'root';
   $dbpass = 'PoloFresh03';
   $dbname = 'NFLPlayers';
   $conn = mysqli_connect($dbhost, $dbuser, $dbpass,$dbname);
   if(!$conn) {
		die(mysqli_error($conn));
   }
ini_set('max_execution_time', 300);

$fh = fopen($_GET["filename"],'r');
   //echo "$fh <br>";
   $filename = str_replace(".txt", "", $_GET["filename"]);
   //echo "$filename <br>";

		    //echo "$line <br>";

		    if($filename == 'Players') {

                $start = microtime(true);

                while ($line = fgets($fh)) {
                    list($a, $b, $c, $d, $e, $f, $g) = array_pad(explode(",", $line, 7), 7, null);
                    $sql = "INSERT INTO $filename (Name,PlayerID,TeamName,Position,Touchdowns,TotalYards,Salary) values ('$a','$b','$c','$d','$e','$f','$g')";

                    if (mysqli_query($conn, $sql)) {
                        //echo "Single inserton complete";
                    } else {
                        echo "Error: " . mysqli_error($conn);
                    }
                }
                $end = microtime(true);
                $diff = $end - $start;
                $time = number_format($diff, 10);
                echo "Time to execute $time";
            }
            if($filename == 'Games') {

                $start = microtime(true);

                while ($line = fgets($fh)) {


                    list($a, $b, $c, $d, $e, $f) = array_pad(explode(",", $line, 6), 6, null);
                    $sql = "INSERT INTO $filename (GameID,Date,Stadium,Result,Attendance,TicketRevenue) values ('$a','$b','$c','$d','$e','$f')";
                    if (mysqli_query($conn, $sql)) {
                        //echo "Single inserton complete";
                    } else {
                        echo "Error: " . mysqli_error($conn);
                    }
                }
                $end = microtime(true);
                $diff = $end - $start;
                $time = number_format($diff, 10);
                echo "Time to execute $time";
            }

            if($filename == 'Play') {
                $start = microtime(true);

                while ($line = fgets($fh)) {

                    list($a,$b)=array_pad(explode(",",$line, 2), 2, null);
                $sql = "INSERT INTO $filename (PlayerID, GameID) values ('$a','$b')";
                if (mysqli_query($conn, $sql)) {
                    //echo "Single inserton complete";
                } else {
                    echo "Error: " . mysqli_error($conn);
                }
            }
                $end = microtime(true);
                $diff = $end - $start;
                $time = number_format($diff, 10);
                echo "Time to execute $time";
		}


	fclose($fh);




   

   
   mysqli_close($conn);
?>