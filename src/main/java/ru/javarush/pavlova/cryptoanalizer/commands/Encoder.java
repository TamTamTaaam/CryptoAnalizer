package ru.javarush.pavlova.cryptoanalizer.commands;

import ru.javarush.pavlova.cryptoanalizer.entity.Result;
import ru.javarush.pavlova.cryptoanalizer.entity.ResultCode;


import java.io.IOException;
import java.util.List;



public class Encoder implements Action {
    private int KEY;
    @Override
    public Result execute(String[] parameters) throws IOException {
        List<String> textBeforeEncoding =  fileProcessor.readFile(parameters[0]);
        KEY = Integer.parseInt(parameters[parameters.length-1]);
        List<String> textAfterEncoding = workingText.getResultConversionText(textBeforeEncoding, KEY);
        fileProcessor.writeFile(parameters[1], textAfterEncoding);

        return new Result("encode all right", ResultCode.OK);
    }

}

