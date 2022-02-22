package backyard.programmer.backendtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Books")
@Data
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue
    private long bookId;

    @Column(nullable = false)
    private String assignedBookId;

    @Column(nullable = false)
    private String title;

    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}
