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
   $filename = $_GET['Tablename'];
   $sql = "DELETE FROM $filename;";
   
   if (mysqli_query($conn, $sql)) {
      echo "Table information deleted";
   } else {
      echo "Error: " . mysqli_error($conn);
   }
   
   mysqli_close($conn);
?>