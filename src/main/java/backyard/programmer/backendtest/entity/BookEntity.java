package backyard.programmer.backendtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}
