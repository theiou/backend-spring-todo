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

    public List<Category> find(String title, String email){
        return categoryRepository.find(title, email);
    }

    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public void update(Category category){
        categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }


}
