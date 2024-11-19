package com.paluski.library.loan;

import com.paluski.library.book_copy.BookCopy;
import com.paluski.library.user.User;
import jakarta.transaction.Transactional;

import java.util.Date;

public class LoanDTO {
    private Long id;
    private Date loan_date;
    private Date return_date;
    private Long fk_user;
    private Long fk_book_copy;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Date loan_date, Date return_date, Long fk_user, Long fk_book_copy) {
        this.id = id;
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

    public Long getFk_user() {
        return fk_user;
    }

    public void setFk_user(Long fk_user) {
        this.fk_user = fk_user;
    }

    public Long getFk_book_copy() {
        return fk_book_copy;
    }

    public void setFk_book_copy(Long fk_book_copy) {
        this.fk_book_copy = fk_book_copy;
    }
}
