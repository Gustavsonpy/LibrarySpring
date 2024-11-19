package com.paluski.library.book_copy;

public class BookCopyDTO {

    private Long id;
    private int quantity;
    private Long fk_book;

    public BookCopyDTO() {
    }

    public BookCopyDTO(Long id, Long fk_book) {
        this.id = id;
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

    public Long getFk_book() {
        return fk_book;
    }

    public void setFk_book(Long fk_book) {
        this.fk_book = fk_book;
    }
}
