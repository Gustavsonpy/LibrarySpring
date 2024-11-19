package com.paluski.library.book;

import com.paluski.library.book_copy.BookCopy;
import com.paluski.library.category.Category;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String name;
    private int pages;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "fk_catogory", nullable = false)
    private Category fk_category;

    @OneToMany(mappedBy = "fk_book", cascade = CascadeType.ALL)
    private List<BookCopy> booksCopy;

    public Book() {
    }

    public Book(Long id, String name, int pages, String autor, Category fk_category) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.autor = autor;
        this.fk_category = fk_category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Category getFk_category() {
        return fk_category;
    }

    public void setFk_category(Category fk_category) {
        this.fk_category = fk_category;
    }
}
