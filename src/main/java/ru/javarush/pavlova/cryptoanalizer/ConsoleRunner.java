package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

    }
}

/* Класс вызывает апликатион передает ему какие-нибудь аргументы, апликатион запускается


 */

//        String text = "Привет медвед!"; //должен быть файл на диске с текстом из аргументов<<<args
//        int key=123; //из аргументов<<<args
//        String result = "....."; // <<<args
