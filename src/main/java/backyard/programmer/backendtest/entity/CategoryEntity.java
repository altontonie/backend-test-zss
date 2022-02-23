package backyard.programmer.backendtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity(name = "Category")
@Data
public class CategoryEntity {
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "jpaPkSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    private long categoryId;

    private String categoryTitle;

    @OneToMany(mappedBy = "categoryEntity",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Collection<BookEntity> bookEntity = new ArrayList<BookEntity>();

}
