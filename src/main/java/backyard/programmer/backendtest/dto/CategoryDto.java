package backyard.programmer.backendtest.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 525252365410321L;

    private long categoryId;
    private String categoryTitle;
    private BookDto bookDto = new BookDto();

    public CategoryDto(String category) {
//        this.categoryId = 1;
        this.categoryTitle = category;
    }
}
