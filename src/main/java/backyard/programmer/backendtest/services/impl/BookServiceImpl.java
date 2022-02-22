package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.model.response.BookResponse;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.BookService;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
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
            CategoryDto addCategory = new CategoryDto(bookDto.getCategory());
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

    @Override
    public BookDto getBookById(String id) {
        BookDto bookDto = new BookDto();
        BookEntity bookEntity = bookRepo.findByAssignedBookId(id);
        BeanUtils.copyProperties(bookEntity,bookDto);
        return bookDto;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> showBooks = new ArrayList<>();
        List<BookEntity> books = (List<BookEntity>) bookRepo.findAll();
        for (BookEntity book:books) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            showBooks.add(bookDto);
        }
        return showBooks;
    }
}
