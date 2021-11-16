package Scrumtious.Group.Project.BrowsingSorting;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BooksRepository
        extends MongoRepository<Books, String> {

    // find books by genre
    List<Books> findByGenre(String genre);

    // find books by copies sold
    List<Books> findTop10ByOrderByCopiesSoldDesc();

    // find books based on rating
    List<Books> findAllByRatingIsGreaterThanEqual(double rating);

}
