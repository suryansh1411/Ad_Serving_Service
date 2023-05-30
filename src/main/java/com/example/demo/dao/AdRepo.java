package com.example.demo.dao;

import org.springframework.stereotype.Repository;
import com.example.demo.Ad;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface AdRepo extends CrudRepository<Ad, Long> {

}
