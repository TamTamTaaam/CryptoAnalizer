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

    public Result run(String[] args) {
        if (args.length>0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
            Result result = mainController.doAction(action, parameters);
        }
        throw new AppException();
    }
}

/*
Апликатион состоит из каких-то элементов: контроллера, командс, логерров, - разных сервисов, все сервисы будем собирать в апликатион

в ран попал аргумент, то в результе
 */

