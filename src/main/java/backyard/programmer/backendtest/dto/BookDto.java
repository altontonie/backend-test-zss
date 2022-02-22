package backyard.programmer.backendtest.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class BookDto implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 987412365410321L;

    private long bookId;
    private String assignedBookId;
    private String title;
    private String description;
    private String price;
    private String category;
    private long categoryEntity;
}
