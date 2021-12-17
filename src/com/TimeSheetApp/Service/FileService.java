package com.TimeSheetApp.Service;

import com.TimeSheetApp.Exceptions.FileException;

import java.io.*;
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

    private File file = null;
    private final Path filePath = Paths.get("C:\\socketwebsite\\files\\chat.txt");

    private void checkFile() {

        if(Files.notExists(this.filePath)) {
                createNewFile();
        };

        file = this.filePath.toFile();


    }

    private void createNewFile() {
        try {
            Files.createFile(this.filePath);
        } catch (IOException e) {
            System.err.println("Could Not create File");
            e.printStackTrace();
        }
    }



    public void readFromFile(){
        try (BufferedReader fileReader = Files.newBufferedReader(this.filePath)){
            String fileContents = null;
            while((fileContents = fileReader.readLine()) != null){
                System.out.println(fileContents);
            }
        }catch (IOException e){
            System.out.println("cannot find this file");
        }
    }


}
