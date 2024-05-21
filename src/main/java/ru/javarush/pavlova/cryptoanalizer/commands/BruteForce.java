package ru.javarush.pavlova.cryptoanalizer.commands;

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
                if(list.size()>=10) {
            for (int i = 0; i < 10; i++) {
                tenStr.add(list.get(i));
            }
        } else {
            tenStr=list;
        }
        for(String str: tenStr) {
            Character[] characters = str.chars().mapToObj(c->(char)c).toArray(Character[]::new);
            Integer value = 0;
            BRUTE_FORCE.put(characters[0], value);
            for (int i = 1; i < characters.length; i++) {
                if(!(BRUTE_FORCE.containsKey(characters[i]))) {
                    BRUTE_FORCE.put(characters[i], value);
                } else {
                    Integer tempValue = BRUTE_FORCE.get(characters[i]) + 1;
                    BRUTE_FORCE.replace(characters[i], tempValue);
                }
            }
        } valueList(BRUTE_FORCE);


        return new Result("bruteforce all right", ResultCode.OK);
    }
    public void valueList(Map<Character, Integer> BRUTE_FORCE) {
//        ArrayList valuesList = new ArrayList(BRUTE_FORCE.entrySet());
//        Collections.sort(valuesList, new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return o1.getValue().compareTo(o2.getValue());
//            }
//        });
//        System.out.println(valuesList.get(0));

        List list = new ArrayList(BRUTE_FORCE.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        System.out.println(list.get(0));
    }



}
