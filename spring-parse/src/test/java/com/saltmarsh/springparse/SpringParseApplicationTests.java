package com.saltmarsh.springparse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.saltmarsh.springparse.domain.SpringParser.parse;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringParseApplication.class)
public class SpringParseApplicationTests {

    @Test
    public void parseStringToBoolean() {
        Boolean boolFromOne = parse("1", Boolean.class);
        assertTrue(boolFromOne);

        Boolean boolFromZero = parse("0", Boolean.class);
        assertFalse(boolFromZero);

        Boolean boolFromYes = parse("yes", Boolean.class);
        assertTrue(boolFromYes);

        Boolean boolFromNo = parse("no", Boolean.class);
        assertFalse(boolFromNo);

        Boolean boolFromTrue = parse("true", Boolean.class);
        assertTrue(boolFromTrue);

        Boolean boolFromFalse = parse("false", Boolean.class);
        assertFalse(boolFromFalse);
    }

    @Test
    public void parseStringToInteger() {
        Integer oneFromText = parse("1", Integer.class);
        assertTrue(1 == oneFromText);
        Integer oneAndAHalfFromText = parse("1.5", Integer.class);
        assertTrue(1 == oneAndAHalfFromText);
    }

    @Test
    public void parseBooleanToString() {
        Boolean booleanTrue = true;
        String trueText = parse(true, String.class);
        assertEquals("true", trueText);

        String falseText = parse(true, String.class);
        assertEquals("false", falseText);
    }
}
