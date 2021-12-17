package com.TimeSheetApp;

import com.TimeSheetApp.Server.Server;
import com.TimeSheetApp.Service.FileService;

public class Main {

    public static void main(String[] args) {
        Server server = new Server(4848);
        //server.startServer();
        FileService fileService = new FileService();
        fileService.readFromFile();
        //fileService.writeToFile("Hello, I am Ajani \nI wonder if this will overWrite the old content?");
        //fileService.readFromFile();

    }
}
