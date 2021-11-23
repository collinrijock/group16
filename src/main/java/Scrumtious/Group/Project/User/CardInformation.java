package Scrumtious.Group.Project.User;

public class CardInformation {
	
	public CardInformation(String cardNumber, 
						   String experationDate, 
						   String ccv) 
	{
		super();
		this.cardNumber = cardNumber;
		this.experationDate = experationDate;
		this.ccv = ccv;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getExperationDate() {
		return experationDate;
	}
	
	public void setExperationDate(String experationDate) {
		this.experationDate = experationDate;
	}
	
	public String getCcv() {
		return ccv;
	}
	
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	
	private String cardNumber;
	private String experationDate;
	private String ccv;
	
}