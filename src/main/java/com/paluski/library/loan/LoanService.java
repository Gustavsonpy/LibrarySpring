package com.paluski.library.loan;

import com.paluski.library.book_copy.BookCopy;
import com.paluski.library.book_copy.BookCopyDTO;
import com.paluski.library.book_copy.BookCopyMapper;
import com.paluski.library.book_copy.IBookCopyRepository;
import com.paluski.library.user.User;
import com.paluski.library.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    ILoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IBookCopyRepository bookCopyRepository;

    public void createLoan(LoanDTO loanDTO){

        User existUser = userRepository.findById(loanDTO.getFk_user())
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));

        BookCopy existBookCopy = bookCopyRepository.findById(loanDTO.getFk_book_copy())
                .orElseThrow(() -> new EntityNotFoundException("Book Copy not found!"));

        loanRepository.save(LoanMapper.toNormalLoan(loanDTO, existUser, existBookCopy));
    }

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    public void editLoan(Long id, LoanDTO loanDTO){
        LoanDTO existLoan = LoanMapper.toDTO(loanRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan not found!")));
        User existUser = userRepository.findById(existLoan.getFk_user()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        BookCopy existBookCopy = bookCopyRepository.findById(existLoan.getFk_book_copy()).orElseThrow(() -> new EntityNotFoundException("User not found!"));

        existLoan.setLoan_date(loanDTO.getLoan_date());
        existLoan.setReturn_date(loanDTO.getReturn_date());
        existLoan.setFk_book_copy(loanDTO.getFk_book_copy());
        existLoan.setFk_user(loanDTO.getFk_user());
        loanRepository.save(LoanMapper.toNormalLoan(existLoan, existUser, existBookCopy));
    }

    public void deleteLoan(Long id){
        LoanDTO existLoan = LoanMapper.toDTO(loanRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Loan not found!")));
        User existUser = userRepository.findById(existLoan.getFk_user()).orElseThrow(() -> new EntityNotFoundException("User not found!"));
        BookCopy existBookCopy = bookCopyRepository.findById(existLoan.getFk_book_copy()).orElseThrow(() -> new EntityNotFoundException("User not found!"));

        loanRepository.delete(LoanMapper.toNormalLoan(existLoan, existUser, existBookCopy));
    }

}
