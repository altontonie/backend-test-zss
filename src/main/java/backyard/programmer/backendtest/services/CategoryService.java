package backyard.programmer.backendtest.services;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.model.request.BookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    CategoryDto createBook(CategoryDto categoryDto);

    CategoryDto addCategory(CategoryDto category);

    List<CategoryDto> getAllCategories();

    CategoryDto getBookById(String id);

    List<CategoryDto> getAllBooks();

    CategoryDto updateBook(String id, BookRequest bookDetails);
}
