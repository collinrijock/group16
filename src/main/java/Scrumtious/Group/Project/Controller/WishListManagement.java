package Scrumtious.Group.Project.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import Scrumtious.Group.Project.Model.Wishlist;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class WishListManagement {

	@GetMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/wishlist")
	public Wishlist wishlist(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Wishlist(counter.incrementAndGet(), String.format(template, name));
	}
    

}
