package Scrumtious.Group.Project.ShopCart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Scrumtious.Group.Project.BookDetails.Book.BookRepository;
import Scrumtious.Group.Project.User.User;
import Scrumtious.Group.Project.User.UserRepository;
import Scrumtious.Group.Project.User.UserService;
import Scrumtious.Group.Project.BookDetails.Book.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class cartRequest {
  public String userID;
  public String bookISBN;
}


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

  private final ShoppingCartRepo shoppingcartRepo;
  private final BookRepository booksRepository;
  private final UserRepository userRepo;
  private final UserService userService;

  ShoppingCartController(ShoppingCartRepo shoppingcartRepo, BookRepository booksRepository, UserRepository userRepo, UserService userService) {
    this.shoppingcartRepo = shoppingcartRepo;
    this.booksRepository = booksRepository;
    this.userRepo = userRepo;
    this.userService = userService;
  }
  
	
  @GetMapping("/shoppingcart/{userID}") //will go to repo and interact with mongodb
  ShoppingCart getShoppingCartByUserId(@PathVariable String userID) {  //28-35 gets cart that belongs to user

    System.out.println(userID); 
    
    return shoppingcartRepo.findFirstByUserID(userID);

  }


  @GetMapping("/shoppingcart/create") //creates new cart
  public ResponseEntity<String> createShoppingCart(@RequestBody cartRequest request) {
    String userID = request.userID;

    try{
      User currentUser = userService.findUserByEmail(userID);
      if(currentUser == null){
        throw new IllegalStateException(
                "User with id " + userID + " does not exist."
            );
      }else if (!shoppingcartRepo.existsByUserID(userID)){
        shoppingcartRepo.save(new ShoppingCart(userID, new HashSet<Book>()));
        return ResponseEntity.ok("Shopping cart created for user.");
      }    // if a shopping cart doesnt exist create it, else dont do anything
    }catch(IllegalStateException exception){
      return ResponseEntity.ok(exception.getMessage());
    }
    

    System.out.println(shoppingcartRepo.findAll());
    return new ResponseEntity<>("Failed to create cart because cart already exists or else.", HttpStatus.NOT_FOUND);  

  }



  @PostMapping(path = "/shoppingcart/remove")
  public ResponseEntity<String> removeBookFromShoppingCart(@RequestBody cartRequest request){
    String bookISBN = request.bookISBN;
    String userID = request.userID;
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userID);
    System.out.println(currentCart.getUserID());
    System.out.println(currentCart.getShoppingCartID());

    List<Book> allBooks = booksRepository.findAll();

    if(allBooks == null){
      return new ResponseEntity<>("Could not find book repo.", HttpStatus.NOT_FOUND); 
    }

    Set<Book> currentBooksInCart = currentCart.getBooks();
    
    if ((currentBooksInCart != null)){

      for(Book i : currentBooksInCart){ //for all books in cart
          if (i.getisbn().equals(bookISBN)){ // if repo ISBN = bookISBN
            currentBooksInCart.remove(i); 
            System.out.println(currentCart.getShoppingCartID());//add book to cart
            shoppingcartRepo.save(currentCart);
          return ResponseEntity.ok("Book removed from shopping cart");
        }else {
          return ResponseEntity.ok("Book already removed from shopping cart");
        }
      }
     }else{
    
          return ResponseEntity.ok("Empty cart.");     
    }
      

    return new ResponseEntity<>("Failed to remove book from shopping cart.", HttpStatus.NOT_FOUND);
    
  }

  @PostMapping(path = "/shoppingcart/update")
  public ResponseEntity<String> addBookToShoppingCart(@RequestBody cartRequest request){
    String bookISBN = request.bookISBN;
    String userID = request.userID;
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userID);
    System.out.println(currentCart.getUserID());
    System.out.println(currentCart.getShoppingCartID());

    List<Book> allBooks = booksRepository.findAll();

    if(allBooks == null){
      return new ResponseEntity<>("Could not find book repo.", HttpStatus.NOT_FOUND); 
    }

    Set<Book> currentBooksInCart = currentCart.getBooks();
    
    if ((currentBooksInCart != null)){
      System.out.println("Cart exists");
      for(Book i : allBooks){ // for each book in repository
        if (i.getisbn().equals(bookISBN)){ // if repo ISBN = bookISBN
          currentBooksInCart.add(i); 
          System.out.println(currentCart.getShoppingCartID());//add book to cart
          shoppingcartRepo.save(currentCart); 
        }
      }

      for(Book i : currentBooksInCart){ //for all books in cart
        if (!i.getisbn().equals(bookISBN)){
          return ResponseEntity.ok("Book added to shopping cart");
        }else {
          return ResponseEntity.ok("Book already added to shopping cart");
        }
      } 

    }else{
      System.out.println("New Cart.");
      for(Book i : allBooks){
        if (i.getisbn().equals(bookISBN)){
          HashSet<Book> newBooks = new HashSet<Book>();
          newBooks.add(i);
          currentCart.setBooks(newBooks);
          shoppingcartRepo.save(currentCart);    
          return ResponseEntity.ok("1st Book added shopping cart");     
        }
      }
      
  }

    return new ResponseEntity<>("Failed to add book to shopping cart.", HttpStatus.NOT_FOUND);
    
  }

  @GetMapping("/shoppingcart/retrieve/{userID}") 
  Set<Book> getBooksInCartByUserId(@PathVariable String userID) {  


    System.out.println(userID); 
    
    return shoppingcartRepo.findFirstByUserID(userID).getBooks();

  }



}
