package Scrumtious.Group.Project.User;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import Scrumtious.Group.Project.Wishlist.*;

import org.springframework.data.annotation.Id;


@Document(collection = "user")
//@Entity
//@Table
public class User {
	
	
	public User()
	{
		super();
	}

	public User(String fName, 
				String lName, 
				String email, 
				CardInformation userCardInformation, 
				Wishlist wishList) 
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.userCardInformation = userCardInformation;
		this.wishlist = wishList;
	}

	public User(String id, 
				String fName, 
				String lName, 
				String email, 
				CardInformation userCardInformation,
				Wishlist wishlist) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.userCardInformation = userCardInformation;
		this.wishlist = wishlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CardInformation getUserCardInformation() {
		return userCardInformation;
	}

	public void setUserCardInformation(CardInformation userCardInformation) {
		this.userCardInformation = userCardInformation;
	}

	public Wishlist getWishList() {
		return wishlist;
	}

	public void setWishList(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	
	
//	@Id
//    @SequenceGenerator(
//        name = "book_sequence",
//        sequenceName = "book_sequence",
//        allocationSize = 1
//    )
//    @GeneratedValue(
//        strategy = GenerationType.SEQUENCE,
//        generator = "book_sequence"
//    )
	
	/*
	 * User attributes
	 */
	@Id
	private String id;
	private String fName;
	private String lName;
	@Indexed(unique = true)
	private String email;
	private CardInformation userCardInformation;
	private Wishlist wishlist; 	
	
}
