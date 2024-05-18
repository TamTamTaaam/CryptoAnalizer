package ru.javarush.pavlova.cryptoanalizer.constants;

public class Constants {
   private static final String rus = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
   private static final String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
   private static final String cypher ="0123456789";
   private static final String z = "!@#$%^&*()[]{}";
   public static final String ABC =rus+eng+rus.toLowerCase()+eng.toLowerCase()+cypher+z;
}
