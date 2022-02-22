package backyard.programmer.backendtest.model.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private String description;
    private String price;
    private String category;
}
