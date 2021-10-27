package Scrumtious.Group.Project.BookDetailsFeature.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends MongoRepository<Book, String> {

   List<Book> findBookByIsbn(String isbn);

   List<Book> findBookByAuthor(String author);
}