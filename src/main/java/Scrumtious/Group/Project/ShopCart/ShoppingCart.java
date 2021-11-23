package Scrumtious.Group.Project.ShopCart;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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