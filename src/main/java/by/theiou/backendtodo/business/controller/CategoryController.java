package by.theiou.backendtodo.business.controller;

import by.theiou.backendtodo.business.entity.Category;
import by.theiou.backendtodo.business.search.CategorySearchValues;
import by.theiou.backendtodo.business.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues){
        List<Category> categories = categoryService.find(categorySearchValues.getTitle(), categorySearchValues.getEmail());
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/id")
    public ResponseEntity<Category> findById(@RequestBody Long id){
        Category category = null;
        try {
            category = categoryService.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(category);
    }

    @PutMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category){
        if (category.getId() != null && category.getId() != 0)
            return new ResponseEntity("redundant param: id must be null", HttpStatus.NOT_ACCEPTABLE);

        if (category.getTitle() == null || category.getTitle().trim().length() == 0)
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);

        return ResponseEntity.ok(categoryService.add(category));
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestBody Category category){
        if (category.getId() == null || category.getId() == 0)
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);

        if (category.getTitle() == null || category.getTitle().trim().length() == 0)
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);

        categoryService.update(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long id){
        try{
            categoryService.delete(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("id: " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity(HttpStatus.OK);
    }




}
