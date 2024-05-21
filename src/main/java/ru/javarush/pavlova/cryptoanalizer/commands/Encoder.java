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

import static java.lang.Character.toLowerCase;
import static ru.javarush.pavlova.cryptoanalizer.file.FileProcessor.writeFile;

public class Encoder implements Action {
    private int key;
    private int newIndex = 0;

    @Override
    public Result execute(String[] parameters) throws IOException {
        ArrayList<String> list = (ArrayList<String>) FileProcessor.readFile(parameters[0]);
        key = Integer.parseInt(parameters[parameters.length-1]);
        ArrayList<String> RESULT_ACTIONS = new ArrayList<>();
        for (String str: list) {
            String resultStr = "";
            Character[] characters = str.chars().mapToObj(c-> (char)c).toArray(Character[]::new);
            for (int i = 0; i < characters.length; i++) {
                int index = Alphabet.getCharIndex(characters[i]);
                if((index+key)< Alphabet.CHAR_ARRAY_ABC.length) {
                    newIndex = index+key;
                } else {
                    newIndex = index+key-Alphabet.CHAR_ARRAY_ABC.length;
                }
                resultStr = resultStr+Alphabet.getCharByIndex(newIndex);;
            }
            RESULT_ACTIONS.add(resultStr);
        }
        String text = parameters[1];
        writeFile(text, RESULT_ACTIONS);
        return new Result("encode all right", ResultCode.OK);
    }
}

