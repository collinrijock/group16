package Scrumtious.Group.Project;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepo extends MongoRepository<ShoppingCart, String> {

  public ShoppingCart findByUserID(String userID);

  public List<ShoppingCart> findAll();
 

}
