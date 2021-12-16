package com.TimeSheetApp.Service;

import com.TimeSheetApp.Exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public FileService() {
        checkFile();
    }

    private void checkFile() {

        Path filepath = Paths.get("C:\\socketwebsite\\files\\chat.txt");

        if(Files.notExists(filepath)) {
            try{
                Files.createFile(filepath);
            }catch(IOException e){
                System.out.println("could not create file at path:" + filepath.toString());
            }
        };
        System.out.println(Files.exists(filepath));


    }

    private void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Could Not create File");
            e.printStackTrace();
        }
    }
}
