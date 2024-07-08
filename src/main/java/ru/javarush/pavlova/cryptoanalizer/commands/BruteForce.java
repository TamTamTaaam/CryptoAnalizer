package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;
import ru.javarush.pavlova.cryptoanalizer.file.FileProcessor;

import java.util.*;

public class BruteForce implements Action {

    @Override
    public Result execute(String[] parameters) {
        List<String> list = fileProcessor.readFile(parameters[0]);
        List<String> partOfText = workingText.takeTextPart(list);
        Map<Character, Integer> statisticalMap = workingStaticMap.creatingStatisticalMap(partOfText);
        int key = findKeyBruteForce(statisticalMap);
        String message = "bruteforce all right. Key = " + key;
        return new Result(message, ResultCode.OK);
    }

    private int findKeyBruteForce(Map<Character, Integer> statistic) {
        Character theMostCommonChar = workingStaticMap.findTheMostCommonCharFromStatisticMap(statistic);
        return alphabet.getCharIndex(theMostCommonChar) - alphabet.getCharIndex(' ');
    }
}