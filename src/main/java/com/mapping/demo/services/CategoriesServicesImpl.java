package com.mapping.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.demo.dto.Categoriesdto;
import com.mapping.demo.model.Category;
import com.mapping.demo.repository.CategoryRepository;


@Service
public class CategoriesServicesImpl implements CategoryServices {
	@Autowired
	public CategoryRepository categoriesrepository;

	@Override
	public List<Categoriesdto> getallCategoriesList() {
		List<Category> categories = categoriesrepository.findAll();
		List<Categoriesdto> categoriesdtos = new ArrayList<>();
		for (Category categories2 : categories) {
			Categoriesdto categoriesdto = new Categoriesdto();
			categoriesdto.setCategoryID(categories2.getCategoryID());
			categoriesdto.setCategoryName(categories2.getCategoryName());
			categoriesdtos.add(categoriesdto);

		}

		return categoriesdtos;
	}

	@Override
	public void deleteCategoriesById(long categoryID) {
		// Categories categories=categoriesrepository.findById(CategoryID);
		categoriesrepository.deleteById(categoryID);

	}

	@Override
	public Categoriesdto getCategoriesById(long categoryID) {
		Category categories = categoriesrepository.findById(categoryID).get();
		// .orElseThrow(() -> new PeopleNotFoundException("People not found"));
		Categoriesdto categoriesdto = new Categoriesdto();
		categoriesdto.setCategoryID(categories.getCategoryID()); // model to dto
		categoriesdto.setCategoryName(categories.getCategoryName());

		return categoriesdto;
	}

	@Override
	public void addCategories(Categoriesdto categoriesdto) {
		Category categories = new Category(); // model object dto to model
//		categories.setCategoryID(categoriesdto.getCategoryID());
		categories.setCategoryName(categoriesdto.getCategoryName());

		categoriesrepository.save(categories);

	}

}
