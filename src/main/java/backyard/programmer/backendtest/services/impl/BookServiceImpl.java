package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.dto.BookDto;
import backyard.programmer.backendtest.dto.CategoryDto;
import backyard.programmer.backendtest.entity.BookEntity;
import backyard.programmer.backendtest.entity.CategoryEntity;
import backyard.programmer.backendtest.repository.BookRepo;
import backyard.programmer.backendtest.repository.CategoryRepo;
import backyard.programmer.backendtest.services.BookService;
import backyard.programmer.backendtest.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    CategoryRepo categoryRepo;


}
