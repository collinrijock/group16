package Scrumtious.Group.Project.Wishlist.Model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.*;

public class Wishlist {
	private final ObjectId id;
	@BsonProperty(value = "user_id")
	private final String userId;
	private final String name;
	@BsonProperty(value = "wishlist_books")
	// change object to book when implemented
	private HashSet<ObjectId> wishlistBooks = new HashSet<>();

	public Wishlist(String userId, String name) {
		this.id = new ObjectId();
		this.userId = userId;
		this.name = name;
		this.wishlistBooks = new HashSet<>();
	}

	public String getWishlistId() {
		return this.id.toHexString();
	}

	public String getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public void addBook(String bookId) {
		this.wishlistBooks.add(new ObjectId(bookId));
	}

	public void removeBook(String bookID) {
		this.wishlistBooks.remove(new ObjectId(bookID));
	}

	public Set<ObjectId> getWishlistBooks() {
		return wishlistBooks;
	}
}
