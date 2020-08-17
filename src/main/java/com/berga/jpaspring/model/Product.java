package com.berga.jpaspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products", schema="product")
public class Product {

	@Id
	private String id;
	private String name;
	private Color color;
	private Double price;
	private Size size;
	
	public Product() {
	}
	
	public Product(String id, String name, Color color, Double price, Size size){
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "Product : {\"id\":\""+id+"\", \"name\":\""+name+"\", \"color\":\""+color+"\", \"price\":\""+price+"\", \"size\":\""+size+"\",}";
	}
}
