package com.parsley.doubleparsers;

import com.parsley.Parser;
import com.parsley.integerparsers.IntegerToBooleanParser;


public class DoubleToBooleanParser implements Parser<Double, Boolean> {


    private IntegerToBooleanParser integerToBooleanParser;


    public Boolean parse(Double aDouble) {
        int intVal = aDouble.intValue();
        return integerToBooleanParser.parse(intVal);
    }


    public Class<Double> getObjectClass() {
        return Double.class;
    }


    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
