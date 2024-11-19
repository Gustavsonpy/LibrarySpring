package com.paluski.library.book;

import com.paluski.library.category.Category;

public class BookDTO {

    private Long id;

    private String name;
    private int pages;
    private String autor;
    private Long fk_category;

    public BookDTO() {
    }

    public BookDTO(Long id, String name, int pages, String autor, Long fk_category) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.autor = autor;
        this.fk_category = fk_category;
    }

    //Getters and Setters
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

    public Long getFk_category() {
        return fk_category;
    }

    public void setFk_category(Long fk_category) {
        this.fk_category = fk_category;
    }
}
