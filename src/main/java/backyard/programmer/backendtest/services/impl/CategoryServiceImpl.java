package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        CategoryEntity titleId = categoryRepo.save(category);
        return titleId;
    }
}
