package com.mapping.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.demo.dto.Productdto;
import com.mapping.demo.model.Product;
import com.mapping.demo.repository.CategoryRepository;
import com.mapping.demo.repository.ProductRepository;



@Service
public class ProductServicesImpl implements ProductServices{
	@Autowired
	public ProductRepository productrepository;
	@Autowired
	public CategoryRepository categoriesrepository;
	
	public List<Productdto> fetchAllProducts() {
		List<Product> products = productrepository.findAll(); //
		List<Productdto> productdtos = new ArrayList<Productdto>();
		for (Product product : products) {
			Productdto productdto = new Productdto();
			productdto.setProductID(product.getProductID());
			productdto.setProductName(product.getProductName());
			productdto.setPrice(product.getPrice());
			
			productdto.setCategories(product.getCategories() );
			productdtos.add(productdto);

		}
		return productdtos;
	}

	public Productdto getProductByproductId(long productID) {
		Product product = productrepository.findById(productID).get();
				//.orElseThrow(() -> new PeopleNotFoundException("People not found"));
		Productdto productdto = new Productdto();
		productdto.setProductID(product.getProductID()); // model to dto
		productdto.setProductName(product.getProductName());
		productdto.setPrice(product.getPrice());
		productdto.setCategories(product.getCategories());

		return productdto;
	}

//	public void deleteProductByproductId(long ProductID) {
////		Product product = productrepository.findById(ProductID).get();
//		//.orElseThrow(() -> new PeopleNotFoundException("People not found"));
//		productrepository.deleteById(ProductID);
//		
//	}

	public boolean addProduct(Productdto productdto) {
		Product product = new Product(); // model object dto to model
//		product.setProductID(productdto.getProductID());
		product.setProductName(productdto.getProductName());
		product.setPrice(productdto.getPrice());
		productrepository.save(product);
		return true;
	
	}

	@Override
	public void deleteProductByproductId(long productID) {
		// TODO Auto-generated method stub
		productrepository.deleteById(productID);
		
	}


//@Override
//public void deleteProductByproductId(long ProductID) {
//	Product product = productrepository.findById(ProductID).get().orElseThrow(() -> new PeopleNotFoundException("People not found"));
//	productrepository.deleteById(ProductID);
//}
}
