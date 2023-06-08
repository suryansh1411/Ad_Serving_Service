package com.example.demo;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.*;



@Entity
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Integer at;
	private List <String> cur;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "ad")
	private List <Imp> imp;
	
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
    
	@JsonManagedReference
	@OneToMany(mappedBy = "ad")
	private List<User> users;
    
    public Long getId() {
		return id;
	}

	public Integer getAt() {
		return at;
	}

	public void setAt(Integer at) {
		this.at = at;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<String> getCur() {
		return cur;
	}

	public void setCur(List<String> cur) {
		this.cur = cur;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public List<Imp> getImp() {
		return imp;
	}

	public void setImp(List<Imp> imp) {
		this.imp = imp;
	}

	public List<User> getUsers() {
		return users;
	}
	

	public void setUsers(List<User> users) {
		this.users = new LinkedList<User>();
		for (User user:users)
		{
			this.users.add(user);
		}
	}

	public void addUsers(User user)
	{
		this.users.add(user);
	}
}

