package Scrumtious.Group.Project.ShopCart;

import java.util.ArrayList;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document("shoppingcart")
public class ShoppingCart {

  @Id
  public String id;

  public String userID;
  public ArrayList<String> bookIDS; 

  public ShoppingCart() {}

  public ShoppingCart(String userID, ArrayList<String> bookIDS) {
    this.userID = userID;
    this.bookIDS = bookIDS;
  }

  

}