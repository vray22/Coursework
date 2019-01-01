/**
 * Victor Lozoya 
 * Date: 4/6/17
 * Lab7
 * will calculate gain or loss on shares will read in shares from a text file 
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Shares {//start of class 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ask user for filename and will set it next to variable filename
		System.out.println("Please enter transaction file name: ");
		String filename;
		Scanner scan = new Scanner(System.in);
		filename = scan.next();

		String input;
		// try reading input from file specified
		Scanner input2 = null;
		try {
			input2 = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException fnfe) {
			System.out.println("File " + filename + " was not found or could not be opened.");
			System.exit(0);
		}

		// Create two queues one named all and one buy
		LinkedQueue<String> all = new LinkedQueue<String>();
		LinkedQueue<String> buy = new LinkedQueue<String>();
		System.out.println("The following transactions were read from the file: ");
		int capitalGain = 0;

		// use while loop to add transactions line from file to all queue
		while (input2.hasNext()) {
			input = input2.nextLine();
			System.out.println("   " + input);
			all.add(input);

		}
		// will process transaction one by one
		// if it is a buy and to buy queue
		while (!all.isEmpty()) {

			input = all.remove();
			System.out.println("Processing transaction: " + input);

			if (input.charAt(0) == 'B' || input.charAt(0) == 'b') {
				buy.add(input);

			} else {// transaction is a sell

				String input3;
				input3 = buy.peek();// get string from buy que

				int k = 5;
				while (k < input.length() && Character.isDigit(input.charAt(k))) {
					k++;
				}
				String str = input.substring(5, k);
				int sell = Integer.parseInt(str);//get amount being sold 
				k = (int) input.indexOf('$') + 1;
				int j = k;
				while (j < input.length() && Character.isDigit(input.charAt(j))) {
					j++;
				}
				str = input.substring(k, j);
				int sellPrice = Integer.parseInt(str);//get amount sold at 

				int v = 4;
				while (v < input3.length() && Character.isDigit(input3.charAt(v))) {
					v++;
				}

				str = input3.substring(4, v);
				int bought = Integer.parseInt(str);//get amount bought 
				k = input3.indexOf('$') + 1;
				j = k;
				while (j < input3.length() && Character.isDigit(input3.charAt(j))) {
					j++;
				}
				str = input3.substring(k, j);
				int priceBought = Integer.parseInt(str);//get bought price 
                
				//create two new transaction objects using values i just got 
				Transaction sOne = new Transaction(true, sell, sellPrice);
				Transaction bOne = new Transaction(false, bought, priceBought);

				//shares being sold greater than bought in front of queue 
				if (sOne.getNumber() > bOne.getNumber()) {
					capitalGain += (bOne.getNumber()*(sOne.getPrice() - bOne.getPrice()));
					buy.remove();
					sOne.changeNumber(sOne.getNumber() - bOne.getNumber());
					while (sOne.getNumber() > 0) {//keep processing sell until it reaches 0 
						if(buy.isEmpty()){//check if trying to sell shares that don't exist 
	                        	System.out.println("Error: attempt to sell non-existing shares " );
	                        	System.exit(0);
	                        }
						input3 = buy.peek();
                      
						v = 4;
						while (v < input3.length() && Character.isDigit(input3.charAt(v))) {
							v++;
						}

						str = input3.substring(4, v);
						bought = Integer.parseInt(str);//get bought amount 
						

						k = input3.indexOf('$') + 1;
						j = k;
						while (j < input3.length() && Character.isDigit(input3.charAt(j))) {
							j++;
						}
						str = input3.substring(k, j);
						priceBought = Integer.parseInt(str);//get price for bought shares 

						Transaction bTwo = new Transaction(false, bought, priceBought);//create transaction object 
						//depending on weather shares number is greater than bought number 
						//then formula to computer capital gain will differ 
						if (sOne.getNumber() > bought) {
							buy.remove();
						    capitalGain += (bTwo.getNumber() * (sOne.getPrice() - bTwo.getPrice()));
						}
					   else if (sOne.getNumber() < bought) {
						    //will update front of queue with new string containing new shares 
						    capitalGain += (sOne.getNumber() * (sOne.getPrice() - bTwo.getPrice()));
							int temp = bought - sOne.getNumber();
							String str3 = Integer.toString(temp);
							String update = ("buy " + str3 + " " + input3.substring(8, input3.length()));
							buy.updateFront(update);
							
							
						}
						sOne.changeNumber(sOne.getNumber() - bTwo.getNumber());

					}//end while 
				} else {
					
					capitalGain += (sOne.getNumber() * (sOne.getPrice() - bOne.getPrice()));
					int temp = bought - sOne.getNumber();
					String str3 = Integer.toString(temp);
					String update = ("buy " + str3 + " " + input3.substring(8, input3.length()));
					buy.updateFront(update);
				}//end else 

			}//end outer else
		}//end while 
		
		System.out.println("Capital gain/loss: " + "$" + capitalGain);
		int sharesLeft = 0; 
		while(!buy.isEmpty()){
			input = buy.remove();
			int v = 4;
			while (v < input.length() && Character.isDigit(input.charAt(v))) {
				v++;
			}

			String str = input.substring(4, v);
			sharesLeft += Integer.parseInt(str);
			
		}
		System.out.println("There are " + sharesLeft + " shares left");

	}//end main 

}//end class 
