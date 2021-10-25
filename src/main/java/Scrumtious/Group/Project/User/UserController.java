package Scrumtious.Group.Project.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void createUser(@RequestBody User user)
	{
		userService.addNewUser(user);
		System.out.println(user);
	}

	@GetMapping("/currentUsers/")
	public List<User> getBooks() {
		return userService.getUsers();
	}

	@DeleteMapping("deleteUser/{userID}")
	public void deleteBook(@PathVariable("userID") String userID) {
		userService.deleteUser(userID);
	}

	@GetMapping("/searchByEmail/{email}")
	public Object getUserByEmail(@PathVariable("email") String email) 
	{
		StringBuilder s = new StringBuilder("Error: ");
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
