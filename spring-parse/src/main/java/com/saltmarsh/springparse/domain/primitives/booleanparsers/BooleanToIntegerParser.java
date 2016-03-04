package com.saltmarsh.springparse.domain.primitives.booleanparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class BooleanToIntegerParser implements IParse<Boolean, Integer> {

    @Override
    public Integer parse(Boolean aBoolean) {
        if (aBoolean) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Class<Boolean> getObjectClass() {
        return Boolean.class;
    }

    @Override
    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
