package Scrumtious.Group.Project.Wishlist;


import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;

import java.util.*;

public class Wishlist {
	@Id
	public String id;
	@BsonProperty(value = "user_id")
	private final String userId;
	private final String name;
	@BsonProperty(value = "wishlist_books")
	// change object to book when implemented
	private HashSet<String> wishlistBooks = new HashSet<>();

	public Wishlist(String userId, String name) {
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.name = name;
		this.wishlistBooks = new HashSet<>();
	}

	public String getWishlistId() {
		return this.id;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public String setId(String id) {
		this.id = id;
		return this.id;
	}

	public void addBook(String bookId) {
		this.wishlistBooks.add(bookId);
	}

	public void removeBook(String bookID) {
		this.wishlistBooks.remove(bookID);
	}

	public Set<String> getWishlistBooks() {
		return wishlistBooks;
	}
}
