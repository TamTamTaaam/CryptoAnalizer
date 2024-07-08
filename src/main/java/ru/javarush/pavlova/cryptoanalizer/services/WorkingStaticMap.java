package ru.javarush.pavlova.cryptoanalizer.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WorkingStaticMap {

    public Map<Character, Integer> creatingStatisticalMap(List<String> partOfText) {
        Map<Character, Integer> statistic = new HashMap<>();
        for (String str : partOfText) {
            char[] characters = str.toCharArray();
            collectStatistic(characters, statistic);
        }
        return statistic;
    }

    private void collectStatistic(char[] characters, Map<Character, Integer> statistic) {
        for(Character character: characters) {
            if(statistic.containsKey(character)) {
                int countOfThisChar = statistic.get(character) + 1;
                statistic.put(character, countOfThisChar);
            } else {
                statistic.put(character, 0);
            }
        }
    }
    public Character findTheMostCommonCharFromStatisticMap(Map<Character, Integer> statistic) {
        Set<Map.Entry<Character, Integer>> entries = statistic.entrySet();
        Integer maxValueFromStatistic = 0;
        Character maxCommonChar = '@';
        for (Map.Entry<Character, Integer> pair : entries) {
            Integer valueOfThisChar = pair.getValue();
            if (valueOfThisChar > maxValueFromStatistic) {
                maxValueFromStatistic = valueOfThisChar;
                maxCommonChar = pair.getKey();
            }
        }
        return  maxCommonChar;
    }

}
