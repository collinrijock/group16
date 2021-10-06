package Scrumtious.Group.Project.bookbrowsingfeature;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class GenreController {

    private final GenreService booksService;

    @Autowired
    public GenreController(GenreService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/genre/{genre}")
    public List<Genre> getGenre(@PathVariable String genre) {
        return booksService.getBooksByGenre(genre);
    }

    
    
}
