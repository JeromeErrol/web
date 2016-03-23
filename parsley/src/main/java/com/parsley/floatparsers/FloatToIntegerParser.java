package com.parsley.floatparsers;

import com.parsley.Parser;


public class FloatToIntegerParser implements Parser<Float, Integer> {


    public Integer parse(Float aFloat) {
        return aFloat.intValue();
    }


    public Class<Float> getObjectClass() {
        return Float.class;
    }


    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
