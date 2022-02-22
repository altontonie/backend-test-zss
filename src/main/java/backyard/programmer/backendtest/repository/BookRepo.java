package backyard.programmer.backendtest.repository;

import backyard.programmer.backendtest.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity,Long> {
    BookEntity findByAssignedBookId(String id);
}
