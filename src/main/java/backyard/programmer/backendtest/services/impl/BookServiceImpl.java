package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.BookService;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    CategoryService categoryService;

    @Override
    public BookDto createBook(BookDto bookDto) {
        BookDto returnBook = new BookDto();
        CategoryEntity titleId;
        if(categoryRepo.findByTitle(bookDto.getCategory()) != null){
            titleId = categoryRepo.findByTitle(bookDto.getTitle());
        }else{
            CategoryEntity addCategory = new CategoryEntity(bookDto.getCategory());
            titleId = categoryService.addCategory(addCategory);
        }

        bookDto.setAssignedBookId(UUID.randomUUID().toString());
        bookDto.setCategoryEntity(titleId.getCategoryId());
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDto,bookEntity);
        BookEntity createdBook = bookRepo.save(bookEntity);
        BeanUtils.copyProperties(createdBook,returnBook);

        return returnBook;
    }
}
