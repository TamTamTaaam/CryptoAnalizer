package ru.javarush.pavlova.cryptoanalizer.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProcessor {

    public static List<String> readFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();
//            try {
//            Path filePath = Path.of(input);
//            return Files.lines(filePath).map(String::toLowerCase).collect(Collectors.toCollection(ArrayList::new));
//        } catch (Exception e) {
//            throw new IOException(e.getMessage());
//        }
            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
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

    public static void writeFile(String output, ArrayList<String> result) throws IOException {
        try {
            Path filePath = Path.of(output);
            Files.write(filePath, result, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IOException(e.getMessage(), e);
        }
    }
}


