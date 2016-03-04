package com.saltmarsh.springparse.domain.primitives.integerparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class IntegerToStringParser implements IParse<Integer, String> {

    @Override
    public String parse(Integer integer) {
        return Integer.toString(integer);
    }

    @Override
    public Class<Integer> getObjectClass() {
        return Integer.class;
    }

    @Override
    public Class<String> getTargetClass() {
        return String.class;
    }
}
