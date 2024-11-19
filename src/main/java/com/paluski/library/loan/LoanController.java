package com.paluski.library.loan;

import com.paluski.library.loan.Loan;
import com.paluski.library.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping("/v1/newLoan")
    public ResponseEntity<LoanDTO> postLoan(@RequestBody LoanDTO loanDTO){
        try{
            return ResponseEntity.ok(loanService.createLoan(loanDTO));
        }catch (Exception e){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/v1/getLoans")
    public ResponseEntity<List<Loan>> getLoans(){
        return ResponseEntity.ok(loanService.getLoans());
    }

    @PutMapping("/v1/editLoan/{id}")
    public ResponseEntity<LoanDTO> editLoan(@PathVariable Long id, @RequestBody LoanDTO loanDTO){
        try{
            loanService.editLoan(id, loanDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(loanDTO);
    }

    @DeleteMapping("/v1/deleteLoan/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id){
        try{
            loanService.deleteLoan(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: "+e.getMessage());
        }
        return ResponseEntity.ok("Loan deleted successfully!");
    }

}