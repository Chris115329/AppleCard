package pkgAppleCard;

import java.io.BufferedReader;



import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;




public class AppleCard {
	
	ArrayList<Transaction> purchase = new ArrayList<Transaction>();
	 Customer[] Customers = new Customer[5];
	
	// working variables
	int index = -1;
	String storename;
	 float amount;
   String timeStamp = "";
    String enteredCardNumber= "";
    int vendornum = 100;
    boolean validate = false;
    
    
  
AppleCard() throws IOException   {
	
	 
	loadCustomers();
	
	
	 
} // end of constructor






boolean validateCard() throws NumberFormatException, IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean validate = false;
		
		
		 
		System.out.print("Please enter your card number:");
		enteredCardNumber = br.readLine();
		
		
		for (int i = 0; i < Customers.length; i++)
		{	
			
			
			 if  (Customers[i].getCardNumber().equals(enteredCardNumber)) {
			validate = true;
			index = i; // index used so we can capture the customer and process their transaction in the processTransaction() method
			
		
		} // ends if
			 
			 
	} // ends for loop
		
		

	return validate;
		
		
	} // ends method



void processTransaction() throws NumberFormatException, IOException  {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	
	
	System.out.print("Enter the store name of your purchase:");
	storename = br.readLine();
	
	System.out.print("Please enter the transaction amount:");
	amount =  Float.parseFloat(br.readLine());
	
	float workingBalance = Customers[index].getMaximumAmount() - Customers[index].getCardBalance();
		
	      
	       if(amount <= workingBalance) {
	    	 System.out.println(" Your Transaction was accepted");
	    	
	    	 // transaction is approved
	    	 validate = true;
	    	 
	    	 // record purchase date
	    	 String pattern = "MM-dd-yyyy HH:mm:ss";
	    	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);  
	    	     Date date = new Date();  
	    		 timeStamp = formatter.format(date);  
	    		 
	    		 
	    	
	    	 // update storeid
	    	 vendornum++;
	    	
	    	 //update available balance
	    	 workingBalance = workingBalance - amount;	
		     
	    	 // update credit card balance
	    	 Customers[index].setCardBalance(Customers[index].getCardBalance() + amount); 
	    	 
	    	 // add purchase 
		     purchase.add(new Transaction (enteredCardNumber,vendornum,storename,amount,timeStamp));
		    
	    	 
		       } else {
	    	   
	    	 System.out.println("This Transaction is denied. Insufficient funds.");
	       }

		
		
				
	} // ends method




void displayCardInfo() {
	System.out.println("Name: " + Customers[index].getFullname());
   System.out.println("Maximum Amount: $" + Customers[index].getMaximumAmount());
  System.out.println("Card Balance: $" + Customers[index].getCardBalance());
  System.out.println("Bill Due Date: " + Customers[index].getBillDueDate());
  


} // ends method



void loadCustomers() throws IOException

{	
	
	
	//create the file for reading from
	FileReader fr= new FileReader("customer.txt");  
	BufferedReader br = new BufferedReader(fr);

	//create the variables for the file
	String cn = "";
	String nocompany = "";
	String nocard = "";
	String fn = "";
	String ed = "";
	int csc = 0;
	String bdd = "";
	float cb = 0f;
	float ma = 0f;
	

	//counter for the array
	int i = 0;

	//create the variables for each line
	String eachLine = "";
	StringTokenizer st; 
	
	eachLine = br.readLine();

	

	while (eachLine != null)	
      {	
         	st = new StringTokenizer(eachLine, ",");
         	while (st.hasMoreTokens()) 
         	{	
         		
         		//remember the order of the text file
         		cn = st.nextToken();
         		nocompany = st.nextToken();
         		nocard = st.nextToken();
         		fn = st.nextToken();
         		ed = st.nextToken();
         		csc = Integer.parseInt(st.nextToken());
         		bdd = st.nextToken();
         		cb = Float.parseFloat(st.nextToken());
         		ma = Float.parseFloat(st.nextToken());

         		Customers[i] = new Customer(cn,nocompany,nocard,fn,ed,csc,bdd,cb,ma);	//add the customer to the Array
         		i++;	//increment the counter for the next line
         		eachLine = br.readLine();//read the next line
		}  //end of reading one line
      }     //end of reading the file
      
	br.close();
	System.out.println("Customers Loaded");
} //end of loadCustomers()




void writeTransactions() throws IOException
{


	FileWriter fw = new FileWriter("Transaction.txt",true);
	BufferedWriter bw = new BufferedWriter(fw);
	
//Write each transaction to the file
    for (int i = 0; i < purchase.size(); i++) 
    {
     	bw.write(purchase.get(i).getCardNumber() + "," +
     			 purchase.get(i).getStoreid()    +  ","  +
  			     purchase.get(i).getStorename() + "," + 
  			    purchase.get(i).getAmount() + "," +
  			     purchase.get(i).getTimeStamp() + "\n");
     	        
	}
    
    // only print out message if transaction is approved 
    if (validate) {
   	 System.out.println("File written Successfully");
    }	 
	bw.close();

}//end of WriteSales()
	
	

}
