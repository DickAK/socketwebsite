package com.TimeSheetApp.Server;

import com.TimeSheetApp.Response.HTMLResponse;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;

    public Server(int portNumber){
        this.port = portNumber;
    }

    public void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            System.out.println("Server Is Starting");

            while(true){
                System.out.println("Server Is running on port:" + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();

                HTMLResponse response = new HTMLResponse(socket);
                response.generateResponse();
            }
        }catch (IOException e){
            System.err.println("Could Not Start Server On This Port");
        }

    }
}
