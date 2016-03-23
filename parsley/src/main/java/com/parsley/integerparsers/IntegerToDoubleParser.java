package com.parsley.integerparsers;

import com.parsley.Parser;


public class IntegerToDoubleParser implements Parser<Integer, Double> {


    public Double parse(Integer integer) {
        return integer.doubleValue();
    }


    public Class<Integer> getObjectClass() {
        return Integer.class;
    }


    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
