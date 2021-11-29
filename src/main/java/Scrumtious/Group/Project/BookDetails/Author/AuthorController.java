package Scrumtious.Group.Project.BookDetails.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Scrumtious.Group.Project.BookDetails.Book.BookRepository;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api")

public class AuthorController {
    
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    // ==============================================================================
    // Post Requests
    // ==============================================================================

    // * Checklist 3 *
    // Create new author
    @PostMapping("/author/create")
	public Author createBook(@Valid @RequestBody Author author) {
	    return authorRepository.save(author);
	}

    // ==============================================================================
    // Get Requests
    // ==============================================================================

    // * Optional *
    // Get all authors
    @GetMapping("/author/get")
    public List<Author> getBooks() {
        return authorRepository.findAll();
    }
    
}// end class

