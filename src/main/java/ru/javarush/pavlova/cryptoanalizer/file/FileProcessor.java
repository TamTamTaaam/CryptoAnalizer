package ru.javarush.pavlova.cryptoanalizer.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public List<String> readFile(String fileName) {
        List<String> result = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;
                while((line = br.readLine()) != null){
                    result.add(line.toLowerCase());
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
    }

    public void writeFile(String output, List<String> result) throws IOException {
        try {
            Path filePath = Path.of(output);
            Files.write(filePath, result);
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        }
    }
}


