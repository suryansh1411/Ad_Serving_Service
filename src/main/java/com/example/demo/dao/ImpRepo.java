package com.example.demo.dao;

import com.example.demo.Imp;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ImpRepo extends CrudRepository<Imp, Long>{

}

