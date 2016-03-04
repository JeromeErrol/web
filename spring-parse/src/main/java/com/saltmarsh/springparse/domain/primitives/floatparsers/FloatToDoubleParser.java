package com.saltmarsh.springparse.domain.primitives.floatparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class FloatToDoubleParser implements IParse<Float, Double> {

    @Override
    public Double parse(Float aFloat) {
        return aFloat.doubleValue();
    }

    @Override
    public Class<Float> getObjectClass() {
        return Float.class;
    }

    @Override
    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
