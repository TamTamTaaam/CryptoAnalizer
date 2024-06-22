package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.controllers.MainController;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.exceptions.AppException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Application {
    private final MainController mainController;
    public Application() {
        mainController=new MainController();

    }
    public Result run(String[] args) throws IOException {
        if (args.length>0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            Result result = mainController.doAction(action, parameters);
            return result;
        } else {
            String[] strings = whatToDo();
            Result result = mainController.doAction(strings[0], Arrays.copyOfRange(strings, 1, strings.length));
            return result;
        }
    }
    public String[] whatToDo() {
        System.out.println("Что делать будем? \n" +
                "1. Шифровать(кодировать)\n" +
                "2. Расшифровывать(декодировать)\n" +
                "3. Брутфорсить(искать ключ зашифрованного текста");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        while (!(value.equals("1")||value.equals("2")||value.equals("3"))) {
            System.out.println("Введите корректное значение.");
            value = scanner.nextLine();
        }
        System.out.println("Напишите путь к исходному файлу");
        String input = scanner.nextLine();
        String output = "";
        String  key = "";
        String action = "";
        switch (value) {
            case "1" :
                action = "encode";
                System.out.println("Напишите путь, в котором должен лежать готовый файл");
                output = scanner.nextLine();
                System.out.println("Напишите значение ключа");
                key = scanner.nextLine();
                break;
            case "2" :
                action = "decode";
                System.out.println("Напишите путь, в котором должен лежать готовый файл");
                output = scanner.nextLine();
                System.out.println("Напишите значение ключа");
                key = scanner.nextLine();
                break;
            case "3":
                action = "bruteforce";
                break;
        }
        String[] arguments = {action, input, output, key};
        return arguments;
    }

}



