package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.alphabet.Alphabet;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;
import ru.javarush.pavlova.cryptoanalizer.file.FileProcessor;
import ru.javarush.pavlova.exceptions.AppException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Decoder implements Action {
    private int key;
    private int newIndex = 0;
    @Override
    public Result execute(String[] parameters) throws IOException {
        ArrayList<String> list = (ArrayList<String>) FileProcessor.readFile(parameters[0]);
        key = Integer.parseInt(parameters[parameters.length-1]);
        FileProcessor.writeFile(parameters[1], createResult(list));
        return new Result("decode all right", ResultCode.OK);
    }
    private String createStr (Character[] characters) {
        String resultStr = "";
        for (int i = 0; i < characters.length; i++) {
            int index = Alphabet.getCharIndex(characters[i]);
            if((index-key)>=0) {
                newIndex = index-key;
            } else {
                newIndex = index-key+Alphabet.CHAR_ARRAY_ABC.length;
            }
            resultStr = resultStr+Alphabet.getCharByIndex(newIndex);
        }
        return resultStr;
    }
    private ArrayList<String> createResult(ArrayList<String> list) {
        ArrayList<String> RESULT_ACTIONS = new ArrayList<>();
        for (String str: list) {
            Character[] characters = str.chars().mapToObj(c-> (char)c).toArray(Character[]::new);
            RESULT_ACTIONS.add(createStr(characters));
        }
        return RESULT_ACTIONS;
    }
}
