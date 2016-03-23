package com.parsley.stringparsers;

import com.parsley.Parser;


public class StringToIntegerParser implements Parser<String, Integer> {


    public Integer parse(String string) {
        Double d = Double.parseDouble(string);
        return d.intValue();
    }


    public Class<String> getObjectClass() {
        return String.class;
    }


    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
