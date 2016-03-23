package com.parsley.integerparsers;

import com.parsley.Parser;


public class IntegerToFloatParser implements Parser<Integer, Float> {

    public Float parse(Integer integer) {
        return new Float(integer);
    }


    public Class<Integer> getObjectClass() {
        return Integer.class;
    }


    public Class<Float> getTargetClass() {
        return Float.class;
    }
}
