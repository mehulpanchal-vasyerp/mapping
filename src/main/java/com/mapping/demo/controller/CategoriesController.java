package com.mapping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.demo.dto.Categoriesdto;
import com.mapping.demo.model.Category;
import com.mapping.demo.services.CategoryServices;


@RestController
@RequestMapping("/api/category")
public class CategoriesController {
	@Autowired
	public CategoryServices categoriesServices;

	@GetMapping("/all")
	public ResponseEntity<List<Categoriesdto>> getAllcategories() {

		List<Categoriesdto> categories = categoriesServices.getallCategoriesList();
		return ResponseEntity.ok(categories);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCategory(@RequestBody Categoriesdto categoriesdto){
		System.out.println(categoriesdto);
		categoriesServices.addCategories(categoriesdto);
		return ResponseEntity.ok("add success");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCategoriesById(@RequestParam long categoryID) {
		categoriesServices.deleteCategoriesById(categoryID);
		// return new Response(200, "success", "Delete Suuccessful");

		return ResponseEntity.ok(" delete successful");

	}

	@GetMapping("/get")
	public ResponseEntity<Categoriesdto>getCategoriesById(@RequestParam long  categoryID)
	{
		return ResponseEntity.ok(categoriesServices.getCategoriesById(categoryID));
	}
}
