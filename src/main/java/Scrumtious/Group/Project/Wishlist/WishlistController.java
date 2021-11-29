package Scrumtious.Group.Project.Wishlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import Scrumtious.Group.Project.ShopCart.ShoppingCartRepo;
//import Scrumtious.Group.Project.ShopCart.ShoppingCart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.ArrayList;

class CreateWishlistRequest {
  public String userId;
  public String name;
}

class AddBookToWishlistRequest {
  public String userId;
  public String bookId;
  public String name;
}

class moveBookToShoppingCartRequest {
  public String userId;
  public String wishlistName;
  public String bookId;
}

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WishlistController {

  private final WishlistRepo wishlistRepo;
  private final ShoppingCartRepo shoppingCartRepo;

  WishlistController(WishlistRepo wishlistRepo, ShoppingCartRepo shoppingCartRepo) {
    this.wishlistRepo = wishlistRepo;
    this.shoppingCartRepo = shoppingCartRepo;
  }

  @GetMapping("/wishlist/{userId}")
  public List<Wishlist> getAllWishlistsByUserId(@PathVariable String userId) {
    return this.wishlistRepo.findByUserId(userId);
  }

  @PostMapping("/wishlist/create")
  public ResponseEntity<String> createWishlistForUser(@RequestBody CreateWishlistRequest request) {
    String name = request.name;
    String userId = request.userId;
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    if (wishlists.size() == 3) {
      return new ResponseEntity<>("You have reached the maximum number of wishlists", HttpStatus.BAD_REQUEST);
    }
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
  public ResponseEntity<String> addBookToWishlist(@RequestBody AddBookToWishlistRequest request) {
    String userId = request.userId;
    String bookId = request.bookId;
    String name = request.name;

    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(name)) {
        wishlist.addBook(bookId);
        this.wishlistRepo.save(wishlist);
        return ResponseEntity.ok("Book added to wishlist");
      }
    }
    return new ResponseEntity<>("Wishlist with name " + name + " does not exist", HttpStatus.NOT_FOUND);
  }

  @GetMapping(path = "/wishlist/{userId}/{name}/books")
  public ResponseEntity<String> getBooksInWishlist(@PathVariable String userId, @PathVariable String name) {
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(name)) {
        ArrayList<String> books = new ArrayList<>();
        wishlist.getWishlistBooks().forEach(books::add);
        return ResponseEntity.ok(books.toString());
      }
    }
    return new ResponseEntity<>("Wishlist with name " + name + " does not exist", HttpStatus.NOT_FOUND);
  }

 /* @PostMapping(path = "/wishlist/move")
  public ResponseEntity<String> moveBookToShoppingCart(@RequestBody moveBookToShoppingCartRequest request) {
    String userId = request.userId;
    String wishlistName = request.wishlistName;
    String bookId = request.bookId;
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(wishlistName)) {
        wishlist.removeBook(bookId);
        ArrayList<String> bookList = new ArrayList<>();
        bookList.add(bookId);
        ShoppingCart currentCart = shoppingCartRepo.findFirstByUserID(userId);  //cart gets updated by first instance of cart found for this user
        if (currentCart == null) {
          currentCart = new ShoppingCart(userId, bookList);
        } else {
          currentCart.getBookIDS().add(bookId);
        }
        shoppingCartRepo.save(currentCart);
        return ResponseEntity.ok("Book moved to shopping cart");
      }
    }
    return new ResponseEntity<>("Failed to move book to shopping cart.", HttpStatus.NOT_FOUND);
  }
*/
}

