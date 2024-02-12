package com.mapping.demo.dto;

import com.mapping.demo.model.Category;

import lombok.Data;

@Data
public class Productdto {
	
		private long productID;
		private String productName;
		private long price;
		
	private Category categories;

}
