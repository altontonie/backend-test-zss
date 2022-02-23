package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.model.request.BookRequest;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    CategoryRepo categoryRepo;

}
