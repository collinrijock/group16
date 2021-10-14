package Scrumtious.Group.Project.Wishlist;

import java.util.*;

public class Wishlist {
    private final String userID;
	//change object to book when implemented
	public Hashtable<String, Object> wishlistBooks = new Hashtable<String, Object>();
	public Wishlist(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}

	public void addBook(String bookID) {
		//check bookrepo, if return book add it to wishlist	
	}

	public void removeBook(String bookID) {
		//check wishlistBooks, if return book remove it	
	}

	public void addBookToCart(String bookID) {
		//Book book = removeBook(bookID);
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
