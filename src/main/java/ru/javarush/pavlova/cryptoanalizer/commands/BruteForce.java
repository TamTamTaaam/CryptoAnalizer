package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.alphabet.Alphabet;
import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;
import ru.javarush.pavlova.cryptoanalizer.file.FileProcessor;
import java.util.*;

public class BruteForce implements Action {
    @Override
    public Result execute(String[] parameters) {
        //to do something
        //должен возвращать ключ. Ключ шифрования = ...
        ArrayList<String> list = (ArrayList<String>) FileProcessor.readFile(parameters[0]);
        ArrayList<String> tenStr = new ArrayList<>();
        Map<Character, Integer> BRUTE_FORCE = new HashMap<>();
        if (list.size() >= 10) {
            for (int i = 0; i < 10; i++) {
                tenStr.add(list.get(i));
            }
        } else {
            tenStr = list;
        }
        for (String str : tenStr) {
            if(str.isEmpty()) {
                break;
            } else {
                Character[] characters = str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
                Integer value = 0;

                if (!(BRUTE_FORCE.containsKey(characters[0]))) {
                    BRUTE_FORCE.put(characters[0], value);
                }
                for (int i = 1; i < characters.length; i++) {
                    if (!(BRUTE_FORCE.containsKey(characters[i]))) {
                        BRUTE_FORCE.put(characters[i], value);
                    } else {
                        Integer tempValue = BRUTE_FORCE.get(characters[i]) + 1;
                        BRUTE_FORCE.replace(characters[i], tempValue);
                    }
                }
            }
        }
        Character char_max = valueList(BRUTE_FORCE);
        int key = Alphabet.getCharIndex(char_max) - Alphabet.getCharIndex(' ');
        String message = "bruteforce all right. Key = " + key;

        return new Result(message, ResultCode.OK);
    }

    public Character valueList(Map<Character, Integer> BRUTE_FORCE) {
        Set<Map.Entry<Character, Integer>> entries = BRUTE_FORCE.entrySet();
        Integer max = 0;
        Character maxChar = '@';
        for (Map.Entry<Character, Integer> pair : entries) {
            Integer value = pair.getValue();
            if (value > max) {
                max = value;
                maxChar = pair.getKey();
            }
        }
        return  maxChar;
    }
}