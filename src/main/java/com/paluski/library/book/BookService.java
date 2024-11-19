package com.paluski.library.book;

import com.paluski.library.category.Category;
import com.paluski.library.category.ICategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ICategoryRepository categoryRepository;


    public BookDTO createBook(BookDTO bookDTO) {
        Category category = categoryRepository.findById(bookDTO.getFk_category())
                .orElseThrow(() -> new EntityNotFoundException());

        Book book = BookMapper.toBook(bookDTO, category);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    public List<BookDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookMapper::toDTO).collect(Collectors.toList());
    }

//    public BookDTO editBook(Long id, Book book) {
//        return bookRepository.findById(id)
//                .map(existingBook -> {
//                    existingBook.setName(book.getName());
//                    existingBook.setPages(book.getPages());
//                    existingBook.setAutor(book.getAutor());
//                    existingBook.setFk_category(book.getFk_category());
//                    return bookRepository.save(existingBook);
//                })
//                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
//    }

    public BookDTO editBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found!"));

        Category category = categoryRepository.findById(bookDTO.getFk_category())
                .orElseThrow(() -> new EntityNotFoundException("Category not found!"));

        book.setName(bookDTO.getName());
        book.setPages(bookDTO.getPages());
        book.setAutor(bookDTO.getAutor());
        book.setFk_category(category);

        bookRepository.save(book);

        return BookMapper.toDTO(book);
    }

    public void deleteBook(Long id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }
}