package com.saltmarsh.springparse.domain.primitives.stringparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class StringToDoubleParser implements IParse<String, Double> {

    @Override
    public Double parse(String string) {
        return Double.parseDouble(string);
    }

    @Override
    public Class<String> getObjectClass() {
        return String.class;
    }

    @Override
    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
