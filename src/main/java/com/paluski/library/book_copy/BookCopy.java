package com.paluski.library.book_copy;

import com.paluski.library.book.Book;
import jakarta.persistence.*;

@Entity
public class BookCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookCopy_id")
    private Long id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "fk_book")
    private Book fk_book;

    public BookCopy() {
    }

    public BookCopy(Long id, int quantity, Book fk_book) {
        this.id = id;
        this.quantity = quantity;
        this.fk_book = fk_book;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Book getFk_book() {
        return fk_book;
    }

    public void setFk_book(Book fk_book) {
        this.fk_book = fk_book;
    }
}
