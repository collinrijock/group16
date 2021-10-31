package Scrumtious.Group.Project.User;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.LinkedList;
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
			String password)
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}


	public User(String id, 
			String fName, 
			String lName, 
			String email,
			String password) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}
	
	public User(String fName, 
			String lName, 
			String email, 
			String password, 
			LinkedList<CardInformation> paymentCards,
			Address address) 
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.paymentCards = paymentCards;
		this.address = address;
	}
	
	public User(String id, 
			String fName, 
			String lName, 
			String email, 
			String password,
			LinkedList<CardInformation> paymentCards, 
			Address address) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.paymentCards = paymentCards;
		this.address = address;
	}

	public User(String id, 
			String fName, 
			String lName, 
			String email, 
			String password, 
			Address address) 
	{
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public User(String fName, 
			String lName, 
			String email, 
			String password, 
			Address address) 
	{
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public User(String email,
			String password)
	{
		super();
		this.email = email;
		this.password = password;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getfName() 
	{
		return fName;
	}

	public void setfName(String fName) 
	{
		this.fName = fName;
	}

	public String getlName() 
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	public LinkedList<CardInformation> getPaymentCards() 
	{
		return paymentCards;
	}

	public void setPaymentCards(LinkedList<CardInformation> paymentCards) 
	{
		this.paymentCards = paymentCards;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void checkifCardsAreInstatiation()
	{
		if(paymentCards == null)
		{
			paymentCards = new LinkedList<CardInformation>();
		}
	}

	public void addUserCardInformation(CardInformation cardInformation) 
	{
		checkifCardsAreInstatiation();
		for(int i = 0 ; i < paymentCards.size() ; i++)
		{
			if(paymentCards.get(i).getCardNumber().equals(cardInformation.getCardNumber()))
			{
				throw new IllegalStateException("Error: Card already exists");
			}
		}
		paymentCards.add(cardInformation);
	}

	public String userCreditInfo()
	{
		StringBuilder cardinfo = new StringBuilder("[");
		for(int i = 0 ; i < paymentCards.size() ; i++)
		{
			cardinfo.append(
					"{" + 
							" cardNumber= " + paymentCards.get(i).getCardNumber() +
							", experationDate= " + paymentCards.get(i).getExperationDate() +
							", ccv= " + paymentCards.get(i).getCcv() +
							"}" 
					);
			if(i != (paymentCards.size() - 1))
			{
				cardinfo.append(", ");
			}
		}
		return cardinfo.toString();
	}

	private String userAddress() 
	{
		StringBuilder addressInfo = new StringBuilder("{");
		if(address.getStreet() != null)
		{
			addressInfo.append(
					" street= " + address.getStreet() +
					", city= " + address.getCity() +
					", state= " + address.getStreet() +
					", zip= " + address.getZip()
					);
		}

		addressInfo.append("}"); 
		return addressInfo.toString();
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
				", paymentCards= [" + 
				userCreditInfo() +
				userAddress() +
				"]" +
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
	private LinkedList<CardInformation> paymentCards;
	private Address address;

}
