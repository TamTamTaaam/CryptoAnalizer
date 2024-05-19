package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;

public class ConsoleRunner {

    //encode text.txt encode.txt 12
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

    }
}

/* Класс вызывает апликатион передает ему какие-нибудь аргументы, апликатион запускается


 */

