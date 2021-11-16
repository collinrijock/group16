package Scrumtious.Group.Project.BookDetailsFeature.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // Get all books
    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // Create new book
    @PostMapping("/book/create")
	public Book createBook(@Validated @RequestBody Book book) {
	    return bookRepository.save(book);
	}

    // Delete book by id
    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable(value = "id") String bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException(
                "book with id " + bookId + " does not exist"
            );
        }
	    bookRepository.deleteById(bookId);
    }

    // Get book by isbn
    @GetMapping("/book/isbn/{isbn}")
	public List<Book> getBookByIsbn(@PathVariable(value = "isbn") String isbn) {
	    return bookRepository.findBookByIsbn(isbn);
	}

    // Get book by author
    @GetMapping("/book/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable(value = "author") String author) {
	    return bookRepository.findBookByAuthor(author);
	}

}// end class
