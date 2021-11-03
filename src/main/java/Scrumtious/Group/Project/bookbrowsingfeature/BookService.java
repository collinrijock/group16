package Scrumtious.Group.Project.BookBrowsing;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        System.out.println(book);
        bookRepository.save(book);
    }

    public List<Book> getByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getTopTen(){
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getByRating(double rating) {
        return bookRepository.findAllByRatingEquals(rating);
    }

    public List<Book> getBySpecificRating(double rating) {
        return bookRepository.findAllByRatingIsGreaterThanEqual(rating);
    }

}
