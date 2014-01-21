
import java.io.IOException;
import java.util.*;

/**
 * @author Peng Fei Wang
 * Date finished: Feburary 28th 2013
 * School: Victoria Park CI
 * Computer Used: home laptop Acer Aspire 5741-5193 
 * This program is an electronic agenda that allows the user to enter school related work. The work is stored within saved files
 * and the user can review the work at a later time through searching by date assigned or due date. The user can also edit the 
 * work stored at a later time.
 *
 */




/**
 * @author Peng Fei Wang
 *the Menu class is a menu used to allow the user to choice and navigate through the program.
 */
public class Menu {
	
	static int  date;
	public static void main (String[]args) throws IOException{
		try{
		Scanner sc = new Scanner(System.in);
		int loop = 0, secondaryloop = 0;
		int input = 0;;
		Functions f1 = new Functions();
		f1.saveFileInitiation();
		date = f1.askDate();
		while (loop == 0) // infinite loop of the menu, can only escape with the exit function
		{
			System.out.println("Main Menu");
			System.out.println("-------------------------------------------------------------");
			System.out.println("1. Add Information");
			System.out.println("2. Retrive/Edit Previous Information");
			System.out.println("3. Quick Check");
			System.out.println("4. Search for SchoolWork/Activity with respect to due date");
			System.out.println("5. Exit");
			System.out.println("Enter your option:");
			try {
				input = sc.nextInt();

			}
			catch (InputMismatchException e)
			{
				sc.nextLine();
			}
			if (input == 1)
			{
				f1.addInformation(f1.loadDate(date)); // calls the addInformation method to add information
			}
			else if (input == 2)
			{
				f1.editInformation();// calls the editInformation method to edit information
			}
			else if (input == 3)
			{
				f1.quickCheck(); // calls the quickCheck method to perform a quick check
			}
			else if (input == 4)
			{
				f1.check(); // calls the check method to perform a check
			}
			else if (input == 5)
			{
				System.exit(0); // exists the program
			}
			else if ( input > 5 | input < 1)
			{
				System.out.println("Inappropriate Input");
			}
			else {
				sc.nextLine();
				System.out.println("Inappropriate Input");
			}


		}
	}
	
	catch (Exception e){
		System.out.println("An unexpected error occured");
	}
	
	}


}




