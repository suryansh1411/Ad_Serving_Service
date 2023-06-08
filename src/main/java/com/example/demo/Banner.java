package com.example.demo;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "banner")
public class Banner {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float width;
	private float height;
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
	public float getWidth() {
		return width;
	}
	public void setW(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
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
