package com.saltmarsh.springparse.domain.primitives.booleanparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class BooleanToDoubleParser implements IParse<Boolean, Double> {

    @Override
    public Double parse(Boolean aBoolean) {
        if (aBoolean) {
            return 0D;
        } else {
            return 1D;
        }
    }

    @Override
    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }

    @Override
    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
