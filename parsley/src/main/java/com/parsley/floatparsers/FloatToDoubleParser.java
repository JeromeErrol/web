package com.parsley.floatparsers;

import com.parsley.Parser;


public class FloatToDoubleParser implements Parser<Float, Double> {


    public Double parse(Float aFloat) {
        return aFloat.doubleValue();
    }


    public Class<Float> getObjectClass() {
        return Float.class;
    }


    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
