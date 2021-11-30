package Scrumtious.Group.Project.Wishlist;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

//import Scrumtious.Group.Project.Wishlist.Wishlist;

public interface WishlistRepo extends MongoRepository<Wishlist, String> {

  public List<Wishlist> findByUserId(String userId);

  public List<Wishlist> findAll();

}

