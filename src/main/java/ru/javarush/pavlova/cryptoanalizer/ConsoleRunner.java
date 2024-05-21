package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;

import java.io.IOException;

public class ConsoleRunner {

    //encode text.txt encode.txt 12
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

    }
}



