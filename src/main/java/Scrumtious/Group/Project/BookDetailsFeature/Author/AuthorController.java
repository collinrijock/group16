package Scrumtious.Group.Project.BookDetailsFeature.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api")

public class AuthorController {
    
    @Autowired
    AuthorRepository authorRepository;

    // Create new author
    @PostMapping("/author/create")
	public Author createBook(@Validated @RequestBody Author author) {
	    return authorRepository.save(author);
	}

}// end class

