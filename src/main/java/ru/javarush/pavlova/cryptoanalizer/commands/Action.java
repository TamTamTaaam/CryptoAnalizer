package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;

public interface Action {
    Result execute(String[] parameters);

}
