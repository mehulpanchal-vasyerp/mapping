package com.mapping.demo.services;

import java.util.List;

import com.mapping.demo.dto.Categoriesdto;

public interface CategoryServices {
	List<Categoriesdto> getallCategoriesList();

	void deleteCategoriesById(long categoryID);

	Categoriesdto getCategoriesById(long categoryID);

	void addCategories(Categoriesdto categoriesdto);

}
