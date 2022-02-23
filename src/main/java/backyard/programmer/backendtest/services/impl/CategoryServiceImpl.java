package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.model.request.BookRequest;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    BookRepo bookRepo;

    @Override
    public CategoryDto createBook(CategoryDto categoryDto) {
        CategoryDto returnBook = new CategoryDto();
        BookEntity bookEntity = new BookEntity();
        CategoryEntity titleId = null;
        CategoryDto addCategory;
        if(categoryRepo.findByCategoryTitle(categoryDto.getCategoryTitle()) != null){
            titleId = categoryRepo.findByCategoryTitle(categoryDto.getCategoryTitle());
            categoryDto.getBookDto().setCategoryId(titleId.getCategoryId());
            returnBook.setCategoryTitle(titleId.getCategoryTitle());
            bookEntity.setCategoryEntity(titleId);
        }else{
            addCategory = addCategory(new CategoryDto(categoryDto.getCategoryTitle()));
            categoryDto.getBookDto().setCategoryId(addCategory.getCategoryId());
            returnBook.setCategoryTitle(addCategory.getCategoryTitle());
            CategoryEntity categoryEntity = new CategoryEntity();
            BeanUtils.copyProperties(addCategory,categoryEntity);
            bookEntity.setCategoryEntity(categoryEntity);
        }

        categoryDto.getBookDto().setAssignedBookId(UUID.randomUUID().toString());

        BeanUtils.copyProperties(categoryDto.getBookDto(),bookEntity);

        BookEntity createdBook = bookRepo.save(bookEntity);
        BeanUtils.copyProperties(createdBook,returnBook.getBookDto());
        returnBook.getBookDto().setCategoryId(categoryDto.getBookDto().getCategoryId());
        return returnBook;
    }

    @Override
    public CategoryDto addCategory(CategoryDto category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(category,categoryEntity);
        CategoryEntity titleId = categoryRepo.save(categoryEntity);

        CategoryDto returnId = new CategoryDto();
        BeanUtils.copyProperties(titleId,returnId);
        return returnId;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepo.findAll();
        for (CategoryEntity category :
                categories) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(category,categoryDto);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getBookById(String id) {
        CategoryDto categoryDto = new CategoryDto();
        BookEntity bookEntity = bookRepo.findByAssignedBookId(id);
        BeanUtils.copyProperties(bookEntity,categoryDto.getBookDto());
        categoryDto.setCategoryTitle(bookEntity.getCategoryEntity().getCategoryTitle());
        categoryDto.getBookDto().setCategoryId(bookEntity.getCategoryEntity().getCategoryId());

        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllBooks() {
        List<CategoryDto> showBooks = new ArrayList<>();
        List<BookEntity> books = (List<BookEntity>) bookRepo.findAll();
        for (BookEntity book:books) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(book,categoryDto.getBookDto());
            categoryDto.setCategoryTitle(book.getCategoryEntity().getCategoryTitle());
            categoryDto.getBookDto().setCategoryId(book.getCategoryEntity().getCategoryId());

            showBooks.add(categoryDto);
        }
        return showBooks;
    }

    @Override
    public CategoryDto updateBook(String id, BookRequest bookDetails) {
        CategoryDto returnBook = new CategoryDto();
        CategoryDto addCategory = new CategoryDto();
        BookEntity bookEntity = bookRepo.findByAssignedBookId(id);
        if(bookEntity == null){
            throw new RuntimeException("Invalid book id");
        }

        if(categoryRepo.findByCategoryTitle(bookDetails.getCategoryTitle()) == null) {
            addCategory = addCategory(new CategoryDto(bookDetails.getCategoryTitle()));
        }

        BeanUtils.copyProperties(bookEntity,addCategory.getBookDto());
        addCategory.getBookDto().setPrice(bookDetails.getBook().getPrice());
        addCategory.getBookDto().setDescription(bookDetails.getBook().getDescription());
        addCategory.getBookDto().setTitle(bookDetails.getBook().getTitle());
        addCategory.getBookDto().setAssignedBookId(id);
        addCategory.getBookDto().setBookId(bookEntity.getBookId());

        CategoryEntity categoryEntity = categoryRepo.findByCategoryTitle(bookDetails.getCategoryTitle());

        BookEntity updateBook = new BookEntity();
        BeanUtils.copyProperties(addCategory.getBookDto(),updateBook);
        updateBook.setCategoryEntity(categoryEntity);

        final BookEntity updatedBook = bookRepo.save(updateBook);
        BeanUtils.copyProperties(updatedBook,returnBook.getBookDto());
        returnBook.setCategoryId(categoryEntity.getCategoryId());
        returnBook.setCategoryTitle(categoryEntity.getCategoryTitle());
        returnBook.getBookDto().setCategoryId(categoryEntity.getCategoryId());
        return returnBook;
    }

    @Override
    public List<CategoryDto> getAllBooksByCategory(String title) {
        List<CategoryDto> showBooks = new ArrayList<>();
        CategoryEntity categoryEntity = categoryRepo.findByCategoryTitle(title);
        List<BookEntity> books = bookRepo.findByCategoryEntity(categoryEntity);
        for (BookEntity book:books) {
            CategoryDto categoryDto = new CategoryDto();
            BeanUtils.copyProperties(book,categoryDto.getBookDto());
            categoryDto.setCategoryTitle(book.getCategoryEntity().getCategoryTitle());
            categoryDto.getBookDto().setCategoryId(book.getCategoryEntity().getCategoryId());

            showBooks.add(categoryDto);
        }
        return showBooks;
    }
}
