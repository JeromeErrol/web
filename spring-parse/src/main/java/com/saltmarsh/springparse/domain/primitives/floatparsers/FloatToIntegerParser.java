package com.saltmarsh.springparse.domain.primitives.floatparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class FloatToIntegerParser implements IParse<Float, Integer> {

    @Override
    public Integer parse(Float aFloat) {
        return aFloat.intValue();
    }

    @Override
    public Class<Float> getObjectClass() {
        return Float.class;
    }

    @Override
    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
