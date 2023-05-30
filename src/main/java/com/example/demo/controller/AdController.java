package com.example.demo.controller;

import com.example.demo.Imp;
import com.example.demo.Ad;
import com.example.demo.Advertiser;
import com.example.demo.Campaign;
import com.example.demo.dao.AdRepo;
import com.example.demo.dao.CampaignRepo;
import com.example.demo.dao.ImpRepo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@RestController
public class AdController {
	@Autowired
	private AdRepo adRepo;
	
	@Autowired
	private CampaignRepo campaignRepo;
	
	@Autowired
	private ImpRepo impRepo;
	
	@GetMapping("api/ad")
	public Iterable<Ad> getAllAd()
	{
    	for (Ad ad: adRepo.findAll())
    	{
    		System.out.println(ad.getImp().get(0).getBidfloor());
    		System.out.println(ad.getImp().get(0).getId());
    		System.out.println(ad.getImp().get(0).getAd());
    	}
		return adRepo.findAll();
	}
	
	@PostMapping("api/ad")
	public Ad createAd(@RequestBody Ad newAd, @RequestParam(name = "campaign_id") Long campaignId)
	{     
		Campaign campaign = campaignRepo.findById(campaignId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid campaign ID"));
		System.out.println("hi");
		adRepo.save(newAd);
		System.out.println(newAd.getId());
		Ad ad = adRepo.findById(newAd.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid Ad ID"));
		for (Imp imp : ad.getImp() )
		{
			imp.setAd(newAd);
			System.out.println(imp.getBidfloor());
			System.out.println(imp.getId());
//			impRepo.save(imp);
		}

		newAd.setCampaign(campaign);
		return newAd;
	}
}
