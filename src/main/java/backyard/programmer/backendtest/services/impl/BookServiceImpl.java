package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public BookDto createBook(BookDto bookDto) {
        if(categoryRepo.findByTitle(bookDto.getCategory()) != null){
            CategoryEntity titleId = categoryRepo.findByTitle(bookDto.getTitle());
            bookDto.setBookId(UUID.randomUUID().toString());
            bookDto.setCategoryId(titleId.getId());
        }


        return null;
    }
}
