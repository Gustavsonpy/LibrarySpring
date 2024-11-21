package com.paluski.library.book_copy;

import com.paluski.library.book.BookDTO;
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
    public ResponseEntity<BookCopyDTO> postBookCopy(@RequestBody BookCopyDTO bookCopyDTO){
        try{
            bookCopyService.createBookCopy(bookCopyDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookCopyDTO);
        }
        return ResponseEntity.ok().body(bookCopyDTO);
    }

    @GetMapping("/v1/getBooksCopies")
    public ResponseEntity<List<BookCopy>> getBookCopies(){
        return ResponseEntity.ok(bookCopyService.getBooksCopies());
    }

    @PutMapping("v1/editBookCopy/{id}")
    public ResponseEntity<BookCopyDTO> putBookCopy(@PathVariable Long id, @RequestBody BookCopyDTO bookCopyDTO){
        try{
            bookCopyService.editBookCopy(id, bookCopyDTO);
            return ResponseEntity.status(HttpStatus.OK).body(bookCopyDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookCopyDTO);
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
