/**
* Web worker: an object of this class executes in its own new thread
* to receive and respond to a single HTTP request. After the constructor
* the object executes on its "run" method, and leaves when it is done.
*
* One WebWorker object is only responsible for one client connection. 
* This code uses Java threads to parallelize the handling of clients:
* each WebWorker runs in its own thread. This means that you can essentially
* just think about what is happening on one client at a time, ignoring 
* the fact that the entirety of the webserver execution might be handling
* other clients, too. 
*
* This WebWorker class (i.e., an object of this class) is where all the
* client interaction is done. The "run()" method is the beginning -- think
* of it as the "main()" for a client interaction. It does three things in
* a row, invoking three methods in this class: it reads the incoming HTTP
* request; it writes out an HTTP header to begin its response, and then it
* writes out some HTML content for the response content. HTTP requests and
* responses are just lines of text (in a very particular format). 
*
**/

import java.net.Socket;
import java.lang.Runnable;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class WebWorker implements Runnable
{
 
private Socket socket;
    private boolean answer = true; //answer that will be used to send correct response status 
 private boolean isImage = false;
 private String imageType = "";

/**
* Constructor: must have a valid open socket
**/
public WebWorker(Socket s)
{
   socket = s;
}

/**
* Worker thread starting point. Each worker handles just one HTTP 
* request and then returns, which destroys the thread. This method
* assumes that whoever created the worker created it with a valid
* open socket object.
**/
public void run()
{
   System.err.println("Handling connection...");
   try {
      InputStream  is = socket.getInputStream();
      OutputStream os = socket.getOutputStream();
      String filePath = readHTTPRequest(is);
      //bunch of if statements to see what directory to look into
      //also check request type if it contains image files if so it will write correct http header 
      if(filePath.equals("/test/test")){ 
         filePath = filePath + ".html";
         writeHTTPHeader(os,"text/html");
      }
      else if(filePath.equals("/test/test2")){
           filePath = filePath + ".html";
           writeHTTPHeader(os,"text/html");
        
      }
      else if(filePath.equals("/test/test3")){
          filePath = filePath + ".jpg";
          writeHTTPHeader(os,"image/jpeg");
          isImage = true; 
          imageType = "jpeg";
      }
      else if(filePath.equals("/test/test4")){
          filePath = filePath + ".gif";
          writeHTTPHeader(os,"image/gif");
          isImage = true;
          imageType = "gif";
      }
      else if(filePath.equals("/test/test5")){
           filePath = filePath + ".png";
           writeHTTPHeader(os,"image/png");
           isImage = true;
           imageType = "png";
      }
      else if(filePath.contains("jpg")){
           writeHTTPHeader(os,"image/jpeg");
           isImage = true;
           imageType = "jpeg";
      }
      else if(filePath.contains("gif")){
           writeHTTPHeader(os,"image/gif");
           isImage = true;
           imageType = "gif";
       }
       else if(filePath.contains("png")){
           writeHTTPHeader(os,"image/png");
           isImage = true;
           imageType = "png";
      }
     
      System.out.println("file path is: " + filePath);
      writeContent(os, filePath);
      os.flush();
      socket.close();
   } catch (Exception e) {
      System.err.println("Output error: "+e);
   }
   System.err.println("Done handling connection.");
   return;
}

/**
* Read the HTTP request header.
**/
private String readHTTPRequest(InputStream is)
{
    //create my strings to get the file path plus the first line 
   String line; 
   String line2 = "";
   int count = 0;  //count to determine if first line has been obtained 
   BufferedReader r = new BufferedReader(new InputStreamReader(is)); 
      while (true) {
      try {
         //BufferedReader r = new BufferedReader(new InputFileReader("."+ important));
         while (!r.ready()) Thread.sleep(1);
         line = r.readLine();
         if(count == 0){
             String a[] = line.split(" ");//split line
             line2 = a[1];//file path becomes string in array 2
	     // System.err.println(line2); 
	     count++; 
         }
                  System.err.println("Request line: ("+line+")");
         if (line.length()==0) break;
      } catch (Exception e) {
	  answer = false; //if file could not be opened doesn't exist answer is false now 
         System.err.println("Request error: "+e);
         break;
      }
   }
   return line2;
}

/**
* Write the HTTP header lines to the client network connection.
* @param os is the OutputStream object to write to
* @param contentType is the string MIME content type (e.g. "text/html")
**/
private void writeHTTPHeader(OutputStream os, String contentType) throws Exception
{
   Date d = new Date();
   DateFormat df = DateFormat.getDateTimeInstance();
   df.setTimeZone(TimeZone.getTimeZone("GMT"));
   //if statement to determine what response status to send 
   if(answer == true){
      os.write("HTTP/1.1 200 OK\n".getBytes());
   }
   else if(answer == false){
       os.write("HTTP/1.1 404 OK\n".getBytes());
   }
   os.write("Date: ".getBytes());
   os.write((df.format(d)).getBytes());
   os.write("\n".getBytes());
   os.write("Server: Jon's very own server\n".getBytes());
   //os.write("Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT\n".getBytes());
   //os.write("Content-Length: 438\n".getBytes()); 
   os.write("Connection: close\n".getBytes());
   os.write("Content-Type: ".getBytes());
   os.write(contentType.getBytes());
   os.write("\n\n".getBytes()); // HTTP header ends with 2 newlines
   return;
}

/**
* Write the data content to the client network connection. This MUST
* be done after the HTTP header has been written out.
* @param os is the OutputStream object to write to
**/
private void writeContent(OutputStream os, String filePath) throws Exception
{
   int temp = 0;
String temp3 = "";
   String temp2 = ""; 
    
   try{
//if request is not an image will simply put out the html text in file line by line 
   if(isImage == false){
       BufferedReader t = new BufferedReader(new FileReader("." + filePath));
       while((temp3 = t.readLine()) != null){
            
               temp2 += temp3;
             
         }
     os.write(temp2.getBytes());
  }
    
   
   /**
    will use bufferedImage, byteArrayOutputStream, to send bytes of image to browser upon request 
**/
   else if(isImage == true){
       File file = new File("." + filePath);
       BufferedImage pic = ImageIO.read(file);
       ByteArrayOutputStream byte1 = new ByteArrayOutputStream();
       ImageIO.write(pic, imageType, byte1);
       os.write(byte1.toByteArray());
   }
 
  }catch(Exception e){
       //print message body for 404 not found 
	System.err.println("Request error: "+e);
        os.write("<html><head></head><body>\n".getBytes());
        os.write("<h3>404 page not found</h3>\n".getBytes());
	os.write("The requested URL ".getBytes());
	os.write(filePath.getBytes());
	os.write(" was not found on this server\n".getBytes());
        os.write("</body></html>\n".getBytes());
   }

  
}//end of writeContent method 


} // end class
