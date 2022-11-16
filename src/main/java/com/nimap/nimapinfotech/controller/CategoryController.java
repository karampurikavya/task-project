package com.nimap.nimapinfotech.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.nimapinfotech.entity.Category;
import com.nimap.nimapinfotech.repository.CategoryRepository;
import com.nimap.nimapinfotech.service.CategoryService;



@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	
	@Autowired
	private CategoryRepository categoryData;

	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Category> categoriesPageable(Pageable pageable) {
		return categoryData.findAll(pageable);

	}
	
	@PostMapping("/alow")
	private Category addCategory(@RequestBody Category category)
	{
		return service.saveCategory(category);
	}
	
	@GetMapping("/categories")
	private List<Category> getAllData()
	{
		return service.getCategory();
	}
	
	@GetMapping("/category/{id}")
	private Category findCategoryId(@PathVariable int id)
	{
		return service.getCategoryById(id);
	}
	
	@DeleteMapping("/delcate/{id}")
	private void deleteCategory(@PathVariable int id)
	{
		 service.deleteCategory(id);
	}
	
	@PutMapping("/upcate/{id}")
	private Category updateCategory(@PathVariable int id,@RequestBody Category category)
	{
		category.setId(id);
		return service.saveCategory(category);
	}

}

