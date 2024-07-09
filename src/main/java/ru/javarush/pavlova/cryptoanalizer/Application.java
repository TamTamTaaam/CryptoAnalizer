package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.controllers.MainController;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;

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
            String[] strings = gettingArgumentsFromConsole();
            Result result = mainController.doAction(strings[0], Arrays.copyOfRange(strings, 1, strings.length));
            return result;
        }
    }
    public String[] gettingArgumentsFromConsole() {
        System.out.println("Что делать будем? \n" +
                "1. Шифровать(кодировать)\n" +
                "2. Расшифровывать(декодировать)\n" +
                "3. Брутфорсить(искать ключ зашифрованного текста");
        Scanner scanner = new Scanner(System.in);
        String valueAction = scanner.nextLine();
        while (!(valueAction.equals("1")||valueAction.equals("2")||valueAction.equals("3"))) {
            System.out.println("Введите корректное значение.");
            valueAction = scanner.nextLine();
        }
        System.out.println("Напишите путь к исходному файлу");
        String input = scanner.nextLine();
        String output = "";
        String  key = "";
        String action = "";
        switch (valueAction) {
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



