package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "_user")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @JsonBackReference
	 @ManyToOne
	 @JoinColumn(name = "ad_id")
	 private Ad ad;
	 
	 private float max_height;
	 private float max_width;
	 private String industry;
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public float getMax_height() {
		return max_height;
	}

	public void setMax_height(float max_height) {
		this.max_height = max_height;
	}

	public float getMax_width() {
		return max_width;
	}

	public void setMax_width(float max_width) {
		this.max_width = max_width;
	}
	 
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
}

