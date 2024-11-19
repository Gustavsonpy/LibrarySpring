package com.paluski.library.book_copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookCopy")
public class BookCopyController {

    @Autowired
    BookCopyService bookCopyService;

    @PostMapping("/v1/newBookCopy")
    public ResponseEntity<String> postBookCopy(@RequestBody BookCopyDTO bookCopyDTO){
        try{
            bookCopyService.createBookCopy(bookCopyDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+e.getMessage());
        }
        return ResponseEntity.ok().body("Book copy created successfully!");
    }

    @GetMapping("/v1/getBooksCopies")
    public ResponseEntity<List<BookCopy>> getBookCopies(){
        return ResponseEntity.ok(bookCopyService.getBooksCopies());
    }

    @PutMapping("v1/editBookCopy/{id}")
    public ResponseEntity<String> putBookCopy(@PathVariable Long id, @RequestBody BookCopyDTO bookCopyDTO){
        try{
            bookCopyService.editBookCopy(id, bookCopyDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Book copy "+id+" edited successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error to edit Book Copy: "+e.getMessage());
        }
    }

    @DeleteMapping("/v1/deleteBookCopy/{id}")
    public ResponseEntity<String> deleteBookCopy(@PathVariable Long id){
        try{
            bookCopyService.deleteBookCopy(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book Copy deleted successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error to delete: "+e.getMessage());
        }
    }

}
