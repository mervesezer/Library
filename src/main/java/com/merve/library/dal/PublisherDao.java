package com.merve.library.dal;

import com.merve.library.models.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDao extends JpaRepository<Publisher,Integer> {
    
}
