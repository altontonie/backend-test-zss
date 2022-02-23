package backyard.programmer.backendtest.model.request;

import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.model.Book;
import lombok.Data;

@Data
public class BookRequest {
    private String categoryTitle;
    private Book book;
}
