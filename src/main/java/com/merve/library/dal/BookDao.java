package com.merve.library.dal;

import java.util.List;

import com.merve.library.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    @Query("from Book b where b.name like %?1% or b.author.name like %?1% or b.seriesName like %?1% or b.isbnNumber like %?1%")
    List<Book> search(String value);
}
