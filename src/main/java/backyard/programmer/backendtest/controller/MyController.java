package backyard.programmer.backendtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class MyController {

    @GetMapping
    public String GetBook(){
        return "get a book";
    }

    @GetMapping
    public String GetAllBooks(){
        return "get all books";
    }

    @GetMapping
    public String GetCategory(){
        return "get categories";
    }

    @PostMapping
    public String AddBook(){
        return "add book";
    }

    @PostMapping
    public String Purchase(){
        return "purchase book";
    }

    @PutMapping
    public String UpdateBook(){
        return "update book";
    }

}
