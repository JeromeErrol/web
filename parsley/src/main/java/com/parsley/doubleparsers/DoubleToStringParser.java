package com.parsley.doubleparsers;

import com.parsley.Parser;


public class DoubleToStringParser implements Parser<Double, String> {


    public String parse(Double aDouble) {
        return aDouble.toString();
    }


    public Class<Double> getObjectClass() {
        return Double.class;
    }


    public Class<String> getTargetClass() {
        return String.class;
    }
}
