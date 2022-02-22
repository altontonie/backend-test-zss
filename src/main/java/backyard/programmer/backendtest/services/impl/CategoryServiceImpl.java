package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryDto addCategory(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category,categoryEntity);
        CategoryEntity titleId = categoryRepo.save(categoryEntity);

        CategoryDto returnId = new CategoryDto();
        BeanUtils.copyProperties(titleId,returnId);
        return returnId;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepo.findAll();
        for (CategoryEntity category :
                categories) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category,categoryDto);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
