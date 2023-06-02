package com.example.demo.controller;

import com.example.demo.Imp;
import com.example.demo.Banner;
import com.example.demo.Ad;
import com.example.demo.Advertiser;
import com.example.demo.Campaign;
import com.example.demo.User;
import com.example.demo.dao.AdRepo;
import com.example.demo.dao.CampaignRepo;
import com.example.demo.dao.ImpRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dao.BannerRepo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.*;

@RestController
public class AdController {
	@Autowired
	private AdRepo adRepo;
	
	@Autowired
	private CampaignRepo campaignRepo;
	
	@Autowired
	private ImpRepo impRepo;
	
	@Autowired
	private BannerRepo bannerRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("api/ad")
	public Iterable<Ad> getAllAd()
	{
		return adRepo.findAll();
	}
	
	@PostMapping("api/ad")
	public ObjectNode createAd(@RequestBody Ad newAd, @RequestParam(name = "campaign_id") Long campaignId, @RequestParam(name="user_ids") List<Long> userIds)
	{     
		Campaign campaign = campaignRepo.findById(campaignId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid campaign ID"));
		
		List<User> users = (List<User>) userRepo.findAllById(userIds);	

		List<Imp> imps = newAd.getImp();
		Imp[] array = imps.toArray(new Imp[imps.size()]);
		for (int i=0; i<imps.size(); i++)
		{
			Imp imp = array[i];			
			bannerRepo.save(imp.getBanner());
			impRepo.save(imp);
		}

		newAd.setCampaign(campaign);
		adRepo.save(newAd);
		
		for(User user:users)
		{
			user.setAd(newAd);
			userRepo.save(user);

		}
		
		ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
	    objectNode.put("id", newAd.getId());
	    objectNode.put("bidid", newAd.getCampaign().getAdvertiser().getId());
	    ArrayNode tags = JsonNodeFactory.instance.arrayNode();
	    for (String str:newAd.getCur())
	    {
	    	tags.add(str);
	    }
	    objectNode.set("cur", tags);
	    return objectNode;
	}
}
