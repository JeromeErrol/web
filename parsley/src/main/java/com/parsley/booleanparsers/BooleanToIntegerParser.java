package com.parsley.booleanparsers;

import com.parsley.Parser;


public class BooleanToIntegerParser implements Parser<Boolean, Integer> {


    public Integer parse(Boolean aBoolean) {
        if (aBoolean) {
            return 1;
        } else {
            return 0;
        }
    }


    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }


    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
