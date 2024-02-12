package com.mapping.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mapping.demo.dto.Productdto;


@Component

public interface ProductServices {

	List<Productdto> fetchAllProducts();

	Productdto getProductByproductId(long productID);

void deleteProductByproductId(long productID);

	boolean addProduct(Productdto productdto);

}
