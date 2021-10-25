package Scrumtious.Group.Project.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Here we include all the services our userController will use.
 */
@Service
public class UserService 
{
	private final UserRepository userRepo;
	private final MongoTemplate mongoTemplate;

	@Autowired
	public UserService(UserRepository userRepo, MongoTemplate mongoTemplate)
	{
		this.userRepo = userRepo;
		this.mongoTemplate = mongoTemplate;
	}

	public void addNewUser(User user)
	{
		userRepo.save(user);
	}
	
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	
	public void deleteUser(String userID) {
        boolean exists = userRepo.existsById(userID);

        if(!exists) {
            throw new IllegalStateException(
                "user with id " + userID + " does not exist"
            );
        }
        userRepo.deleteById(userID);
    }
	
	public User findUserByEmail(String email)
	{
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		
		List<User> userList = mongoTemplate.find(query, User.class);
		
		if(userList.size() > 1)
		{
			throw new IllegalStateException("Too many users with email \"" + email + "\"");
		} 
		else if(userList.size() == 0)
		{
			throw new IllegalStateException("No users found with email \"" + email + "\"");
		}
		
		//If found, only one user with email should be found.
		return userList.get(0);
	}

}
