package com.parsley.integerparsers;

import com.parsley.Parser;


public class IntegerToBooleanParser implements Parser<Integer, Boolean> {


    public Boolean parse(Integer integer) {
        if (integer == 1) {
            return true;
        }
        if (integer == 0) {
            return false;
        }
        throw new RuntimeException("Integer must be either 1 or 0 to convert to Boolean. Integer received: " + integer);
    }


    public Class<Integer> getObjectClass() {
        return Integer.class;
    }


    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
