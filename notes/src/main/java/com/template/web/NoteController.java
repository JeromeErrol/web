package com.template.web;

import com.template.domain.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.DriverManager;

@RequestMapping("/notes")
@Controller
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "hello world";
    }
}
