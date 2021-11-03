package Scrumtious.Group.Project.BookBrowsing;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// this class serves as the api request
// for clients to make http requests

@RestController
@RequestMapping(path = "api/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/genre/{genre}")
    public List<Book> fetchGenre(@PathVariable String genre) {
        return bookService.getByGenre(genre);
    }

    @GetMapping("/topTen")
    public List<Book> getTop(){
        return bookService.getTopTen();
    }

    @GetMapping("/rating")
    public List<Book> getRating(@PathVariable double rating) {
        return bookService.getByRating(rating);
    }

    @GetMapping("/rating/{rating}")
    public List<Book> getSpecificRating(@PathVariable double rating) {
        return bookService.getBySpecificRating(rating);
    }


}
