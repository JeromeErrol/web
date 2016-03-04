package com.saltmarsh.springparse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringParser {

    @Autowired
    private Parser parser;

    private static SpringParser springParser;

    @PostConstruct
    private void postConstruct() {
        SpringParser.springParser = this;
    }

    public static <T> T parse(Object object, Class T) {
        return springParser.parser.parse(object, T);
    }
}
