package Scrumtious.Group.Project.Wishlist.Applications;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Scrumtious.Group.Project.Wishlist.Model.Wishlist;

public interface WishlistRepo extends MongoRepository<Wishlist, String> {

  public List<Wishlist> findByUserId(String userId);

  public List<Wishlist> findAll();

}
