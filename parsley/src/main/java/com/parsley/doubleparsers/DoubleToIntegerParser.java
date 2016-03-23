package com.parsley.doubleparsers;

import com.parsley.Parser;


public class DoubleToIntegerParser implements Parser<Double, Integer> {


    public Integer parse(Double aDouble) {
        return aDouble.intValue();
    }


    public Class<Double> getObjectClass() {
        return Double.class;
    }


    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
