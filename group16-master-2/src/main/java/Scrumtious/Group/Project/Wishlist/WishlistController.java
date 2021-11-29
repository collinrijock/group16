package Scrumtious.Group.Project.Wishlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WishlistController {

  private final WishlistRepo WishlistRepo;

  WishlistController(WishlistRepo WishlistRepo) {
    this.WishlistRepo = WishlistRepo;
  }
  
//  @GetMapping("/") //endpoint
//  public String index() {
//	return "Greetings from Spring Boot!";
//  }
	
  @GetMapping("/wishlist/{userID}") //will go to repo and interact with mongodb
  Wishlist getWishlistByUserId(@PathVariable String userID) {  //28-35 gets cart that belongs to user

    System.out.println(userID); 
    
    return WishlistRepo.findByUserID(userID);

  }

  @GetMapping("/wishlist/create/{userID}") //will go to repo and interact with mongodb
  String getAllWishlist(@PathVariable String userID) {
    WishlistRepo.save(new Wishlist(userID));   
    System.out.println(WishlistRepo.findAll());
    return ("Wishlist for user " + userID + " succesfully created!");
  }

  @PostMapping(path = "/wishlist/update/{userID}")
    void modifyBookInCart(@RequestBody String bookID, @RequestBody String book, @PathVariable String userID) {
      Wishlist wishlist = WishlistRepo.findById(userID).orElse(new Wishlist(userID));
      wishlist.wishlistBooks.put(bookID, book);
      System.out.println(wishlist);
      WishlistRepo.save(wishlist);
  }



}
