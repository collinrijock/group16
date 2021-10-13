package Scrumtious.Group.Project.Wishlist.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import Scrumtious.Group.Project.Wishlist.Applications.*;
import Scrumtious.Group.Project.Wishlist.Model.*;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WishlistController {

  private final WishlistRepo wishlistRepo;

  WishlistController(WishlistRepo wishlistRepo) {
    this.wishlistRepo = wishlistRepo;
  }

  @GetMapping("/wishlist/{userId}")
  public List<Wishlist> getAllWishlistsByUserId(@PathVariable String userId) {

    System.out.println(userId);

    return this.wishlistRepo.findByUserId(userId);
  }

  @PostMapping("/wishlist/create")
  public ResponseEntity<String> createWishlistForUser(@RequestBody String userId, @RequestBody String name) {
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(name)) {
        return new ResponseEntity<>("Wishlist already exists", HttpStatus.CONFLICT);
      }
    }
    Wishlist newWishlist = new Wishlist(userId, name);
    this.wishlistRepo.save(newWishlist);
    return ResponseEntity.ok("Wishlist for user " + userId + " succesfully created!");
  }

  @PostMapping(path = "/wishlist/add")
  public ResponseEntity<String> addBookToWishlist(@RequestBody String userId, @RequestBody String bookId,
      @RequestBody String name) {
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    Wishlist targetWishlist = null;
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(name)) {
        targetWishlist = wishlist;
      }
    }
    if (targetWishlist == null) {
      return new ResponseEntity<>("Wishlist with name " + name + " does not exist", HttpStatus.NOT_FOUND);
    } else {
      targetWishlist.addBook(bookId);
      this.wishlistRepo.save(targetWishlist);
      return ResponseEntity.ok("Book added to wishlist");
    }
  }

}
