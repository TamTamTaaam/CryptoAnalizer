package ru.javarush.pavlova.cryptoanalizer.services;

import java.util.ArrayList;
import java.util.List;

public class WorkingText {
    private AlphabetService alphabet = new AlphabetService();
    private final int MINIMUM_COUNT_OF_STRING_FOR_BRUTE_FORCE = 10;
    public List<String> takeTextPart(List<String> text) {
        if (text.size() > MINIMUM_COUNT_OF_STRING_FOR_BRUTE_FORCE) {
            return text.subList(0, MINIMUM_COUNT_OF_STRING_FOR_BRUTE_FORCE);
        }
        return text;
    }
    public List<String> getResultConversionText(List<String> beforeText, int key) {
        List<String> resultEncodeText = new ArrayList<>();
        for (String str: beforeText) {
            char[] arrayCharsStartString = str.toCharArray();
            resultEncodeText.add(getStringConversion(arrayCharsStartString, key));
        }
        return resultEncodeText;
    }
    private String getStringConversion(char[] characters, int key) {
        String encodeString = "";
        for (int i = 0; i < characters.length; i++) {
            int indexCharInAlphabet = alphabet.getCharIndex(characters[i]);
            int newIndexCharInAlphabet = alphabet.getNewCharIndex(indexCharInAlphabet, key);
            encodeString = encodeString+ alphabet.getCharByIndex(newIndexCharInAlphabet);
        }
        return encodeString;
    }

}
