package com.paluski.library.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/v1/newBook")
    public ResponseEntity<String> postBook(@RequestBody BookDTO bookDTO){
        try{
            bookService.createBook(bookDTO);
            return ResponseEntity.ok("Book created Successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: "+e.getMessage());
        }
    }

    @GetMapping("/v1/getBooks")
    public ResponseEntity<List<BookDTO>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PutMapping("/v1/editBook/{id}")
    public ResponseEntity<String> putBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        try{
            bookService.editBook(id, bookDTO);
            return ResponseEntity.ok("Book edited successfully!");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: "+e.getMessage());
        }
    }

    @DeleteMapping("/v1/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        try{
            bookService.deleteBook(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.ok("Book deleted Successfully!");
    }

}
