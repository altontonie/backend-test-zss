package backyard.programmer.backendtest.repository;

import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends CrudRepository<BookEntity,Long> {
    BookEntity findByAssignedBookId(String id);
    List<BookEntity> findByCategoryEntity(CategoryEntity category);
}
