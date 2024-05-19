package ru.javarush.pavlova.cryptoanalizer;

import ru.javarush.pavlova.cryptoanalizer.controllers.MainController;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.exceptions.AppException;

import java.util.Arrays;


public class Application {
    private final MainController mainController;
    public Application() {
        mainController=new MainController();

    }

    public Result run(String[] args)  {
        //encode text.txt encode.txt 12
        if (args.length>0) {
            String action = args[0]; //encode
            String[] parameters = Arrays.copyOfRange(args, 1, args.length); // parameters - ext.txt encode.txt 12
            Result result = mainController.doAction(action, parameters);
            return result;
        } else {
            throw new AppException("no args");
        }

    }
}

/*
Апликатион состоит из каких-то элементов: контроллера, командс, логерров, - разных сервисов, все сервисы будем собирать в апликатион

в ран попал аргумент, то в результе
 */

