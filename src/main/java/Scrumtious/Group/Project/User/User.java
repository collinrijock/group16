package Scrumtious.Group.Project.User;


public class User {
	
	
	public User()
	{
		super();
	}

	public User(String fName, 
				String lName, 
				String email, 
				CardInformation userCardInformation) 
				//WishList wishList) 
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.userCardInformation = userCardInformation;
		//this.wishList = wishList;
	}

	public User(Long id, 
				String fName, 
				String lName, 
				String email, 
				CardInformation userCardInformation)
				//WishList wishList) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.userCardInformation = userCardInformation;
		//this.wishList = wishList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

//	public WishList getWishList() {
//		return wishList;
//	}
//
//	public void setWishList(WishList wishList) {
//		this.wishList = wishList;
//	}
	
	/*
	 * User attributes
	 */
	private Long id;
	private String fName;
	private String lName;
	private String email;
	private CardInformation userCardInformation;
//	private WishList wishList; 	//Wishlist object should track a total price accumulater of the wishlist
								//as well as a list of books
	
}