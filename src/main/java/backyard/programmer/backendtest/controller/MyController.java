package backyard.programmer.backendtest.controller;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.model.request.BookRequest;
import backyard.programmer.backendtest.model.response.BookResponse;
import backyard.programmer.backendtest.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/books")  // http://localhost:8181/books
public class MyController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/{id}")
    public String GetBook(){
        return "get a book";
    }

    @GetMapping(path = "/")
    public String GetAllBooks(){
        return "get all books";
    }

    @GetMapping(path = "/category")
    public String GetCategory(){
        return "get categories";
    }

    @PostMapping(path = "/")
    public BookResponse AddBook(@RequestBody BookRequest bookDetails){
        BookResponse bookResponse = new BookResponse();
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(bookDetails,bookDto);
        BookDto createdBook = bookService.createBook(bookDto);
        BeanUtils.copyProperties(createdBook,bookResponse);
        return bookResponse;
    }

    @PostMapping(path = "/purchase")
    public String Purchase(){
        return "purchase book";
    }

    @PutMapping(path = "/{id}")
    public String UpdateBook(){
        return "update book";
    }

}
