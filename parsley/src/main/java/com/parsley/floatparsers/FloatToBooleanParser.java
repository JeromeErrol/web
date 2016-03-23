package com.parsley.floatparsers;

import com.parsley.Parser;
import com.parsley.integerparsers.IntegerToBooleanParser;


public class FloatToBooleanParser implements Parser<Float, Boolean> {


    private IntegerToBooleanParser integerToBooleanParser;


    public Boolean parse(Float aFloat) {
        int intVal = aFloat.intValue();
        return integerToBooleanParser.parse(intVal);
    }


    public Class<Float> getObjectClass() {
        return null;
    }


    public Class<Boolean> getTargetClass() {
        return null;
    }
}
