package Scrumtious.Group.Project.BrowsingSorting;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    BooksService booksService;

    // Get book by genre
    @GetMapping("/book/genre/{genre}")
    public List<Books> getBookByGenre(@PathVariable(value = "genre") String genre) {
        return booksRepository.findByGenre(genre);
    }

    // Get book by copies sold
    @GetMapping("/book/topTen")
    public List<Books> getBasedOnCopiesSold() {
        return booksRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    // Get book by rating
    @GetMapping("/book/rating/{rating}")
    public List<Books> getBasedOnRating(@PathVariable(value = "rating") double rating) {
        return booksRepository.findAllByRatingIsGreaterThanEqual(rating);
    }

    // Get list of N books
    @GetMapping("/book/page")
    public Page<Books> getPages(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return booksService.getPages(pageNumber, pageSize);
    }


}
