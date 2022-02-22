package backyard.programmer.backendtest.services;

import backyard.programmer.backendtest.dto.BookDto;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(String id);
}
