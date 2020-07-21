package pkgAppleCard;

public class Customer {
	
	
	private String cardNumber;
	private String nameOfCompany;
	private String nameOfCard;
	private String fullname;
	private String expirationDate;
	private int cardSecurityCode; 
	 private String  billDueDate;
	 private float maximumAmount;
	 private float cardBalance;
	 
	 
	 public Customer() {
		 cardNumber = ""; 
		 nameOfCompany = "";
		 nameOfCard = "";
		 fullname = "";
		 expirationDate = "";
		 cardSecurityCode = 0;
		 billDueDate = "";
		 maximumAmount = 0;
		 cardBalance = 0;
		 
	 }
	
	
	
	public Customer(String cardNumber, String nameOfCompany, String nameOfCard, String fullname, String expirationDate,
			int cardSecurityCode, String billDueDate, float cardBalance, float maximumAmount) {
		super();
		this.nameOfCompany = nameOfCompany;
		this.nameOfCard = nameOfCard;
		this.fullname = fullname;
		this.expirationDate = expirationDate;
		this.cardSecurityCode = cardSecurityCode;
		this.billDueDate = billDueDate;
		this.cardBalance = cardBalance;
		this.maximumAmount = maximumAmount;
		this.cardNumber = cardNumber;
		
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public float getMaximumAmount() {
		return maximumAmount;
	}


	public void setMaximumAmount(float maximumAmount) {
		this.maximumAmount = maximumAmount;
	}


	public float getCardBalance() {
		return cardBalance;
	}


	public void setCardBalance(float cardBalance) {
		this.cardBalance = cardBalance;
	}


	public String getNameOfCompany() {
		return nameOfCompany;
	}


	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}


	public String getNameOfCard() {
		return nameOfCard;
	}


	public void setNameOfCard(String nameOfCard) {
		this.nameOfCard = nameOfCard;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getExpirationDate() {
		
		return expirationDate;
	}


	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


	public int getCardSecurityCode() {
		return cardSecurityCode;
	}


	public void setCardSecurityCode(int cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}


	public String getBillDueDate() {
		return billDueDate;
	}


	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	} 
	

}
