package com.saltmarsh.springparse.domain.primitives.doubleparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class DoubleToIntegerParser implements IParse<Double, Integer> {

    @Override
    public Integer parse(Double aDouble) {
        return aDouble.intValue();
    }

    @Override
    public Class<Double> getObjectClass() {
        return Double.class;
    }

    @Override
    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
