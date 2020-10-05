package com.yucel.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yucel.library.model.Book;
import com.yucel.library.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		if (bookService.getAllBooks().size()>0) {
			model.addAttribute("totalBook",bookService.getAllBooks().size());
		}else {
			model.addAttribute("totalBook","0");
		}
		
		if (bookService.getAllAuthorForBooks().size()>0) {
			model.addAttribute("totalAuthor",bookService.getAllAuthorForBooks().size());
		}else {
			model.addAttribute("totalAuthor","0");
		}
		
		if (bookService.getAllPublisherForBooks().size()>0) {
			model.addAttribute("totalPublisher",bookService.getAllPublisherForBooks().size());
		}else {
			model.addAttribute("totalPublisher","0");
		}
				
		
		model.addAttribute("booksForMainPage",bookService.getAllOrderedBooksWithLimit());
		
		return "index";
	}
	

	@GetMapping("/bookList")
	public String bookList(Model model) {		
		model.addAttribute("listBook", bookService.getAllOrderedBooks());
		return "book_list";
	}

	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("authors", bookService.getAllAuthorForBooks());
		model.addAttribute("publishers", bookService.getAllPublisherForBooks());
		return "new_book";
	}

	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		if (book.getBookName() == "" || book.getBookName() == null || book.getBookAuthor() == ""
				|| book.getBookAuthor() == null || book.getBookIsbn() == "" || book.getBookIsbn() == null) {
			return "redirect:/showNewBookForm?error=true";
		} else {
			bookService.saveBook(book);
			return "redirect:/bookList";
		}

	}

	@GetMapping("/showBookFormForUpdate/{id}")
	public String showBookFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		model.addAttribute("authors", bookService.getAllAuthorForBooks());
		model.addAttribute("publishers", bookService.getAllPublisherForBooks());
		return "update_book";
	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable(value = "id") long id) {
		this.bookService.deleteBook(id);
		return "redirect:/bookList";
	}

	@PostMapping("/showSearchResult")
	public String showSearchResult(@ModelAttribute("searchWord") String searchWord, Model model) {
		List<Book> foundedBooks = bookService.getSearchBooks(searchWord);
		model.addAttribute("foundedBooks", foundedBooks);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("foundedBooksSize", foundedBooks.size());
		return "search_result";
	}

}
