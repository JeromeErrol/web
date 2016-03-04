package com.saltmarsh.springparse.domain.primitives.doubleparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class DoubleToStringParser implements IParse<Double, String> {

    @Override
    public String parse(Double aDouble) {
        return aDouble.toString();
    }

    @Override
    public Class<Double> getObjectClass() {
        return Double.class;
    }

    @Override
    public Class<String> getTargetClass() {
        return String.class;
    }
}
