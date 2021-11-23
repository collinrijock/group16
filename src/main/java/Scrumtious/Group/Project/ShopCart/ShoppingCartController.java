package Scrumtious.Group.Project.ShopCart;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**
import org.springframework.web.bind.annotation.PutMapping;  //best for cart
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Scrumtious.Group.Project.BookDetails.Book.BookRepository;
import Scrumtious.Group.Project.BookDetails.Book.Book;
import Scrumtious.Group.Project.BookDetails.Book.BookController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class removeBookFromCartRequest {
  public String userID;
  public String bookISBN;
}


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

  private final ShoppingCartRepo shoppingcartRepo;
  private final BookRepository booksRepository;

  ShoppingCartController(ShoppingCartRepo shoppingcartRepo, BookRepository booksRepository) {
    this.shoppingcartRepo = shoppingcartRepo;
    this.booksRepository = booksRepository;
  }
  
	
  @GetMapping("/shoppingcart/{userID}") //will go to repo and interact with mongodb
  ShoppingCart getShoppingCartByUserId(@PathVariable String userID) {  //28-35 gets cart that belongs to user

    System.out.println(userID); 
    
    return shoppingcartRepo.findFirstByUserID(userID);

  }


  @GetMapping("/shoppingcart/create/{userID}") //creates new cart
  void createShoppingCart(@PathVariable String userID) {
    if (!shoppingcartRepo.existsByUserID(userID)){
      shoppingcartRepo.save(new ShoppingCart(userID, new HashSet<Book>()));
    }    // if a shopping cart doesnt exist create it, else dont do anything
       
    System.out.println(shoppingcartRepo.findAll());

  }



  @PostMapping(path = "/shoppingcart/remove")
  public ResponseEntity<String> removeBookFromShoppingCart(@RequestBody removeBookFromCartRequest request){
    String bookISBN = request.bookISBN;
    String userID = request.userID;
    
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userID);

    List<Book> bookToRemove = booksRepository.findBookByIsbn(bookISBN);
    
    
    if (shoppingcartRepo.existsByUserID(userID) && currentCart.getBooks().containsAll(bookToRemove)) {
      currentCart.getBooks().removeAll(bookToRemove);
      shoppingcartRepo.save(currentCart);
      return ResponseEntity.ok("Book removed from shopping cart");
    } else {
      return ResponseEntity.ok("Book already removed from shopping cart");
    }
    
  }

  @PostMapping(path = "/shoppingcart/update")
  public ResponseEntity<String> addBookToShoppingCart(@RequestBody removeBookFromCartRequest request){
    String bookISBN = request.bookISBN;
    String userID = request.userID;
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userID);


    if(currentCart == null){
      return new ResponseEntity<>("Invalid cart for user.", HttpStatus.NOT_FOUND); 
    }

    List<Book> allBooks = booksRepository.findAll();

    if(allBooks == null){
      return new ResponseEntity<>("Could not find book repo.", HttpStatus.NOT_FOUND); 
    }

    Set<Book> currentBooksInCart = currentCart.getBooks();
    
    if ((currentBooksInCart != null) && (currentBooksInCart.size()>0)){
      for(Book i : allBooks){ // for each book in repository
        if (i.getisbn().equals(bookISBN)){ // if repo ISBN = bookISBN
          currentBooksInCart.add(i); //add book to cart
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
