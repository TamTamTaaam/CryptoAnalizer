package ru.javarush.pavlova.cryptoanalizer.constants;

import java.io.File;

public class Constants {
   private static final String rus = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
   private static final String eng = "QWERTYUIOPASDFGHJKLZXCVBNM";
   private static final String cypher ="0123456789";
   private static final String z = "!@#$%^&*()[]{}";
   public static final String ABC =rus+eng+rus.toLowerCase()+eng.toLowerCase()+cypher+z;

   public static final String TXT_FOLDER = System.getProperty("CryptoAnalizer.dir") + File.separator + "text" + File.separator; //получили полный путь где лежат текст (папка текст)
}
