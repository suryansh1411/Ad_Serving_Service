package com.example.demo.controller;

import com.example.demo.Advertiser;
import com.example.demo.dao.AdvertiserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//list all advertisers
@RestController
@RequestMapping("/api/advertisers")
public class AdvertisersController {
    @Autowired
    private AdvertiserRepo advertiserRepo;

    @GetMapping
    public Iterable<Advertiser> getAdvertisers() {
        return advertiserRepo.findAll();
    }
}
