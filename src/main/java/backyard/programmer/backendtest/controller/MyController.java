package backyard.programmer.backendtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("books")  // http://localhost:8181/books
public class MyController {

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
    public String AddBook(){
        return "add book";
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
