package backyard.programmer.backendtest.services;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.model.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(String id);

    List<BookDto> getAllBooks();
}
