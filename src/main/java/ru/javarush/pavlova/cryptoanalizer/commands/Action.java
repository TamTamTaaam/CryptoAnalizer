package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;

import java.io.IOException;

public interface Action {
    Result execute(String[] parameters) throws IOException;

}
