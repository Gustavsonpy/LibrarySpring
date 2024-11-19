package com.paluski.library.loan;

import com.paluski.library.book_copy.BookCopy;
import com.paluski.library.user.User;

public class LoanMapper {

    public static LoanDTO toDTO(Loan loan){
        return new LoanDTO(
                loan.getId(),
                loan.getName(),
                loan.getLoan_date(),
                loan.getReturn_date(),
                loan.getFk_user(),
                loan.getFk_book_copy()
        );
    }

    public static Loan toNormalLoan(LoanDTO loanDTO, User user, BookCopy bookCopy){
        Loan loan = new Loan();
        loan.setId(loanDTO.getId());
        loan.setName(loanDTO.getName());
        loan.setReturn_date(loanDTO.getLoan_date());
        loan.setReturn_date(loanDTO.getReturn_date());
        loan.setFk_user(user);
        loan.setFk_book_copy(bookCopy);
        return loan;
    }
}
