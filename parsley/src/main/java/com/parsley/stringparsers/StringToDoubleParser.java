package com.parsley.stringparsers;

import com.parsley.Parser;


public class StringToDoubleParser implements Parser<String, Double> {


    public Double parse(String string) {
        return Double.parseDouble(string);
    }


    public Class<String> getObjectClass() {
        return String.class;
    }


    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
