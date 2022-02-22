package backyard.programmer.backendtest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    public CategoryEntity(String title) {
        this.title = title;
    }
}
