package Scrumtious.Group.Project.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is how we connect to our db
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
