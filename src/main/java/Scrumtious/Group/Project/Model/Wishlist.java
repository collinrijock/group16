package Scrumtious.Group.Project.Model;

import java.util.*;

public class Wishlist {
    private final long userID;
	//change object to book when implemented
	Hashtable<String, Object> wishlistBooks = new Hashtable<String, Object>();
	public Wishlist(long userID) {
		this.userID = userID;
	}

	public long getUserID() {
		return userID;
	}

	public void addBook(String bookID) {
		//check bookrepo, if return book add it to wishlist	
	}

	public Book removeBook(String bookID) {
		//check wishlistBooks, if return book remove it	
	}

	public void addBookToCart(String bookID) {
		Book book = removeBook(bookID);
	}

	public String getWishlistBooks() {
		String bookList = "";
		Collection<Object> values = wishlistBooks.values();
		Iterator<Object> itr = values.iterator();
		while (itr.hasNext()) {
			bookList += itr.next().toString();
		}
		return bookList;
	}
}
