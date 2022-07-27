package by.theiou.backendtodo.business.controller;

import by.theiou.backendtodo.business.entity.Category;
import by.theiou.backendtodo.business.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/all")
    public List<Category> findAll(@RequestBody String email){
        return categoryService.findByEmail(email);
    }
}
