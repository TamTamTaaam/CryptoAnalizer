package ru.javarush.pavlova.cryptoanalizer.services;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class AlphabetService {
   private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
   private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static final String numbers ="0123456789";
   private static final String symbols = "–!@#$%^&*()[]{},. :;<>?`~�«»'…„“";
   private static final String allSymbols = rus.toLowerCase()+eng.toLowerCase()+numbers+symbols;
   public static final char [] CHAR_ARRAY_ABC =allSymbols.toCharArray();
   public static final Map<Character, Integer> ALPHABET_MAP = IntStream.range(0, allSymbols.length())
           .collect(HashMap::new, (m, i) -> m.put(allSymbols.charAt(i), i), Map::putAll);
   public static final List<Character> ALPHABET_LIST = allSymbols.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

   public Character getCharByIndex(int index)  {
      if (index <0 || index> allSymbols.length()) {
         throw new ArrayIndexOutOfBoundsException("Invalid index. Index: " + index + " Valid is from 0 to " + allSymbols.length());
      }
      return ALPHABET_LIST.get(index);
   }
   public int getCharIndex(Character symbol) {
      if (!ALPHABET_MAP.containsKey(symbol)) {
         throw new RuntimeException("Invalid symbol. Symbol: " + symbol + ".");
      }
      return ALPHABET_MAP.get(symbol);
   }
   public int getNewCharIndex(int indexCharInAlphabet, int key) {
      if((indexCharInAlphabet + key)<CHAR_ARRAY_ABC.length && (indexCharInAlphabet + key)>=0) {
         return indexCharInAlphabet + key;
      } else if (key>=0){
         return indexCharInAlphabet + key - CHAR_ARRAY_ABC.length;
      } else  {
         return indexCharInAlphabet + key + CHAR_ARRAY_ABC.length;
      }
   }
}

