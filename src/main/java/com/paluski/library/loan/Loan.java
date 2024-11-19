package com.paluski.library.loan;

import com.paluski.library.book_copy.BookCopy;
import com.paluski.library.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    private String name;
    private Date loan_date;
    private Date return_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user", nullable = false)
    private User fk_user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_book_copy")
    private BookCopy fk_book_copy;

    public Loan() {
    }

    public Loan(Long id, String name, Date loan_date, Date return_date, User fk_user, BookCopy fk_book_copy) {
        this.id = id;
        this.name = name;
        this.loan_date = loan_date;
        this.return_date = return_date;
        this.fk_user = fk_user;
        this.fk_book_copy = fk_book_copy;
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

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public User getFk_user() {
        return fk_user;
    }

    public void setFk_user(User fk_user) {
        this.fk_user = fk_user;
    }

    public BookCopy getFk_book_copy() {
        return fk_book_copy;
    }

    public void setFk_book_copy(BookCopy fk_book_copy) {
        this.fk_book_copy = fk_book_copy;
    }
}
