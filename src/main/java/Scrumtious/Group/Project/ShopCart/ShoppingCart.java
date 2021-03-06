package Scrumtious.Group.Project.ShopCart;

import java.util.HashSet;
import javax.persistence.ElementCollection;
import org.springframework.data.annotation.Id; //DON'T REMOVE
import org.springframework.data.mongodb.core.mapping.DBRef;

import org.springframework.data.mongodb.core.mapping.*;

import Scrumtious.Group.Project.BookDetails.Book.*;

@Document("shoppingcart")
public class ShoppingCart {

  @Id
  private String shoppingCartID;

  private String userID; 

  @ElementCollection
  @DBRef
  private HashSet<Book> books = new HashSet<>();


  public ShoppingCart() {
    
  }

  public ShoppingCart(String userID, HashSet<Book> books) {
    this.userID = userID;
    this.books = books;
  }

  public String getShoppingCartID(){
    return shoppingCartID;
  }

  public void setShoppingCartID(String shoppingCartID){
    this.shoppingCartID = shoppingCartID;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public HashSet<Book> getBooks(){
    return books;
  }

  public void setBooks(HashSet<Book> books){
    this.books = books;
  }
  




  


  

}