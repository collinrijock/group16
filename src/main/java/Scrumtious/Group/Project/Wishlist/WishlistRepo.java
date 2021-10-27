package Scrumtious.Group.Project.Wishlist;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepo extends MongoRepository<Wishlist, String> {

  public List<Wishlist> findByUserId(String userId);

  public List<Wishlist> findAll();

}
