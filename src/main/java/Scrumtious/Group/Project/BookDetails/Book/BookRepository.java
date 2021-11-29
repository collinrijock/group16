package Scrumtious.Group.Project.BookDetails.Book;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    // find books by isbn
    List<Book> findBookByIsbn(String isbn);

    // find books by author 
    List<Book> findByAuthorId(String id);

    // find books by genre 
    List<Book> findByGenre(String genre);

    // find books by top sellers 
    List<Book> findTop10ByOrderByCopiesSoldDesc();

    // find books by rating 
    List<Book> findAllByRatingIsGreaterThanEqual(double rating);

}