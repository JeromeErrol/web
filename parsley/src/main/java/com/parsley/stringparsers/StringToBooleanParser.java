package com.parsley.stringparsers;

import com.parsley.Parser;

import java.util.Arrays;
import java.util.List;


public class StringToBooleanParser implements Parser<String, Boolean> {

    private List<String> positiveResults = Arrays.asList("yes", "true", "1", "positive", "+", "y");
    private List<String> negativeResults = Arrays.asList("no", "false", "0", "negative", "-", "n");


    public Boolean parse(String string) {
        string = string.toLowerCase().trim();
        if (positiveResults.contains(string)) {
            return true;
        }
        if (negativeResults.contains(string)) {
            return false;
        }
        return Boolean.getBoolean(string);
    }


    public Class<String> getObjectClass() {
        return String.class;
    }


    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
