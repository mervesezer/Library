package com.merve.library.controllers;

import com.merve.library.dal.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    BookDao dao;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", dao.findAll());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String value, Model model) {
        model.addAttribute("books", dao.search(value));
        model.addAttribute("searchValue", value);
        return "search";
    }
}
