package Scrumtious.Group.Project.BookDetails.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Scrumtious.Group.Project.BookDetails.Author.Author;
import Scrumtious.Group.Project.BookDetails.Author.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    // ==============================================================================
    // Post Requests
    // ==============================================================================
    
    // * Checklist 1 *
    // Create new book
    @PostMapping("/book/create")
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    // * Optional *
    // Add author to book with no authors (empty field)
    @PostMapping("/books/{id}/authors")
    public ResponseEntity<Book> addAuthorsToBook(@PathVariable String id, @RequestBody List<String> authorIds) {
        // find book by id
        Optional<Book> optionalBook = bookRepository.findById(id);
        // if no id exists...
        if (optionalBook.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }// end if
        // get current book found
        Book bookToUpdate = optionalBook.get();
        // get the author inputed
        Set<Author> authorsToAdd = authorIds.stream()
            .map(authorId -> authorRepository.findById(authorId))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toSet());
        // update book
        bookToUpdate.setAuthors(authorsToAdd);
        // save new book
        Book bookUpdated =  bookRepository.save(bookToUpdate);
        // return response
        return new ResponseEntity<>(bookUpdated, HttpStatus.OK);
  }

    // ==============================================================================
    // Get Requests
    // ==============================================================================

    // * Checklist 2 *
    // Retrieve book's details by ISBN
    @GetMapping("/book/isbn/{isbn}")
	public List<Book> getBookByIsbn(@PathVariable(value = "isbn") String isbn) {
	    return bookRepository.findBookByIsbn(isbn);
	}

    // * Checklist 4 *
    // Retrieve list of books using author id
    @GetMapping("/book/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable(value = "author") String author) {
	    return bookRepository.findByAuthorId(author);
	}

    // * Optional *
    // List all books
    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // * Optional *
    // Get book by book id
    @GetMapping("/{id}")
    public Book findOneBook(@PathVariable String id) {
        return bookRepository.findById(id).orElseThrow(() -> new Scrumtious.Group.Project.BookDetails.Exception.BookNotFoundException("id", id.toString()));
    }

    // * Optional *
    // Retrieve author details by book id
    @GetMapping("/{id}/authors")
    public List<Author> findAllAuthorsByBook(@PathVariable String id) {
        return new ArrayList<>(findOneBook(id).getAuthors());
    }

    // ==============================================================================
    // Delete Requests
    // ==============================================================================

    // * Optional *
    // Delete a book using book id
    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable(value = "id") String bookId) {
        // create boolean to check if book exists
        boolean exists = bookRepository.existsById(bookId);
        // if book does not exist, throw exception
        if(!exists) {
            throw new IllegalStateException(
                "book with id " + bookId + " does not exist"
            );
        }
        // if book exists, delete book
	    bookRepository.deleteById(bookId);
    }

}// end class
