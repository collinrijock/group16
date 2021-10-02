package Scrumtious.Group.Project.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**
import org.springframework.web.bind.annotation.PutMapping;  //best for cart
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import Scrumtious.Group.Project.Applications.*;
import Scrumtious.Group.Project.Model.*;
import java.util.ArrayList;



@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WishlistController {

  private final WishlistRepo WishlistRepo;

  WishlistController(WishlistRepo WishlistRepo) {
    this.WishlistRepo = WishlistRepo;
  }
  
  @GetMapping("/") //endpoint
  public String index() {
	return "Greetings from Spring Boot!";
  }
	
  @GetMapping("/Wishlist/{userID}") //will go to repo and interact with mongodb
  Wishlist getWishlistByUserId(@PathVariable String userID) {  //28-35 gets cart that belongs to user

    System.out.println(userID); 
    
    return WishlistRepo.findByUserID(userID);

  }

  @GetMapping("/Wishlist/create/{userID}") //will go to repo and interact with mongodb
  void getAllWishlist(@PathVariable String userID) {
    WishlistRepo.save(new Wishlist(userID, new ArrayList<String>()));   
    System.out.println(WishlistRepo.findAll());

  }

  @PostMapping(path = "/Wishlist/update/{cartID}")
  public void modifyBookInCart(@RequestBody Wishlist cart, @PathVariable String cartID) {

    Wishlist currentCart = WishlistRepo.findById(cartID).orElse(new Wishlist());
    currentCart.bookIDS = cart.bookIDS;
    WishlistRepo.save(currentCart);

      //code
  }



}
