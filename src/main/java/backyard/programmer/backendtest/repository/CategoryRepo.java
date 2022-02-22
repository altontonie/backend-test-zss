package backyard.programmer.backendtest.repository;

import backyard.programmer.backendtest.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<CategoryEntity,Long> {
}
