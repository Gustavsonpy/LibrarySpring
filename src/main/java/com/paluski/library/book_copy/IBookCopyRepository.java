package com.paluski.library.book_copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookCopyRepository extends JpaRepository<BookCopy, Long> {
    @Query("SELECT bc FROM BookCopy bc WHERE bc.fk_book.name = ?1")
    Optional<BookCopy> findBookCopyWithName(String name);
}
