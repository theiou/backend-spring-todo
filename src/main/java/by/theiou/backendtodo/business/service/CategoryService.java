package by.theiou.backendtodo.business.service;

import by.theiou.backendtodo.business.entity.Category;
import by.theiou.backendtodo.business.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findByEmail(String email){
        return categoryRepository.findByUserEmailOrderByTitleAsc(email);
    }

    public List<Category> findByTitle(String title, String email){
        return categoryRepository.findByTitle(title, email);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public Category update(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }


}
