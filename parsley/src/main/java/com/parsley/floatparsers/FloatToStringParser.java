package com.parsley.floatparsers;

import com.parsley.Parser;


public class FloatToStringParser implements Parser<Float, String> {


    public String parse(Float aFloat) {
        return aFloat.toString();
    }


    public Class<Float> getObjectClass() {
        return Float.class;
    }


    public Class<String> getTargetClass() {
        return String.class;
    }
}
