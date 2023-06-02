package com.example.demo;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "banner")
public class Banner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int w;
	private int h;
	private int pos;
	
	@JsonBackReference
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "imp_id")
	private Imp imp;
	
	public Imp getImp() {
		return imp;
	}
	public void setImp(Imp imp) {
		this.imp = imp;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
