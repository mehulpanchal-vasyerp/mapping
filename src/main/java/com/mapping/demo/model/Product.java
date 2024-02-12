package com.mapping.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data

public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productID;
	@Column(name="product_name")
	private String productName;
	@Column(name="price")
	private long price;
	
	@ManyToOne
	@JoinColumn(name="categories_id")
private Category categories;
}

