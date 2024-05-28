package com.spring.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Author;
import com.spring.model.Book;
import com.spring.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	@Autowired
	Book book;

	@RequestMapping(value = "/detailsform", method = RequestMethod.GET)
	public String details(Model model) {
		System.out.println("details page requested");
		return "details";
	}

	@RequestMapping(value = "/insertAuthor", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	 public String createAuthor(@RequestBody Author authorDto) {
        System.out.println("insert page requested");
        Author author = new Author();
        author.setName(authorDto.getName());

        Set<Book> books = new HashSet<>();
        for (Book bookDto : authorDto.getBooks()) {
            Book book = new Book();
            book.setTitle(bookDto.getTitle());
            System.out.println(book.getTitle());
            book.setAuthor(author);
            books.add(book);
        }
        author.setBooks(books);

        authorService.saveAuthor(author);
        System.out.println("Data inserted Successfully");
        return "<h1>Successful</h1>";
    }

//	 @RequestMapping(value = "/getAuthorById", method = RequestMethod.GET)
//	 public Optional<Author> getAuthor(Author author, Model model) {
//	 Long i = 1l;
//	 return authorService.findAuthorById(i);
//	 }

	@RequestMapping(value = "/getAllusers", method = RequestMethod.GET)
	public String getData(Model model) {
		System.out.println("get controller");
		List<Author> p = authorService.getAllAuthors();

		model.addAttribute("allusers",p);
		return "AllAuthors";
	}

}