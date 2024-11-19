package com.paluski.library.category;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/v1/newCategory")
    public ResponseEntity<Category> postCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/v1/getCategories")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok(categoryService.readCategories());
    }

    @PutMapping("/v1/editCategory/{id}")
    public ResponseEntity<String> editCategory(@PathVariable Long id, @RequestBody Category category){
        try{
            categoryService.editCategory(id, category);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found!");
        }
        return ResponseEntity.ok("Category edited successfully!");
    }

    @DeleteMapping("/v1/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        try{
            categoryService.deleteCategory(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: "+e.getMessage());
        }
        return ResponseEntity.ok("Category deleted successfully!");
    }
}
