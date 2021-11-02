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

	public User(String id, 
				String email, 
				String password) 
	{
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		checkRequiredFields();
	}

	public User(String email,
				String password)
	{
		super();
		this.email = email;
		this.password = password;
		checkRequiredFields();
	}

	public User(String id, 
				String email,
				String password,
				Name name) 
	{
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		checkRequiredFields();
	}

	public User(String email,
				String password,
				Name name)
	{
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		checkRequiredFields();
	}

	public User(String id,
				String email, 
				String password, 
				Name name,  
				Address address) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		checkRequiredFields();
	}

	public User(String email, 
				String password,
				Name name, 
				Address address) 
	{
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		checkRequiredFields();
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
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
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * checks to see if the linked list for payment cards exist, if not create one
	 */
	public void checkifListForPaymentCardsExist()
	{
		if(paymentCards == null)
		{
			paymentCards = new LinkedList<CardInformation>();
		}
	}
	
	/**
	 * This method adds a payment card as long as it does not already exist
	 * @param cardInformation
	 */
	public void addUserCardInformation(CardInformation cardInformation) 
	{
		checkifListForPaymentCardsExist();
		for(int i = 0 ; i < paymentCards.size() ; i++)
		{
			if(paymentCards.get(i).getCardNumber().equals(cardInformation.getCardNumber()))
			{
				throw new IllegalStateException("Error: Card already exists");
			}
		}
		paymentCards.add(cardInformation);
	}
	
	/**
	 * This method deletes a payment card if exists
	 * @param cardNumber
	 */
	public void deleteUserCardInformation(String cardNumber)
	{
		Boolean deletedSuccessfully = false;
		if((getPaymentCards() != null) && (getPaymentCards().size() > 0))
		{
			for(int i = 0 ; i < getPaymentCards().size() ; i++)
			{
				if( getPaymentCards().get(i).getCardNumber().equals(cardNumber))
				{
					getPaymentCards().remove(i);
					deletedSuccessfully = true;
				}
			}
		}
		else
		{
			throw new IllegalStateException("Error: No payment cards exist");
		}
		
		if(!deletedSuccessfully)
		{
			throw new IllegalStateException("Error: Was not able to delete. Card number not found.");
		}
		
	}
	
	public void updateUserAddress(Address address)
	{
		setAddress(address);
	}
	
	public void updateUserName(Name name)
	{
		setName(name);
	}
	
	/**
	 * this method assists toString
	 * @return
	 */
	private String userName() 
	{
		StringBuilder nameInfo = new StringBuilder("{");
		if(name.getFirstName() != null)
		{
			nameInfo.append(" firstName= " + name.getFirstName() );
		}
		if(name.getMiddleName() != null)
		{
			nameInfo.append(", middleName= " + name.getMiddleName() );
		}
		if(name.getLastName() != null)
		{
			nameInfo.append(", zip= " + name.getLastName() );
		}

		nameInfo.append("}"); 
		return nameInfo.toString();
	}

	
	/**
	 * this method assists toString
	 * @return
	 */
	public String userCreditInfo()
	{
		if(paymentCards != null)
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
			cardinfo.append("]");
			return cardinfo.toString();
		}
		else
		{
			return "null";
		}
		
	}
	
	/**
	 * this method assists toString
	 * @return
	 */
	private String userAddress() 
	{
		if(address != null)
		{
			StringBuilder addressInfo = new StringBuilder("{");
			addressInfo.append(
					" street= " + address.getStreet() +
					", city= " + address.getCity() +
					", state= " + address.getStreet() +
					", zip= " + address.getZip()
					);
			addressInfo.append("}"); 
			return addressInfo.toString();
		}
		else
		{
			return "null";
		}

	}


	@Override
	public String toString()
	{

		return "User{" +
				", id= " + id +
				", email= " + email +
				", password= " + password +
				", name = " + userName() +
				", paymentCards= " + userCreditInfo() +
				", address= " + userAddress() +
				'}';
	}
	
	/**
	 * this method checks that the required fields are in place before instantiating a User
	 */
	public void checkRequiredFields()
	{
		if(email == null || 
				!(email.contains("@") && (email.contains(".com") || email.contains(".edu"))) )
		{
			if(email == null)
			{
				throw new IllegalStateException("Error: An email is required.");
			}
			throw new IllegalStateException("Error: A correct email is required.");
		}
		if(password == null)
		{
			throw new IllegalStateException("Error: A password is required.");
		}
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
	@Indexed(unique = true)
	private String email;
	private String password;
	private Name name;
	private LinkedList<CardInformation> paymentCards;
	private Address address;

}
