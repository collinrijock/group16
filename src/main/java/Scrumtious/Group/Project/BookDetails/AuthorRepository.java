package Scrumtious.Group.Project.BookDetails;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {

    List<Author> findByAuthorId(List<String> id);

}
