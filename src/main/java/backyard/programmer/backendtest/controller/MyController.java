package backyard.programmer.backendtest.controller;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.model.request.BookRequest;
import backyard.programmer.backendtest.model.request.CategoryRequest;
import backyard.programmer.backendtest.model.request.PurchaseBook;
import backyard.programmer.backendtest.model.request.PurchaseRequest;
import backyard.programmer.backendtest.model.response.BookResponse;
import backyard.programmer.backendtest.model.response.CategoryResponse;
import backyard.programmer.backendtest.model.response.PurchaseResponse;
import backyard.programmer.backendtest.services.BookService;
import backyard.programmer.backendtest.services.CategoryService;
import backyard.programmer.backendtest.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")  // http://localhost:8181/books
public class MyController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PaymentService paymentService;

    @GetMapping(path = "/{id}")
    public BookResponse getBook(@PathVariable String id){
        BookResponse bookResponse = new BookResponse();
        BookDto bookDto = bookService.getBookById(id);
        BeanUtils.copyProperties(bookDto,bookResponse);
        return bookResponse;
    }

    @GetMapping(path = "/")
    public List<BookResponse> getAllBooks(){
        List<BookResponse> books = new ArrayList<>();
        List<BookDto> bookDtos = bookService.getAllBooks();
        for (BookDto book :
                bookDtos) {
            BookResponse theBook = new BookResponse();
            BeanUtils.copyProperties(book,theBook);
            books.add(theBook);
        }
        return books;
    }

    @GetMapping(path = "/category")
    public List<CategoryResponse> getCategory(){
        List<CategoryResponse> categories = new ArrayList<>();
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        for (CategoryDto category :
                categoryDtos) {
            CategoryResponse categoryResponse = new CategoryResponse();
            BeanUtils.copyProperties(category,categoryResponse);
            categories.add(categoryResponse);
        }
        return categories;
    }

    @PostMapping(path = "/")
    public BookResponse addBook(@RequestBody BookRequest bookDetails){
        BookResponse bookResponse = new BookResponse();
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(bookDetails,bookDto);
        BookDto createdBook = bookService.createBook(bookDto);
        BeanUtils.copyProperties(createdBook,bookResponse);
        return bookResponse;
    }

    @PostMapping(path = "/category")
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryDetails){
        CategoryResponse response = new CategoryResponse();
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(categoryDetails,categoryDto);
        CategoryDto createdCategory = categoryService.addCategory(categoryDto);
        BeanUtils.copyProperties(createdCategory,response);
        return response;
    }

    @PostMapping(path = "/purchase")
    public PurchaseResponse purchase(@RequestBody PurchaseBook purchaseBook){
        PurchaseRequest purchase = new PurchaseRequest();
        purchase.getCard().setId(purchaseBook.getId());
        PurchaseResponse response = paymentService.purchase(purchase);
        return response;
    }

    @PutMapping(path = "/{id}")
    public String updateBook(){
        return "update book";
    }

}
