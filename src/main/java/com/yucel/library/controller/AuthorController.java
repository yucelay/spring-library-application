package com.yucel.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yucel.library.model.Author;
import com.yucel.library.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/authorList")
	public String viewHomePage(Model model) {
		model.addAttribute("listAuthors", authorService.getAllAuthors());
		return "author_list";
	}

	@GetMapping("/showNewAuthorForm")
	public String showNewAuthorForm(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "new_author";
	}

	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author author) {
		
		if (author.getAuthorName()=="" || author.getAuthorName()==null) {
			return "redirect:/showNewAuthorForm?error=true";
		}else {
			authorService.saveAuthor(author);
			return "redirect:/authorList";
		}
		
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Author author = authorService.getAuthorById(id);
		model.addAttribute("author", author);
		return "update_author";
	}

	@GetMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable(value = "id"  ) long id) {
		this.authorService.deleteAuthor(id);
		return "redirect:/authorList";
	}

}
