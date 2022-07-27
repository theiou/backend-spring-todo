package by.theiou.backendtodo.business.service;

import by.theiou.backendtodo.business.entity.Category;
import by.theiou.backendtodo.business.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
