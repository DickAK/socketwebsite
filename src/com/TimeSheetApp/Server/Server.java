package com.TimeSheetApp.Server;

import com.TimeSheetApp.Response.HTMLResponse;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private int port;

    public Server(int portNumber){
        this.port = portNumber;
    }

    public void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            System.out.println("Server Is Starting");
            System.out.println(serverSocket.getLocalSocketAddress());
            while(true){
                Socket socket = serverSocket.accept();

                HTMLResponse response = new HTMLResponse(socket);
                response.generateResponse();
                response=null;
            }
        }catch (IOException e){
            System.err.println("Could Not Start Server On This Port");
        }

    }
}
