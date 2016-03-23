package com.parsley.booleanparsers;

import com.parsley.Parser;


public class BooleanToStringParser implements Parser<Boolean, String> {


    public String parse(Boolean aBoolean) {
        return Boolean.toString(aBoolean);
    }


    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }


    public Class<String> getTargetClass() {
        return String.class;
    }
}
