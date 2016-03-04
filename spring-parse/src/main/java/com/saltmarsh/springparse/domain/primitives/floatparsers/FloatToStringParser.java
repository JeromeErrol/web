package com.saltmarsh.springparse.domain.primitives.floatparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class FloatToStringParser implements IParse<Float, String> {

    @Override
    public String parse(Float aFloat) {
        return aFloat.toString();
    }

    @Override
    public Class<Float> getObjectClass() {
        return Float.class;
    }

    @Override
    public Class<String> getTargetClass() {
        return String.class;
    }
}
