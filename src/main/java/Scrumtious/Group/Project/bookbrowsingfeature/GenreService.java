package Scrumtious.Group.Project.bookbrowsingfeature;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    
    private final GenreRepository booksRepository;

    @Autowired
    public GenreService(GenreRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // find all the books in the repository
    public List<Genre> getBooks() {
        return booksRepository.findAll();
    }

    // POST to add books into the database
    public void addNewBooks(Genre books) {
        System.out.println(books);
        booksRepository.save(books);
    }

    // method to get find books by genre 
    public List<Genre> getBooksByGenre(String genre) {
        return booksRepository.findByGenre(genre);
    }


}

