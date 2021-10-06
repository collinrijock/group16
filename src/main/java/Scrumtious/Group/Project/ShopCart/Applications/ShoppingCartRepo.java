package Scrumtious.Group.Project.ShopCart.Applications;

import java.util.List;
import Scrumtious.Group.Project.ShopCart.Model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepo extends MongoRepository<ShoppingCart, String> {

  public ShoppingCart findByUserID(String userID);

  public List<ShoppingCart> findAll();
 

}
