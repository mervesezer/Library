package com.merve.library.controllers;

import com.merve.library.dal.PublisherDao;
import com.merve.library.models.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {
    @Autowired
    PublisherDao pubDao;

    @GetMapping("/publishers")
    public String index(Model model) {
        model.addAttribute("publishers", pubDao.findAll());
        model.addAttribute("publisher", new Publisher());
        return "publishers";
    }

    @PostMapping("/publishers/delete/{id}")
    public String delete(@PathVariable int id) {
        pubDao.deleteById(id);
        return "redirect:/publishers";
    }

    @PostMapping("/publishers")
    public String add(@ModelAttribute Publisher publisher) {
        pubDao.save(publisher);
        return "redirect:/publishers";
    }

}
