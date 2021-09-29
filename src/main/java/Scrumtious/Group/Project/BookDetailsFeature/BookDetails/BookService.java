package Scrumtious.Group.Project.BookDetailsFeature.BookDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(String bookId) {
        boolean exists = bookRepository.existsById(bookId);

        if(!exists) {
            throw new IllegalStateException(
                "book with id " + bookId + " does not exist"
            );
        }
        bookRepository.deleteById(bookId);
    }
}
