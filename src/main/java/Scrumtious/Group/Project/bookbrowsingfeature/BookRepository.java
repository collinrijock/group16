package Scrumtious.Group.Project.BookBrowsing;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository
        extends MongoRepository<Book, String> {

    List<Book> findByGenre(String genre);

    List<Book> findTop10ByOrderByCopiesSoldDesc();

    List<Book> findAllByRatingEquals(double rating);

    List<Book> findAllByRatingIsGreaterThanEqual(double rating);

}