package com.parsley.integerparsers;

import com.parsley.Parser;


public class IntegerToStringParser implements Parser<Integer, String> {


    public String parse(Integer integer) {
        return Integer.toString(integer);
    }


    public Class<Integer> getObjectClass() {
        return Integer.class;
    }


    public Class<String> getTargetClass() {
        return String.class;
    }
}
