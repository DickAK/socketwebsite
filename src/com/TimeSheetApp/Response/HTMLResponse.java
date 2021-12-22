package com.TimeSheetApp.Response;

import com.TimeSheetApp.Service.FileService;

import java.io.*;
import java.net.Socket;


public class HTMLResponse {
     private final Socket clientSocket;
     private FileService fileService = new FileService();

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
                 "    <title>Socket Server</title>" +
                 "    <style> " +
                 "      body{" +
                 "          margin: 0;" +
                 "          padding: 0;" +
                 "      }" +
                 " {box-sizing: border-box;}\n" +
                 "\n" +

                 "\n" +
                 "/* The popup chat */\n" +
                 ".form-popup {\n" +
                 "  display: none;\n" +
                 "  position: fixed;\n" +
                 "  bottom: 0;\n" +
                 "  right: 15px;\n" +
                 "  border: 3px solid #f1f1f1;\n" +
                 "  z-index: 9;\n" +
                 "}\n" +
                 "\n" +
                 "/* the form container */\n" +
                 ".form-container {\n" +
                 "  max-width: 300px;\n" +
                 "  padding: 10px;\n" +
                 "  background-color: white;\n" +
                 "}\n" +
                 "\n" +
                 "/* Full-width textarea */\n" +
                 ".form-container textarea {\n" +
                 "  width: 100%;\n" +
                 "  padding: 15px;\n" +
                 "  margin: 5px 0 22px 0;\n" +
                 "  border: none;\n" +
                 "  background: #f1f1f1;\n" +
                 "  resize: none;\n" +
                 "  min-height: 200px;\n" +
                 "}\n" +
                 "\n" +
                 "/* When the textarea gets focus, do something */\n" +
                 ".form-container textarea:focus {\n" +
                 "  background-color: #ddd;\n" +
                 "  outline: none;\n" +
                 "}\n" +
                 "\n" +
                 "/* Set a style for the submit/login button */\n" +
                 ".form-container .btn {\n" +
                 "  background-color: #04AA6D;\n" +
                 "  color: white;\n" +
                 "  padding: 16px 20px;\n" +
                 "  border: none;\n" +
                 "  cursor: pointer;\n" +
                 "  width: 100%;\n" +
                 "  margin-bottom:10px;\n" +
                 "  opacity: 0.8;\n" +
                 "}\n" +
                 "\n" +
                 "/* cancel button */\n" +
                 ".form-container .cancel {\n" +
                 "  background-color: red;\n" +
                 "}\n" +
                 "\n" +
                 "/* hover effects to buttons */\n" +
                 ".form-container .btn:hover, .open-button:hover {\n" +
                 "  opacity: 1;\n" +
                 "} "+
                 "    </style>" +
                 "</head>" +
                 "<body>") ;

         stringBuilder.append("<h1> Welcome this is a java socket server chat app </h1>");

         stringBuilder.append(" <div class=\"chat-popup\" id=\"myForm\">\n" +
                 "  <form action=\"//localhost:4848\" method=\"GET\" class=\"form-container\">\n" +
                 "    <h1>Chat</h1>\n" +
                 "\n" +
                 "    <label for=\"msg\"><b>Message</b></label>\n" +
                 "    <textarea placeholder=\"Type message..\" name=\"msg\" required></textarea>\n" +
                 "\n" +
                 "    <button type=\"submit\" class=\"btn\">Send</button>\n" +
                 "    <button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Close</button>\n" +
                 "  </form>\n" +
                 "</div> ");
         stringBuilder.append("</body></html>");
         return stringBuilder.toString();


     }

     public void generateResponse(){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append(createHttpHeader());
         stringBuilder.append("\r\n");
         stringBuilder.append(createHtmlPage());



         try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(),true)){

             String requestContent = null;

             String params = null;

             while((requestContent = bufferedReader.readLine()) != null){
                 if(requestContent.indexOf("GET") > -1){
                     params = requestContent.substring(requestContent.indexOf("GET")+10 )
                             .replaceAll("HTTP/1.1","")
                     .replaceAll("\\+"," ");

                 }

                 System.out.println(requestContent);
                 if(requestContent.isEmpty())break;
             }
             System.out.println(params);
             fileService.writeToFile(params);

             out.println(stringBuilder);
         }catch (Exception e){
             System.out.println("there was an issue writing the response");
         }
     }

}
