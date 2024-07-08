package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;
import ru.javarush.pavlova.cryptoanalizer.file.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Decoder implements Action {
    private int KEY;
    @Override
    public Result execute(String[] parameters) throws IOException {
        List<String> textBeforeDecrypt = fileProcessor.readFile(parameters[0]);
        KEY = 0 - Integer.parseInt(parameters[parameters.length-1]);
        List<String> textAfterDecrypt = workingText.getResultConversionText(textBeforeDecrypt, KEY);
        fileProcessor.writeFile(parameters[1], textAfterDecrypt);
        return new Result("decode all right", ResultCode.OK);
    }

}
