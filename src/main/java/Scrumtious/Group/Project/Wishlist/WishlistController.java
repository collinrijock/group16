package Scrumtious.Group.Project.Wishlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import Scrumtious.Group.Project.ShopCart.ShoppingCartRepo;
import Scrumtious.Group.Project.ShopCart.ShoppingCartController;
import Scrumtious.Group.Project.ShopCart.ShoppingCart;
import Scrumtious.Group.Project.BookDetails.Book.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import Scrumtious.Group.Project.BookDetails.Book.BookRepository;


//import Scrumtious.Group.Project.ShopCart.ShoppingCart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;


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
  private final BookRepository booksRepository;


  WishlistController(WishlistRepo wishlistRepo, BookRepository booksRepository, ShoppingCartRepo shoppingCartRepo) {
    this.wishlistRepo = wishlistRepo;
    this.shoppingCartRepo = shoppingCartRepo;
    this.booksRepository = booksRepository;
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

  public ResponseEntity<String> addBookToShoppingCart(String bookId, String userId) {
    
    ShoppingCart currentCart = shoppingCartRepo.findFirstByUserID(userId);
    System.out.println(currentCart.getUserID());
    System.out.println(currentCart.getShoppingCartID());

    List<Book> allBooks = booksRepository.findAll();

    if(allBooks == null){
      return new ResponseEntity<>("Could not find book repo.", HttpStatus.NOT_FOUND); 
    }

    Set<Book> currentBooksInCart = currentCart.getBooks();
    
    if ((currentBooksInCart != null)) {

      for(Book i : allBooks){ // for each book in repository
        if (i.getBookId().equals(bookId)){ // if repo ISBN = bookISBN
          currentBooksInCart.add(i); 
          System.out.println(currentCart.getShoppingCartID());//add book to cart
          shoppingCartRepo.save(currentCart); 
        }
      }

      for(Book i : currentBooksInCart){ //for all books in cart
        if (!i.getBookId().equals(bookId)){
          return ResponseEntity.ok("Book added to shopping cart");
        }else {
          return ResponseEntity.ok("Book already added to shopping cart");
        }
      } 

    }else{
      System.out.println("New Cart.");
      for(Book i : allBooks){
        if (i.getBookId().equals(bookId)){
          HashSet<Book> newBooks = new HashSet<Book>();
          newBooks.add(i);
          currentCart.setBooks(newBooks);
          shoppingCartRepo.save(currentCart);    
          return ResponseEntity.ok("Book added shopping cart");     
        }
      }
      
  }

    return new ResponseEntity<>("Failed to add book to shopping cart.", HttpStatus.NOT_FOUND);
    
  }

  @PostMapping(path = "/wishlist/move")
  public ResponseEntity<String> moveBookToShoppingCart(@RequestBody moveBookToShoppingCartRequest request) {
    String userId = request.userId;
    String wishlistName = request.wishlistName;
    String bookId = request.bookId;
    List<Wishlist> wishlists = this.wishlistRepo.findByUserId(userId);
    for (Wishlist wishlist : wishlists) {
      if (wishlist.getName().equals(wishlistName)) {
        wishlist.removeBook(bookId);
        addBookToShoppingCart(bookId, userId);
        return new ResponseEntity<String>("Book added to cart.", HttpStatus.ACCEPTED);
      }
    }
    return new ResponseEntity<String>("Failed to move book to shopping cart.", HttpStatus.NOT_FOUND);
  }
}

