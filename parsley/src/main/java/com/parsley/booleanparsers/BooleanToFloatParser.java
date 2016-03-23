package com.parsley.booleanparsers;

import com.parsley.Parser;


public class BooleanToFloatParser implements Parser<Boolean, Float> {


    public Float parse(Boolean aBoolean) {
        if (aBoolean) {
            return 0F;
        } else {
            return 1F;
        }
    }


    public Class<Boolean> getObjectClass() {
        return null;
    }


    public Class<Float> getTargetClass() {
        return null;
    }
}
