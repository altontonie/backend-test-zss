package backyard.programmer.backendtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private long categoryId;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "categoryEntity",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Collection<BookEntity> bookEntity = new ArrayList<BookEntity>();

    public CategoryEntity(String title) {
        this.title = title;
    }
}
