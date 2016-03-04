package com.saltmarsh.springparse.domain.primitives.floatparsers;

import com.saltmarsh.springparse.domain.IParse;
import com.saltmarsh.springparse.domain.primitives.integerparsers.IntegerToBooleanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FloatToBooleanParser implements IParse<Float, Boolean> {

    @Autowired
    private IntegerToBooleanParser integerToBooleanParser;

    @Override
    public Boolean parse(Float aFloat) {
        int intVal = aFloat.intValue();
        return integerToBooleanParser.parse(intVal);
    }

    @Override
    public Class<Float> getObjectClass() {
        return null;
    }

    @Override
    public Class<Boolean> getTargetClass() {
        return null;
    }
}
