package backyard.programmer.backendtest.model.response;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.BookRespDto;
import lombok.Data;

@Data
public class BookResponse {
    private String categoryTitle;
    private BookDto bookDto;
}
