package com.example.demo.controller;

import com.example.demo.Advertiser;
import com.example.demo.Campaign;
import com.example.demo.dao.AdvertiserRepo;
import com.example.demo.dao.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignRepo campaignRepo;

    @Autowired
    private AdvertiserRepo advertiserRepo;

    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign,
                                   @RequestParam(name = "advertiser_id") Long advertiserId) {
        // Check if the advertiser exists
        Advertiser advertiser = advertiserRepo.findById(advertiserId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid advertiser ID"));

        // Create the new campaign
        Campaign newCampaign = new Campaign();
        newCampaign.setName(campaign.getName());
        newCampaign.setStatus(campaign.getStatus());
        newCampaign.setStartDate(campaign.getStartDate());
        newCampaign.setEndDate(campaign.getEndDate());
        newCampaign.setBudget(campaign.getBudget());
        newCampaign.setAdvertiser(advertiser);

        campaignRepo.save(newCampaign);

        return newCampaign;
    }
}
