package com.TimeSheetApp.Response;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class HTMLResponse {
     private final Socket clientSocket;

     public HTMLResponse (Socket clientSocket){
         this.clientSocket = clientSocket;
     }

     private String createHttpHeader(){

         return "HTTP/1.1 200 ok" +
                 "\r\n" +
                 "content-type: text/html" +
                 "\r\n";
     }

     private String createHtmlPage(){
         StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n" +
                 "<html lang=\"en\">\n" +
                 "<head>" +
                 "    <meta charset=\"UTF-8\">" +
                 "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                 "    <title>Document</title>" +
                 "</head>" +
                 "<body>") ;

         stringBuilder.append("</body></html>");
         return stringBuilder.toString();


     }

     public void generateResponse(){
         try {
             PrintStream printStream = new PrintStream(clientSocket.getOutputStream(),true);
             printStream.println(createHttpHeader());
             printStream.println(createHtmlPage());
             printStream.close();
         }catch (IOException e){
             System.err.println("Issue grabing the output stream to the client");
         }
     }

}
