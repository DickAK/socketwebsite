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

        if (Files.notExists(this.filePath)) {
            createNewFile();
        }
        ;

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

    public String readFromFile() {
        StringBuilder fileContents = new StringBuilder();
        try (BufferedReader fileReader = Files.newBufferedReader(this.filePath)) {

            do {
                fileContents.append(String.format("%s \r\n", fileReader.readLine()));
            } while (fileReader.ready());

        } catch (IOException e) {
            System.out.println("cannot find this file");
        }

        return fileContents.toString().trim();
    }

    public void writeToFile(String contentToWrite) {
        StringBuilder fileData = new StringBuilder();

        String currentFileContant = null;
        if(!(currentFileContant = readFromFile()).equals("null"))
            fileData.append(currentFileContant);
        fileData.append(contentToWrite);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)) {
            bufferedWriter.write(fileData.toString());
        } catch (IOException e) {
            System.err.println("had issues opening this file for writing");
        }
    }
}
