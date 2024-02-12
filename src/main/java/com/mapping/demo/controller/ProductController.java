package com.mapping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.dto.Productdto;
import com.mapping.demo.services.ProductServices;


@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	public ProductServices productServices;

	@GetMapping("/all")
	public ResponseEntity<List<Productdto>> getAllproduct() {

		List<Productdto> products = productServices.fetchAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

//
	@PostMapping({ "/add", "/update" })
	public ResponseEntity<String> addProduct(@RequestBody Productdto productdto) {
		productServices.addProduct(productdto);
		return ResponseEntity.ok("success");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteProductByproductId(@RequestParam Long productId) {
		productServices.deleteProductByproductId(productId);
		// return new Response(200, "success", "Delete Suuccessful");

		return ResponseEntity.ok(" delete successful");

	}
	@GetMapping("/get")
	public ResponseEntity<Productdto>getProductByproductId(@RequestParam long productId){
		return ResponseEntity.ok(productServices.getProductByproductId(productId));
	}
}
