package Scrumtious.Group.Project.User;

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
	
	
}
