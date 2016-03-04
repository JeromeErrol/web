package com.saltmarsh.springparse.domain.primitives.doubleparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class DoubleToFloatParser implements IParse<Double, Float> {
    @Override
    public Float parse(Double aDouble) {
        return aDouble.floatValue();
    }

    @Override
    public Class<Double> getObjectClass() {
        return Double.class;
    }

    @Override
    public Class<Float> getTargetClass() {
        return Float.class;
    }
}
