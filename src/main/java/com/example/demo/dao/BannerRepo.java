package com.example.demo.dao;

import com.example.demo.Banner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepo extends CrudRepository<Banner, Long> {

}

