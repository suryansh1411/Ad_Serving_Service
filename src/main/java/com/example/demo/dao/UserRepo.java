package com.example.demo.dao;

import org.springframework.stereotype.Repository;
import com.example.demo.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
