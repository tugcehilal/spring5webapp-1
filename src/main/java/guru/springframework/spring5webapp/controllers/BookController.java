package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.respositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public String getBooks( Model model){ //this is what is going to get returned to the view. so th view is gonna get a copy of the model.
        model.addAttribute("books", bookRepository.findAll());
        //bunun view layerde books adlı attribute u olacak. list of  books la
        //and we ll be able to utilize that value inside of our view layer to apply the necessary view
        return "books/list"; //view name //list template inside th directory book
    }
}
