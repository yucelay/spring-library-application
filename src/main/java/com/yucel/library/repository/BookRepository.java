package com.yucel.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yucel.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(value="SELECT * FROM book b WHERE b.book_name LIKE %:keyword% OR b.book_serial LIKE %:keyword% OR b.book_author LIKE %:keyword%  OR b.book_isbn LIKE %:keyword%", nativeQuery=true)
	List<Book> findBooksByKeyword(@Param("keyword") String keyword);
	
	@Query(value="SELECT * FROM book b ORDER BY b.id DESC", nativeQuery=true)
	List<Book> getOrderedBooks();
	
	@Query(value="SELECT * FROM book b ORDER BY b.id DESC LIMIT 7", nativeQuery=true)
	List<Book> getOrderedBooksWithLimit();
}
