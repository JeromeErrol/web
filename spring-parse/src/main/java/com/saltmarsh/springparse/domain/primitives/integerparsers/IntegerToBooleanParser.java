package com.saltmarsh.springparse.domain.primitives.integerparsers;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

@Component
public class IntegerToBooleanParser implements IParse<Integer, Boolean> {

    @Override
    public Boolean parse(Integer integer) {
        if(integer == 1){
            return true;
        }
        if(integer == 0){
            return false;
        }
        throw new RuntimeException("Integer must be either 1 or 0 to convert to Boolean. Integer received: " + integer);
    }

    @Override
    public Class<Integer> getObjectClass() {
        return Integer.class;
    }

    @Override
    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
