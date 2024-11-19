package com.paluski.library.category;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> readCategories(){
        return categoryRepository.findAll();
    }

    public Category editCategory(Long id, Category category){
        return categoryRepository.findById(id)
                .map(existCategory -> {
                    existCategory.setName(category.getName());
                    existCategory.setDescription(category.getDescription());
                    return categoryRepository.save(existCategory);
                })
                .orElseThrow(() -> new EntityNotFoundException("Category not found with this ID!"));
    }

    public void deleteCategory(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Category not found with this ID!");
        }
    }

}
