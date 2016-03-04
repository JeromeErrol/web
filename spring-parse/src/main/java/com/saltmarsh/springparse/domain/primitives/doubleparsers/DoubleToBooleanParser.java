package com.saltmarsh.springparse.domain.primitives.doubleparsers;

import com.saltmarsh.springparse.domain.IParse;
import com.saltmarsh.springparse.domain.primitives.integerparsers.IntegerToBooleanParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoubleToBooleanParser implements IParse<Double, Boolean> {

    @Autowired
    private IntegerToBooleanParser integerToBooleanParser;

    @Override
    public Boolean parse(Double aDouble) {
        int intVal = aDouble.intValue();
        return integerToBooleanParser.parse(intVal);
    }

    @Override
    public Class<Double> getObjectClass() {
        return Double.class;
    }

    @Override
    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
