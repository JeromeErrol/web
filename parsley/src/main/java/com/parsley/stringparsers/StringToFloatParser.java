package com.parsley.stringparsers;

import com.parsley.Parser;


public class StringToFloatParser implements Parser<String, Float> {


    public Float parse(String string) {
        return Float.parseFloat(string);
    }


    public Class<String> getObjectClass() {
        return String.class;
    }


    public Class<Float> getTargetClass() {
        return Float.class;
    }
}
