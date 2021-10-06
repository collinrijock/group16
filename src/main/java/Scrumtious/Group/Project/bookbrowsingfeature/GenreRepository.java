package Scrumtious.Group.Project.bookbrowsingfeature;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, Integer>{
    
    // Retrieve a list of books by genre
    List<Genre> findByGenre(String genre);

}
