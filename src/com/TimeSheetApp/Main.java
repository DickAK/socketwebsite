package com.TimeSheetApp;

import com.TimeSheetApp.Server.Server;

public class Main {

    public static void main(String[] args) {
        Server server = new Server(4848);
        server.startServer();
    }
}
