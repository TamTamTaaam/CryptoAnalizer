package ru.javarush.pavlova.cryptoanalizer.alphabet;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Alphabet {
   // Алфавит Alphabet
   private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
   private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private static final String numbers ="0123456789";
   private static final String symbols = "–!@#$%^&*()[]{},. :;<>?`~�«»'…„“";
   private static final String allSymbols = rus.toLowerCase()+eng.toLowerCase()+numbers+symbols;
   public static final char [] CHAR_ARRAY_ABC =(rus.toLowerCase()+eng.toLowerCase()+numbers+symbols).toCharArray();
   public static final Map<Character, Integer> ALPHABET = IntStream.range(0, allSymbols.length())
           .collect(HashMap::new, (m, i) -> m.put(allSymbols.charAt(i), i), Map::putAll);
   public static final List<Character> ALPHABET_LIST = allSymbols.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

   public static Character getCharByIndex(int index)  {
      if (index <0 || index> allSymbols.length()) {
         throw new ArrayIndexOutOfBoundsException("Invalid index. Index: " + index + " Valid is from 0 to " + allSymbols.length());
      }
      return ALPHABET_LIST.get(index);
   }
   public static int getCharIndex(Character symbol) {
      if (!ALPHABET.containsKey(symbol)) {
         throw new RuntimeException("Invalid symbol. Symbol: " + symbol + ".");
      }
      return ALPHABET.get(symbol);
   }
}

