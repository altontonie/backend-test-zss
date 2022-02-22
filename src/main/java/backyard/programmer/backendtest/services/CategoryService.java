package backyard.programmer.backendtest.services;

import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto addCategory(CategoryDto category);

    List<CategoryDto> getAllCategories();
}
