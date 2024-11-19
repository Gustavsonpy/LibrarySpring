package com.paluski.library.book;

import com.paluski.library.category.Category;

public class BookMapper {

     //Metodo para converter Book -> BookDTO
    public static BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getName(),
                book.getPages(),
                book.getAutor(),
                book.getFk_category() != null ? book.getFk_category().getId() : null
        );
    }

    // Metodo para converter BookDTO -> Book
    public static Book toBook(BookDTO bookDTO, Category category) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setPages(bookDTO.getPages());
        book.setAutor(bookDTO.getAutor());
        book.setFk_category(category);
        return book;
    }
}
