package com.FitnessController.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;



@Entity
@Table(name="fitness")
public class shopdbadmin {
	
	@Id
	@GeneratedValue
	@Column(name="p_Id")
	private Integer id;
		
	@Column(name="p_name")
	private String name;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="quantity")
	private Integer quantity;

	@Column(name="total")
	private Integer total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	}




