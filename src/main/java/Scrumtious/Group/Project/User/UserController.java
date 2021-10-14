package Scrumtious.Group.Project.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**
import org.springframework.web.bind.annotation.PutMapping;  //best for cart
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

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

	@GetMapping("/") //endpoint
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
	

}
