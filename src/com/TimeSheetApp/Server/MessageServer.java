package com.TimeSheetApp.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    private int port;

    public MessageServer (int port){
        this.port = port;
    }

    private void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            while(true){
                Socket clientSocket = serverSocket.accept();
            }
        }catch (IOException e){
            System.err.println("Server could not be started on this port");
        }
    }
}
