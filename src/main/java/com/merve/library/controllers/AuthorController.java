package com.merve.library.controllers;

import com.merve.library.dal.AuthorDao;
import com.merve.library.models.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    @Autowired
    AuthorDao autDao;

    @GetMapping("/authors")
    public String index(Model model) {
        model.addAttribute("authors", autDao.findAll());
        model.addAttribute("author", new Author());
        return "authors";
    }

    @PostMapping("/authors/delete/{id}")
    public String delete(@PathVariable int id) {
        autDao.deleteById(id);
        return "redirect:/authors";
    }

    @PostMapping("/authors")
    public String add(@ModelAttribute Author author) {
        autDao.save(author);
        return "redirect:/authors";
    }

}
