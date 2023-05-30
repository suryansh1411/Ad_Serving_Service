 package com.example.demo.dao;

import com.example.demo.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepo extends CrudRepository<Campaign, Long> {
}
