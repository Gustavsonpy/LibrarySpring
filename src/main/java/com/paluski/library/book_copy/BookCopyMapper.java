package com.paluski.library.book_copy;

import com.paluski.library.book.Book;
import com.paluski.library.book.BookDTO;

public class BookCopyMapper {

    public static BookCopyDTO toDTO(BookCopy bookCopy){
        return new BookCopyDTO(
                bookCopy.getId(),
                bookCopy.getFk_book() != null ? bookCopy.getId() : null
        );
    }

    public static BookCopy toBookCopy(BookCopyDTO bookCopyDTO, Book book){
        BookCopy bookCopy = new BookCopy();
        bookCopy.setId(bookCopyDTO.getId());
        bookCopy.setQuantity(bookCopyDTO.getQuantity());
        bookCopy.setFk_book(book);
        return bookCopy;
    }

}
