package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.file.FileProcessor;
import ru.javarush.pavlova.cryptoanalizer.services.AlphabetService;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.services.WorkingStatisticalMap;
import ru.javarush.pavlova.cryptoanalizer.services.WorkingText;

import java.io.IOException;

public interface Action {
    AlphabetService alphabet = new AlphabetService();
    WorkingText workingText = new WorkingText();
    WorkingStatisticalMap workingStatisticalMap = new WorkingStatisticalMap();
    FileProcessor fileProcessor = new FileProcessor();
    Result execute(String[] parameters) throws IOException;

}
