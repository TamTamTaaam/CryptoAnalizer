package ru.javarush.pavlova.cryptoanalizer.controllers;

import ru.javarush.pavlova.cryptoanalizer.commands.Action;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;

import java.io.IOException;

public class MainController {

  public Result doAction(String actionName, String[] parameters) throws IOException {
      //action = encode
      // parameters = [ext.txt encode.txt 12]
      Action action = Actions.find(actionName);
      return action.execute(parameters);
  }
}
