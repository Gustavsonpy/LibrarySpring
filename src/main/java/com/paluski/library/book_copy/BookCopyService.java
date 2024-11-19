package com.paluski.library.book_copy;

import com.paluski.library.book.Book;
import com.paluski.library.book.BookRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCopyService {

    @Autowired
    IBookCopyRepository bookCopyRepository;

    @Autowired
    BookRepository bookRepository;

    public void createBookCopy(BookCopyDTO bookCopyDTO){
        System.out.println("Book FK: "+bookCopyDTO.getFk_book());
        Book book = bookRepository.findById(bookCopyDTO.getFk_book())
                .orElseThrow(() -> new EntityNotFoundException("Book not found!"));

        BookCopy existBookCopy = bookCopyRepository.findBookCopyWithName(book.getName())
                .orElse(null);

        System.out.println("Book's name: "+book.getName());

        if(existBookCopy == null){
            bookCopyRepository.save(BookCopyMapper.toBookCopy(bookCopyDTO, book));
        }else{
            throw new EntityExistsException("Book copy already exists!");
        }
    }

    public List<BookCopy> getBooksCopies(){
        return bookCopyRepository.findAll();
    }

    public BookCopyDTO editBookCopy(Long id, BookCopyDTO bookCopyDTO){
        BookCopy bookCopy = bookCopyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book copy not found!"));

        Book book = bookRepository.findById(bookCopyDTO.getFk_book())
                        .orElseThrow(() -> new EntityNotFoundException("Book not found!"));

        bookCopy.setQuantity(bookCopyDTO.getQuantity());
        bookCopy.setFk_book(book);

        bookCopyRepository.save(bookCopy);

        return BookCopyMapper.toDTO(bookCopy);
    }

    public void deleteBookCopy(Long id){
        if(bookCopyRepository.existsById(id)){
            bookCopyRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Book copy not found!");
        }
    }
}
