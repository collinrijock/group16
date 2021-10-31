package Scrumtious.Group.Project.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Can be thought of a central hub in terms of what actions are to be taken based specified request and upon arguments being sent or received
 */

@RestController
@RequestMapping(path = "api/user")
public class UserController 
{
	private final UserService userService;

	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping("/")
	public String index() 
	{
		return "Greetings from Spring Boot! test:";
	}

	@PostMapping("/create/{user}")
	public String createUser(@RequestBody User user)
	{
		try 
		{
			user.checkifCardsAreInstatiation();
			userService.addNewUser(user);
			return "User created successfully";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	@PutMapping("/addCard/{email}")
	public String addCardInfo(@RequestBody CardInformation cardInformation, @PathVariable String email)
	{

		try {
			User user = userService.findUserByEmail(email);
			userService.addCardInformation(user, cardInformation);			
			return "Card was added successfully.";
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}

	@GetMapping("/currentUsers/")
	public List<User> getUsers() 
	{
		return userService.getUsers();
	}

	@DeleteMapping("deleteUserByID/{userID}")
	public String deleteUserByID(@PathVariable("userID") String userID) 
	{
		try
		{
			userService.deleteUser(userID);
			return "User deleted successfully.";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	@DeleteMapping("deleteUserByEmail/{email}")
	public String deleteUserByEmail(@PathVariable String email) 
	{
		try
		{
			User user = userService.findUserByEmail(email);
			userService.deleteUser(user.getId());
			return "User deleted successfully.";
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}

	@GetMapping("/searchByEmail/{email}")
	public Object getUserByEmail(@PathVariable("email") String email) 
	{
		StringBuilder s = new StringBuilder();
		try {
			return userService.findUserByEmail(email);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			s.append(e.getMessage());
		}

		return s;

	}
}
