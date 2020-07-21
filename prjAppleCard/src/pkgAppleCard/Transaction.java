package pkgAppleCard;

public class Transaction {
	
	
	private String cardNumber;
	private int storeid;
	private String storename;
	private float amount;
	private String timeStamp;
	
	
	public Transaction() {
		
		cardNumber = "";
		storeid = 0;
		storename = "";
		amount = 0;
		timeStamp = "";
		
	}
	
	
	
	
	
	public Transaction(String cardNumber, int storeid, String storename, float amount, String timeStamp) {
		 super();
		this.cardNumber = cardNumber;
		this.storeid = storeid;
		this.storename = storename;
		this.amount = amount;
	    this.timeStamp = timeStamp;
	    
	    
	    
	
	    
	}
	


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public int getStoreid() {
		return storeid;
	}


	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}


	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
	  this.timeStamp = timeStamp;
	} 

}
