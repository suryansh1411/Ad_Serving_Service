package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "imp")
public class Imp {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imp_id;
	private Long id;
	private double bidfloor;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "imp")
	private Banner banner;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ad_id")
	private Ad ad;

	
	public Long getImp_id() {
		return imp_id;
	}

	public void setImp_id(Long imp_id) {
		this.imp_id = imp_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBidfloor() {
		return bidfloor;
	}

	public void setBidfloor(double bidfloor) {
		this.bidfloor = bidfloor;
	}

	public Banner getBanner() {
		return banner;
	}

	public void setBanner(Banner banner) {
		this.banner = banner;
	}
	
	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

}
