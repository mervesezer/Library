package com.merve.library.controllers;

import com.merve.library.dal.AuthorDao;
import com.merve.library.dal.BookDao;
import com.merve.library.dal.PublisherDao;
import com.merve.library.models.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    PublisherDao publisherDao;
    AuthorDao authorDao;
    BookDao bookDao;

    @Autowired
    public BookController(PublisherDao publisherDao, AuthorDao authorDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public String index(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("/books/delete/{id}")
    public String delete(@PathVariable int id) {
        bookDao.deleteById(id);
        return "redirect:/books";
    }

    @PostMapping("/books/update")
    public String update(@ModelAttribute Book book) {
        bookDao.save(book);
        return "redirect:/books";
    }

    @PostMapping("/books")
    public String add(@ModelAttribute Book book) {
        bookDao.save(book);
        return "redirect:/books";
    }
}
