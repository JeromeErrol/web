package com.parsley.doubleparsers;

import com.parsley.Parser;


public class DoubleToFloatParser implements Parser<Double, Float> {

    public Float parse(Double aDouble) {
        return aDouble.floatValue();
    }


    public Class<Double> getObjectClass() {
        return Double.class;
    }


    public Class<Float> getTargetClass() {
        return Float.class;
    }
}
