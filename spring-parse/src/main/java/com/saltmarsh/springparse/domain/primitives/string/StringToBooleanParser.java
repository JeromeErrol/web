package com.saltmarsh.springparse.domain.primitives.string;

import com.saltmarsh.springparse.domain.IParse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StringToBooleanParser implements IParse<String, Boolean> {

    private List<String> positiveResults = Arrays.asList("yes", "true", "1");
    private List<String> negativeResults = Arrays.asList("no", "false", "0");

    @Override
    public Boolean parse(String string) {
        string = string.toLowerCase().trim();
        if (positiveResults.contains(string)) {
            return true;
        }
        if (negativeResults.contains(string)) {
            return false;
        }
        return Boolean.getBoolean(string);
    }

    @Override
    public Class<String> getObjectClass() {
        return String.class;
    }

    @Override
    public Class<Boolean> getTargetClass() {
        return Boolean.class;
    }
}
