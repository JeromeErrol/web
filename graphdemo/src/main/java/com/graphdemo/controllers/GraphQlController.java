package com.graphdemo.controllers;

import com.graphdemo.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/graphql")
public class GraphQlController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object requestMapping(@RequestBody String request) {
        return queryService.query(request);
    }
}
