package com.example.demo.controller;

import com.example.demo.Advertiser;
import com.example.demo.dao.AdvertiserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private AdvertiserRepo advertiserRepo;

    @PostMapping
    public Advertiser createAdvertiser(@RequestBody Advertiser advertiser) {

        //things to do - check if advertiser already exists and add campaigns
        // create advertiser
        Advertiser newAdvertiser = new Advertiser();
        newAdvertiser.setName(advertiser.getName());
        newAdvertiser.setIndustry(advertiser.getIndustry());
        newAdvertiser.setCountry(advertiser.getCountry());
        advertiserRepo.save(newAdvertiser);
        return newAdvertiser;
    }
}
