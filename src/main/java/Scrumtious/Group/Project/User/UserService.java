package Scrumtious.Group.Project.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Here we include all the services our userController will use.
 */
@Service
public class UserService 
{
	private final UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo)
	{
		this.userRepo = userRepo;
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
                "book with id " + userID + " does not exist"
            );
        }
        userRepo.deleteById(userID);
    }

}
