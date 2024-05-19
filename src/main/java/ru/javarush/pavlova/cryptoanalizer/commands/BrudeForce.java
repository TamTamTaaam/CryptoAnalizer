package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;

public class BrudeForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        //to do something
        return new Result("BrudeForce complete", ResultCode.OK);
    }
}
