package backyard.programmer.backendtest.dto;

import lombok.Data;

@Data
public class BookRespDto {
    private String assignedBookId;
    private String title;
    private String description;
    private String price;
}
