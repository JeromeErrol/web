package com.saltmarsh.springparse.domain.primitives.booleanparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class BooleanToStringParser implements IParse<Boolean, String> {

    @Override
    public String parse(Boolean aBoolean) {
        return Boolean.toString(aBoolean);
    }

    @Override
    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }

    @Override
    public Class<String> getTargetClass() {
        return String.class;
    }
}
