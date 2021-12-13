package com.TimeSheetApp.Response;

import java.net.Socket;

public class HTMLResponse {
     private final Socket clientSocket;

     public HTMLResponse (Socket clientSocket){
         this.clientSocket = clientSocket;
     }

     private String createHttpHeader(){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("http 1.1 200 ok");
         stringBuilder.append("\r\n");
         stringBuilder.append("content-type: test/html");
         stringBuilder.append("\r\n");

         return stringBuilder.toString();
     }
}
