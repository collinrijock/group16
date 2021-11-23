package Scrumtious.Group.Project.User;

import java.util.LinkedList;
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
		userRepo.insert(user);
	}
	
	public void checkUserForRequiredFields(User user)
	{
		user.checkRequiredFields();
	}
	
	public void addCardInformation(User user, CardInformation cardInformation)
	{
		user.addUserCardInformation(cardInformation);
		userRepo.save(user);
	}
	
	public void updateAddress(User user, Address address) 
	{
		user.updateUserAddress(address);
		userRepo.save(user);
	}
	
	public void updateName(User user, Name name)
	{
		user.updateUserName(name);
		userRepo.save(user);
	}
	
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}
	
	public List<CardInformation>getPaymentCards(User user)
	{
		if(user.getPaymentCards() == null)
		{
			return new LinkedList<CardInformation>();
		}
		return user.getPaymentCards();
	}
	
	public void deleteUser(String userID) {
        boolean exists = userRepo.existsById(userID);

        if(!exists) {
            throw new IllegalStateException("user with id " + userID + " does not exist");
        }
        userRepo.deleteById(userID);
    }
	
	public void deleteCardInformation(User user, String cardNumber)
	{
		user.deleteUserCardInformation(cardNumber);
		userRepo.save(user);
	}
	
	public User findUserByEmail(String email)
	{
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		
		List<User> userList = mongoTemplate.find(query, User.class);
		
		if(userList.size() > 1)
		{
			throw new IllegalStateException("Error: Too many users with email \"" + email + "\"");
		} 
		else if(userList.size() == 0)
		{
			throw new IllegalStateException("Error: No users found with email \"" + email + "\"");
		}
		
		//If found, only one user with email should be found.
		return userList.get(0);
	}

}