package backyard.programmer.backendtest.model.response;

import lombok.Data;

@Data
public class BookResponse {
    private String assignedBookId;
    private String title;
    private String description;
    private String price;
    private String category;
}
