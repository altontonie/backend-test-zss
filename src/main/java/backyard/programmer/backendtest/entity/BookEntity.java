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
    private long id;

    @Column(nullable = false)
    private String bookId;

    @Column(nullable = false)
    private String title;

    private String description;
    private String price;

    @OneToOne
    private CategoryEntity categoryEntity;
}
