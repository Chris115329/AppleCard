package pkgAppleCard;
import java.io.*;

public class AppleCardSystem {

	public static void main(String[] args) {
		
		
		
		AppleCard Customerlogin = null;
		boolean validate = false;

		System.out.println("Hello! Welcome to AppleCard Login Page");
		try {

			Customerlogin = new AppleCard();

		 do {
			 
			
		validate = Customerlogin.validateCard();

		if (validate) {
			
			Customerlogin.processTransaction();
			Customerlogin.writeTransactions();
			   System.out.println();
			   Customerlogin.displayCardInfo();
			   

		} else {
			 System.out.println("Invaild Card Number try again");
		}


		   

		} while (validate == false);

		} // ends try block

		catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
			System.exit(100);
			
			
		}



		catch (NumberFormatException e) {
			System.out.println("Invalid number format!");
			System.exit(200);
			
			
		}

		catch (IOException e) {
			System.out.println("Error loading data!");
			System.exit(300);
			
		}

		

	}

}
