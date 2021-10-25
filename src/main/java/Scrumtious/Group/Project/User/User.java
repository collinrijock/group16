package Scrumtious.Group.Project.User;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import org.springframework.data.annotation.Id;


@Document(collection = "user")
public class User {


	public User()
	{
		super();
	}

	public User(String fName, 
			String lName, 
			String email,
			String password,
			CardInformation userCardInformation)
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.userCardInformation = userCardInformation;
	}

	public User(String id, 
			String fName, 
			String lName, 
			String email,
			String password,
			CardInformation userCardInformation) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.userCardInformation = userCardInformation;
	}
	
	public User(String email,
			String password)
	{
		super();
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString()
	{
		return "User{" +
				", id= " + id +
		        ", fname= " + fName +
		        ", lname= " + lName +
		        ", email= " + email +
		        ", password= " + password +
		        ", CardInformation= {" + 
		        ", cardNumber= " + userCardInformation.getCardNumber() +
		        ", experationDate= " + userCardInformation.getExperationDate() +
		        ", ccv= " + userCardInformation.getCcv() +
		        "}" +
		        '}';
	}

	@Id
	@SequenceGenerator(
			name = "Id_sequence",
			sequenceName = "Id_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "Id_sequence"
			)
	private String id;
	private String fName;
	private String lName;
	@Indexed(unique = true)
	private String email;
	private String password;
	private CardInformation userCardInformation;

}
