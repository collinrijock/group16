package Scrumtious.Group.Project.ShopCart;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepo extends MongoRepository<ShoppingCart, String> {

  public List<ShoppingCart> findByUserID(String userID);

  public List<ShoppingCart> findAll();

  public ShoppingCart findFirstByUserID(String userID); //find first instance of cart by user id

  public boolean existsByUserID(String userID);

}
