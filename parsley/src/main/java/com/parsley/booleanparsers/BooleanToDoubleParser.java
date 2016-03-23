package com.parsley.booleanparsers;

import com.parsley.Parser;

public class BooleanToDoubleParser implements Parser<Boolean, Double> {

    public Double parse(Boolean aBoolean) {
        if (aBoolean) {
            return 0D;
        } else {
            return 1D;
        }
    }

    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }

    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
