package com.saltmarsh.springparse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class ParserInitiator {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Parser parser() {
        Map<String, IParse> parserMap = applicationContext.getBeansOfType(IParse.class);
        List<IParse> parsers = new ArrayList<>(parserMap.values());
        return new Parser(parsers);
    }
}
