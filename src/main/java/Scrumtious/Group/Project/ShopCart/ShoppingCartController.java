package Scrumtious.Group.Project.ShopCart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; //for cart**
import org.springframework.web.bind.annotation.PutMapping;  //best for cart
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

class removeBookFromCartRequest {
  public String userId;
  public String bookId;
}


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

  private final ShoppingCartRepo shoppingcartRepo;

  ShoppingCartController(ShoppingCartRepo shoppingcartRepo) {
    this.shoppingcartRepo = shoppingcartRepo;
  }
  
	
  @GetMapping("/shoppingcart/{userID}") //will go to repo and interact with mongodb
  ShoppingCart getShoppingCartByUserId(@PathVariable String userID) {  //28-35 gets cart that belongs to user


    System.out.println(userID); 
    
    return shoppingcartRepo.findFirstByUserID(userID);

  }

  @GetMapping("/shoppingcart/create/{userID}") //creates new cart
  void getAllShoppingCart(@PathVariable String userID) {
    if (!shoppingcartRepo.existsByUserID(userID)){
      shoppingcartRepo.save(new ShoppingCart(userID, new ArrayList<String>()));
    }    // if a shopping cart doesnt exist create it, else dont do anything
       
    System.out.println(shoppingcartRepo.findAll());

  }


  @PostMapping(path = "/shoppingcart/update/{cartID}")
  public void modifyBookInCart(@RequestBody ShoppingCart cart, @PathVariable String cartID) {

    ShoppingCart currentCart = shoppingcartRepo.findById(cartID).orElse(new ShoppingCart());
    currentCart.bookIDS = cart.bookIDS;
    shoppingcartRepo.save(currentCart);


  }

  @PostMapping(path = "/shoppingcart/edit/{userID}")
  public void editBookInCart(@RequestBody ShoppingCart cart, @PathVariable String userID) {
    if (!shoppingcartRepo.existsByUserID(userID)){
      shoppingcartRepo.save(new ShoppingCart(userID, new ArrayList<String>()));
    }  //if a shopping cart does not exist for the user then itll create one, otherwise VVV find the first cart by user
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userID);
    currentCart.bookIDS = cart.bookIDS;
    shoppingcartRepo.save(currentCart);

  }

  @PostMapping(path = "/shoppingcart/remove")
  public ResponseEntity<String> removeBookFromShoppingCart(@RequestBody removeBookFromCartRequest request){
    String bookId = request.bookId;
    String userId = request.userId;
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userId);
    
    if (currentCart.bookIDS.contains(bookId)) {
      currentCart.bookIDS.remove(bookId);
      shoppingcartRepo.save(currentCart);
      return ResponseEntity.ok("Book removed from shopping cart");
    } else {
      return ResponseEntity.ok("Book already removed from shopping cart");
    }
    
  }

  @PostMapping(path = "/shoppingcart/update")
  public ResponseEntity<String> addBookToShoppingCart(@RequestBody removeBookFromCartRequest request){
    String bookId = request.bookId;
    String userId = request.userId;
    ShoppingCart currentCart = shoppingcartRepo.findFirstByUserID(userId);
    
    if (!currentCart.bookIDS.contains(bookId)) {
      currentCart.bookIDS.add(bookId);
      shoppingcartRepo.save(currentCart);
      return ResponseEntity.ok("Book added to shopping cart");
    } else {
      return ResponseEntity.ok("Book already added to shopping cart");
    }  
    
  }

  @GetMapping("/shoppingcart/retrieve/{userID}") 
  ArrayList<String> getBooksInCartByUserId(@PathVariable String userID) {  


    System.out.println(userID); 
    
    return shoppingcartRepo.findFirstByUserID(userID).bookIDS;

  }



}
