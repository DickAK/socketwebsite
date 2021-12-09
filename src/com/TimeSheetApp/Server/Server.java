package com.TimeSheetApp.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port = 4848;
    private static Server instance = null;

    private Server(){

    }

    public static Server getInstance(){
        if(instance == null){
            instance = new Server();
        }

        return instance;
    }

    public void startServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            Socket connection = serverSocket.accept();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
