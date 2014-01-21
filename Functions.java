
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Peng Fei Wang
 * This class stores all the functions that the program requires to function. It extends to the menu class to access
 * the date field.
 *
 */
public class Functions extends Menu {
	/**
	 * the saveFileInitiation method is used to check if saved files with the appropriate names exist and are readable
	 * if, the saved files do not exist, then this method can create new blank saved files with the appropriate names.
	 * @throws IOException
	 */

	public void saveFileInitiation () throws IOException
	{
		String namepart1;//the string that serves as the name of save files
		String name;//string that represents the complete name of a save file
		int choice;//int that represents user input
		Scanner sc = new Scanner (System.in); // used to get user input
		try {
			for (int b = 1; b < 366; b++) // loop is used to go through all expected save files
			{
				namepart1 = Integer.toString(b);
				name = namepart1 + ".txt";
				File file = new File (name);
				if  (file.canRead() == false) // check to see if the file can be read
				{
					System.out.println("Saved Files are either missing or the program is denied access");
					System.out.println("1. Create new SaveFiles");
					System.out.println("2. Exit");
					System.out.println("Choose an option: ");
					choice = sc.nextInt();
					if (choice == 1)
					{
						for (int a = 1; a < 366; a++) // creates new blank saved files
						{
							namepart1 = Integer.toString(a);
							name = namepart1 + ".txt";
							FileWriter write2 = new FileWriter (name);
							BufferedWriter write = new BufferedWriter (write2);
							for (int z = 0; z < 60; z++)
							{
								write.newLine();
							}
							write.close();
							
						}
					}
					else if (choice == 2)
					{
						System.exit(0);
					}
				}
			}			
		}
		catch (IOException e) // catch io exceptions
		{
		}
		//String check = read.readLine();
		//System.out.println("check");
	}
	
	
	/**
	 * the loadDate class is used to read a specific save file and transfer that information into a Day object. 
	 * @param day: an int that represents the identity of the save file to be loaded
	 * @throws IOException
	 */
	public Day loadDate(int day) throws IOException 
	{
		String name;//String that is the name of the save file that will be read
		name = Integer.toString(day);
		int temp2;//an int used as a temporary storage place before the information is placed into the Day object
		String temp;//a string used as a temporary storage place before the information is placed into the Day object
		boolean temp3;//a boolean used as a temporary storage place before the information is placed into the Day object
		try {
			FileReader read2 = new FileReader (name+".txt"); 
			BufferedReader read = new BufferedReader (read2);
			Day current = new Day();

			
			for (int a = 0; a < 5; a++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				current.setHomework(a, temp);
			}
			for (int b = 0; b < 5; b++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				if (temp.equals("true"))
				{
					temp3 = true;
				}
				else temp3 = false;
				current.setHomeworkstate(b, temp3);
			}
			for (int c = 0; c < 5; c++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				try{
					temp2 = Integer.parseInt(temp);
				}
				catch(NumberFormatException e)
				{
					temp2 = 0;
				}
				current.setHomeworkduedate(c, temp2);
			}
			for (int d = 0; d < 5; d++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				current.setQuiz(d, temp);
			}
			for (int e = 0; e < 5; e++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				if (temp.equals("true"))
				{
					temp3 = true;
				}
				else temp3 = false;
				current.setQuizstate(e, temp3);
			}
			for (int f = 0; f < 5; f++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				try{
					temp2 = Integer.parseInt(temp);
				}
				catch (NumberFormatException e)//catches number format exception
				{
					temp2 = 0;
				}
				current.setQuizduedate(f, temp2);
			}
			for (int g = 0; g < 5; g++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				current.setTest(g, temp);
			}
			for (int h = 0; h < 5; h++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				if (temp.equals("true"))
				{
					temp3 = true;
				}
				else temp3 = false;
				current.setTeststate(h, temp3);
			}
			for (int i = 0; i < 5; i++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				try {
					temp2 = Integer.parseInt(temp);
				}
				catch (NumberFormatException e){//catches number format exception
					temp2 = 0;
				}
				
				current.setTestduedate(i, temp2);
			}
			for (int j = 0; j < 5; j++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				current.setAssignment(j, temp);
			}
			for (int k = 0; k < 5; k++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				if (temp.equals("true"))
				{
					temp3 = true;
				}
				else temp3 = false;
				current.setAssignmentstate(k, temp3);
			}
			for (int l = 0; l < 5; l++) //reads information and transfers the information to the Day object
			{
				temp = read.readLine(); 
				try{
					temp2 = Integer.parseInt(temp);
				}
				catch (NumberFormatException e) //catches number format exception
				{
					temp2 = 0;
				}
				current.setAssignmentduedate(l, temp2);
			}
			read.close();
			return current;
		} catch (FileNotFoundException e) {
			System.out.println("Saved file does not exist, please reload the program");
			
		}
		Day placeholder = new Day(); //place holder null object returned if an error occured in reading the saved file
		return placeholder; 
	}
	
	/**
	 * the saveDate method is used to save the information of a Day object to a save file
	 * @param date: an integer that represents the name of the saved file
	 * @param current: a Day object that will have its information saved to a text file.
	 * @throws IOException
	 */
	public void saveDate(int date, Day current) throws IOException
	{
		String name = Integer.toString(date);

		try {
			FileWriter write2 = new FileWriter (date+".txt");
			BufferedWriter write = new BufferedWriter (write2);

			
			for (int a = 0; a < 5; a++) //writes information from Day object to save file
			{
			write.write(current.getHomework(a));
			write.newLine();
			}
			for (int b = 0; b < 5; b++) //writes information from Day object to save file
			{
				 
				if (current.getHomeworkstate(b)==true)
				{
					write.write("true");
					write.newLine();
				}
				else 
				{
					write.write("false");
					write.newLine();
				}
				
			}
			for (int c = 0; c < 5; c++)//writes information from Day object to save file
			{

				write.write(Integer.toString(current.getHomeworkduedate(c)));
				write.newLine();
			}
			for (int d = 0; d < 5; d++)//writes information from Day object to save file
			{
				write.write(current.getQuiz(d));
				write.newLine();
			}
			for (int e = 0; e < 5; e++)//writes information from Day object to save file
			{
				 
				if (current.getQuizstate(e)==true)
				{
					write.write("true");
					write.newLine();
				}
				else 
				{
					write.write("false");
					write.newLine();
				}
				
			}
			for (int f = 0; f < 5; f++)//writes information from Day object to save file
			{

				write.write(Integer.toString(current.getQuizduedate(f)));
				write.newLine();
			}
			for (int g = 0; g < 5; g++)//writes information from Day object to save file
			{
			write.write(current.getTest(g));
			write.newLine();
			}
			for (int h = 0; h < 5; h++)//writes information from Day object to save file
			{
				 
				if (current.getTeststate(h)==true)
				{
					write.write("true");
					write.newLine();
				}
				else 
				{
					write.write("false");
					write.newLine();
				}
				
			}
			for (int i = 0; i < 5; i++)//writes information from Day object to save file
			{

				write.write(Integer.toString(current.getTestduedate(i)));
				write.newLine();
			}
			for (int j = 0; j < 5; j++)//writes information from Day object to save file
			{
			write.write(current.getAssignment(j));
			write.newLine();
			}
			for (int k = 0; k < 5; k++)//writes information from Day object to save file
			{
				 
				if (current.getAssignmentstate(k)==true)
				{
					write.write("true");
					write.newLine();
				}
				else 
				{
					write.write("false");
					write.newLine();
				}
				
			}
			for (int l = 0; l < 5; l++)//writes information from Day object to save file
			{

				write.write(Integer.toString(current.getAssignmentduedate(l)));
				write.newLine();
			}
			write.close();
			
		} catch (FileNotFoundException e) // catches file not found exceptions
		{
			System.out.println("Saved file does not exist, please reload the program");
			
		}

	}
	
	
	
	/**the askDate method asks the user for the current date by asking for month and day. This information is converted
	 * to an absolute scale where january first is represented as 1, january second is represented as 2 ... all the day to
	 * december 31st. 
	 * @return int: the integer returned represents the absolute scale of the date inputted by the user
	 */
	public int askDate() 
	{
		Scanner sc = new Scanner(System.in);
		int month = 0, day = 0, presentDate = 0;
		int loop = 0;
		while (loop == 0)
		{
			loop = 1;
		System.out.println("Please Select the Current Month: ");
		System.out.println("1. January ");
		System.out.println("2. February ");
		System.out.println("3. March ");
		System.out.println("4. April ");
		System.out.println("5. May ");
		System.out.println("6. June ");
		System.out.println("7. July ");
		System.out.println("8. Auguest ");
		System.out.println("9. September ");
		System.out.println("10. October ");
		System.out.println("11. November ");
		System.out.println("12. December ");
		System.out.println("Please Enter Your Choice ");
		try {
			month = sc.nextInt(); // asks user for month
			sc.nextLine();
			
			System.out.println("Please Enter the Present Day of the Month: ");
	
			day = sc.nextInt(); // asks user for day

		

			if (month == 1) // conversion from month day to absolute scale
			{
				presentDate = day;
			}
			else if (month == 2)
			{
				presentDate = day+31;
			}
			else if (month == 3)
			{
				presentDate = day+31+28;
			}
			else if (month == 4)
			{
				presentDate = day+31+28+31;
			}
			else if (month == 5)
			{
				presentDate = day+31+28+31+30;
			}
			else if (month == 6)
			{
				presentDate = day+31+28+31+30+31;
			}
			else if (month == 7)
			{
				presentDate = day+31+28+31+30+31+30;
			}
			else if (month == 8)
			{
				presentDate = day+31+28+31+30+31+30+31;
			}
			else if (month == 9)
			{
				presentDate = day+31+28+31+30+31+30+31+31;
			}
			else if (month == 10)
			{
				presentDate = day+31+28+31+30+31+30+31+31+30;
			}
			else if (month == 11)
			{
				presentDate = day+31+28+31+30+31+30+31+31+30+31;
			}
			else if (month == 12)
			{
				presentDate = day+31+28+31+30+31+30+31+31+30+31+30;
			}
		}
		catch (InputMismatchException e) //catches input mistmatch exceptions
		{

		}
		if ( month > 12 | month < 1 | day > 31 | day < 1) // catches inappropriate input
		{
			sc.nextLine();
			System.out.println("Inappropriate Input");
			loop = 0;
			presentDate = 0;
		}
		else {
		}
		}
	return presentDate;
	}
	
	
	
	/**
	 *The addInformation method takes in specific input and adds the information from the input to the day
	 * @param currentDay: this it the Day object that will have additional information added to it
	 * @throws IOException
	 */
	public void  addInformation (Day currentDay) throws IOException
	{

		int input, secondaryinput, newdate;
		String info;
		int exit = 0;
		boolean error = false;
		int count = 0;
		boolean found = false;
		Scanner sc = new Scanner (System.in);
		System.out.println("Add Information:");
		System.out.println("Which category does the new school work/activity fall under?");
		System.out.println("1. Homework");
		System.out.println("2. Assignment");
		System.out.println("3. Quiz");
		System.out.println("4. Test");
		System.out.println("5. Return to Main Menu");
		System.out.println("Please Enter Your Choice:");
		try {
		input = sc.nextInt();
		sc.nextLine();
		if (input == 1)
		{
			System.out.println("New Homework");
			System.out.println("Is the homework due?");
			System.out.println("1. Tomorrow");
			System.out.println("2. The Day After Tomorrow");
			System.out.println("3. Other");
			secondaryinput = sc.nextInt();
			sc.nextLine();
			if (secondaryinput == 1)
			{

					for (int a = 0; a < 5; a++) //searches for a free slot out of the 5 available spaces for new homework
					{

						if (currentDay.getHomework(a).equals("") == true)
						{
							currentDay.setHomeworkduedate(a, date+1); // sets the due date
							System.out.println("Please Enter Information Concerning this Homework: ");
							info = sc.nextLine();
							currentDay.setHomework(a, info); //sets the general information
							currentDay.setHomeworkstate(a,false); //sets the state of the work
							found = true;
						}
						if (a == 4 && found == false) 
						{
							System.out.println("There are no more spaces for new Homework");
						}
						if (found == true)
						{
							a = 6;
						}
						
					}

				
			}
			else if (secondaryinput == 2)
			{
				for (int b = 0; b < 5; b++)
				{

						if (currentDay.getHomework(b).equals("") == true)
						{
							currentDay.setHomeworkduedate(b, date+2);
							System.out.println("Please Enter Information Concerning this Homework: ");
							info = sc.nextLine();
							currentDay.setHomework(b, info);
							currentDay.setHomeworkstate(b,false);
							found = true;
						}
						count ++;
						if (b == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Homework");
						}
						if (found  == true)
						{
							b = 6;
						}

				}
			}
			else if (secondaryinput == 3)
			{
				newdate = askDate();
				for (int c = 0; c < 5; c++)
				{

						if (currentDay.getHomework(c).equals("") == true)
						{
							currentDay.setHomeworkduedate(c, newdate);
							System.out.println("Please Enter Information Concerning this Homework: ");
							info = sc.nextLine();
							currentDay.setHomework(c, info);
							currentDay.setHomeworkstate(c,false);
							found = true;
						}
						count ++;
						if (c == 5 && found == false)
						{
							System.out.println("There are no more spaces for new Homework");
						}
						if (found == true)
						{
							c = 6;
							
						}
					
				}
			}
			else error = true;
			
		}
		else if (input == 2)
		{
			System.out.println("New Assignment");
			System.out.println("Is the Assignment due?");
			System.out.println("1. Tomorrow");
			System.out.println("2. The Day After Tomorrow");
			System.out.println("3. Other");
			secondaryinput = sc.nextInt();
			sc.nextLine();
			if (secondaryinput == 1)
			{

					for (int d = 0; d < 5; d++)
					{

						if (currentDay.getAssignment(d).equals("") == true)
						{
							currentDay.setAssignmentduedate(d, date+1);
							System.out.println("Please Enter Information Concerning this Assignment: ");
							info = sc.nextLine();
							currentDay.setAssignment(d, info);
							currentDay.setAssignmentstate(d,false);
							found = true;
						}
						if (d == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Assignment");
						}
						if (found == true)
						{
							d = 6;
						}
						
					}

				
			}
			else if (secondaryinput == 2)
			{
				for (int e = 0; e < 5; e++)
				{

						if (currentDay.getAssignment(e).equals("") == true)
						{
							currentDay.setHomeworkduedate(e, date+2);
							System.out.println("Please Enter Information Concerning this Assignment: ");
							info = sc.nextLine();
							currentDay.setAssignment(e, info);
							currentDay.setAssignmentstate(e,false);
							found = true;
						}
						count ++;
						if (e == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Assignment");
						}
						if (found  == true)
						{
							e = 6;
						}

				}
			}
			else if (secondaryinput == 3)
			{
				newdate = askDate();
				for (int f = 0; f < 5; f++)
				{

						if (currentDay.getAssignment(f).equals("") == true)
						{
							currentDay.setAssignmentduedate(f, newdate);
							System.out.println("Please Enter Information Concerning this Assignment: ");
							info = sc.nextLine();
							currentDay.setAssignment(f, info);
							currentDay.setAssignmentstate(f,false);
							found = true;
						}
						count ++;
						if (f == 5 && found == false)
						{
							System.out.println("There are no more spaces for new Assignment");
						}
						if (found == true)
						{
							f = 6;

						}
					
				}
			}
			else error = true;
		}
		else if (input == 3)
		{
			System.out.println("New Quiz");
			System.out.println("Is the Quiz due?");
			System.out.println("1. Tomorrow");
			System.out.println("2. The Day After Tomorrow");
			System.out.println("3. Other");
			secondaryinput = sc.nextInt();
			sc.nextLine();
			if (secondaryinput == 1)
			{

					for (int g = 0; g < 5; g++)
					{

						if (currentDay.getQuiz(g).equals("") == true)
						{
							currentDay.setQuizduedate(g, date+1);
							System.out.println("Please Enter Information Concerning this Quiz: ");
							info = sc.nextLine();
							currentDay.setQuiz(g, info);
							currentDay.setQuizstate(g,false);
							found = true;
						}
						if (g == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Quiz");
						}
						if (found == true)
						{
							g = 6;
						}
						
					}

				
			}
			else if (secondaryinput == 2)
			{
				for (int h = 0; h < 5; h++)
				{

						if (currentDay.getQuiz(h).equals("") == true)
						{
							currentDay.setQuizduedate(h, date+2);
							System.out.println("Please Enter Information Concerning this Quiz: ");
							info = sc.nextLine();
							currentDay.setQuiz(h, info);
							currentDay.setQuizstate(h,false);
							found = true;
						}
						count ++;
						if (h == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Quiz");
						}
						if (found  == true)
						{
							h = 6;
						}

				}
			}
			else if (secondaryinput == 3)
			{
				newdate = askDate();
				for (int i = 0; i < 5; i++)
				{

						if (currentDay.getQuiz(i).equals("") == true)
						{
							currentDay.setQuizduedate(i, newdate);
							System.out.println("Please Enter Information Concerning this Quiz: ");
							info = sc.nextLine();
							currentDay.setQuiz(i, info);
							currentDay.setQuizstate(i,false);
							found = true;
						}
						count ++;
						if (i == 5 && found == false)
						{
							System.out.println("There are no more spaces for new Quiz");
						}
						if (found == true)
						{
							i = 6;

						}
					
				}
			}
			else error = true;
		}
		else if (input == 4)
		{
			System.out.println("New Test");
			System.out.println("Is the Test due?");
			System.out.println("1. Tomorrow");
			System.out.println("2. The Day After Tomorrow");
			System.out.println("3. Other");
			secondaryinput = sc.nextInt();
			sc.nextLine();
			if (secondaryinput == 1)
			{

					for (int j = 0; j < 5; j++)
					{

						if (currentDay.getTest(j).equals("") == true)
						{
							currentDay.setTestduedate(j, date+1);
							System.out.println("Please Enter Information Concerning this Test: ");
							info = sc.nextLine();
							currentDay.setTest(j, info);
							currentDay.setTeststate(j,false);
							found = true;
						}
						if (j == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Test");
						}
						if (found == true)
						{
							j = 6;
						}
						
					}

				
			}
			else if (secondaryinput == 2)
			{
				for (int k = 0; k < 5; k++)
				{

						if (currentDay.getTest(k).equals("") == true)
						{
							currentDay.setTestduedate(k, date+2);
							System.out.println("Please Enter Information Concerning this Test: ");
							info = sc.nextLine();
							currentDay.setTest(k, info);
							currentDay.setTeststate(k,false);
							found = true;
						}
						count ++;
						if (k == 4 && found == false)
						{
							System.out.println("There are no more spaces for new Test");
						}
						if (found  == true)
						{
							k = 6;
						}

				}
			}
			else if (secondaryinput == 3)
			{
				newdate = askDate();
				for (int l = 0; l < 5; l++)
				{

						if (currentDay.getTest(l).equals("") == true)
						{
							currentDay.setTestduedate(l, newdate);
							System.out.println("Please Enter Information Concerning this Test: ");
							info = sc.nextLine();
							currentDay.setTest(l, info);
							currentDay.setTeststate(l,false);
							found = true;
						}
						count ++;
						if (l == 5 && found == false)
						{
							System.out.println("There are no more spaces for new Test");
						}
						if (found == true)
						{
							l = 6;

						}
					
				}
			}
			else error = true;
		}
		else if (input == 5)
		{
		exit = 1;
		}
		else 
		{
			error = true;
		}
		if (error == false && exit != 1)
		{
		saveDate(date, currentDay); // saves the Day object to the save file
		System.out.println("Action Completed");
		}
		else if (exit == 1)
		{
			
		}
		else System.out.println("Inappropriate Input");
		}
		catch (InputMismatchException e)
		{
			System.out.println("Inappropriate input");
		}
		

	}
	/**
	 * the editInformation method alters the information stored in a Day object to new user inputed information
	 * @throws IOException
	 */
	public void  editInformation () throws IOException
	{

		int input, secondaryinput, newdate = 0, choice, worknumber;
		String info;
		int end = 0;
		boolean error = false;
		boolean found = false;
		Scanner sc = new Scanner (System.in);
		System.out.println("Which Day would you like to revisit?");
		System.out.println("1. Today");
		System.out.println("2. Yesterday");
		System.out.println("3. The Day Before Yesterday");
		System.out.println("4. Other");
		try{
			input = sc.nextInt(); // gets file name
			sc.nextLine();
			if (input == 1)
			{
				newdate = date;
			}
			else if (input == 2)
			{
				newdate = date-1;
			}
			else if (input == 3)
			{
				newdate = date -2;
			}
			else if (input == 4)
			{
				newdate = askDate();
			}
			else error = true;

			if (error != true)
			{
				System.out.println("Which category does the new school work/activity fall under?");
				System.out.println("1. Homework");
				System.out.println("2. Assignment");
				System.out.println("3. Quiz");
				System.out.println("4. Test");
				System.out.println("5. Return to Main Menu");
				System.out.println("Please Enter Your Choice:");
				input = sc.nextInt();
				sc.nextLine();
				Day day = new Day();
				day = loadDate(newdate);
				if (input == 1)
				{
					System.out.println("Please Choose which Homework to Edit");
					for (int y = 0; y < 5; y++)
					{
						System.out.println(y+1+". "+day.getHomework(y));
					}
					System.out.println("6. Return to Main Menu");
					worknumber = sc.nextInt();
					sc.nextLine();
					if (worknumber < 6 && worknumber > 0){
						System.out.println("Please Select Option");
						System.out.println("1. Check Completed");
						System.out.println("2. Edit Information");
						choice = sc.nextInt();
						sc.nextLine();

						if (choice == 1 && day.getHomework(worknumber-1).equals("") != true)
						{
							day.setHomeworkstate(worknumber-1, true);
						}
						else if (choice == 2&& day.getHomework(worknumber-1).equals("") != true)
						{
							System.out.println("Enter Revised Information");
							info = sc.nextLine();
							day.setHomework(worknumber-1, info);
						}
					}else System.out.println("Inappropriate Input");
				}
				else if (input == 2)
				{
					System.out.println("Please Choose which Assignment to Edit");
					for (int x = 0; x < 5; x++)
					{
						System.out.println(x+1+". "+day.getAssignment(x));
					}
					System.out.println("6. Return to Main Menu");
					worknumber = sc.nextInt();
					sc.nextLine();
					if (worknumber < 6 && worknumber > 0){
						System.out.println("Please Select Option");
						System.out.println("1. Check Completed");
						System.out.println("2. Edit Information");
						choice = sc.nextInt();
						sc.nextLine();

						if (choice == 1)
						{
							day.setAssignmentstate(worknumber-1, true);
						}
						else if (choice == 2)
						{
							System.out.println("Enter Revised Information");
							info = sc.nextLine();
							day.setAssignment(worknumber-1, info);
						}
					}
					else System.out.println("Inappropriate Input");
				}
				else if (input == 3)
				{
					System.out.println("Please Choose which Quiz to Edit");
					for (int v = 0; v < 5; v++)
					{
						System.out.println(v+1+". "+day.getQuiz(v));
					}
					System.out.println("6. Return to Main Menu");
					worknumber = sc.nextInt();
					sc.nextLine();
					if (worknumber < 6 && worknumber > 0){
						System.out.println("Please Select Option");
						System.out.println("1. Check Completed");
						System.out.println("2. Edit Information");
						choice = sc.nextInt();
						sc.nextLine();

						if (choice == 1)
						{
							day.setQuizstate(worknumber-1, true);
						}
						else if (choice == 2)
						{
							System.out.println("Enter Revised Information");
							info = sc.nextLine();
							day.setQuiz(worknumber-1, info);
						}
					}
					else System.out.println("Inappropriate Input");
				}
				else if (input == 4)
				{
					System.out.println("Please Choose which Test to Edit");
					for (int w = 0; w < 5; w++)
					{
						System.out.println(w+1+". "+day.getTest(w));
					}
					System.out.println("6. Return to Main Menu");
					worknumber = sc.nextInt();
					sc.nextLine();
					if (worknumber < 6 && worknumber > 0){
						System.out.println("Please Select Option");
						System.out.println("1. Check Completed");
						System.out.println("2. Edit Information");
						choice = sc.nextInt();
						sc.nextLine();

						if (choice == 1)
						{
							day.setTeststate(worknumber-1, true);
						}
						else if (choice == 2)
						{
							System.out.println("Enter Revised Information");
							info = sc.nextLine();
							day.setTest(worknumber-1, info);
						}
					}
					else System.out.println("Inappropriate Input");
				}
				else if (input == 5)
				{
					end = 1;
				}
				else
				{
					error = true;
				}
				if (error == false && end != 1)
				{
					saveDate(date, day); // saves the Day object to the save file
					System.out.println("Action Completed");
				}
				else if (end == 1)
				{

				}
				else System.out.println("Inappropriate input");

			}
			else 
			{
				System.out.println("Inappropriate input");
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Inappropriate input");
		}
	}
	
	
	/**
	 * the quickCheck method searches through all the save files to check if any school work is due within 7 days of the 
	 * present day
	 * @throws IOException
	 */
	public void  quickCheck () throws IOException
	{

		int input, secondaryinput, newdate = 0, choice, worknumber;
		String info, name;
		boolean found = false;
		boolean error = false;
		Scanner sc = new Scanner (System.in);
		try{
		System.out.println("Quick Check");
		System.out.println("1. All homework due in the next 7 days");
		System.out.println("2. All assignments due in the next 7 days");
		System.out.println("3. All quizzes occurring in the next 7 days");
		System.out.println("4. All tests occurring in the next 7 days");
		input = sc.nextInt();
		sc.nextLine();
		int loop = 0, traverse = 1;
		LinkedList list = new LinkedList(); // creates a linked list to contain the Day objects the meet the 7 days criteria
		
		
		if (input == 1)
		{
			System.out.println("List of Homework due in the next 7 days: ");
			
			for (int b = 1; b < 366; b++) // loop that searches through all save files
			{
				
				Day day = new Day ();
				day = loadDate(b); //loads the Day object to check its contents
				for (int a = 0; a<5; a++)
				{
				if (day.getHomeworkduedate(a) < date + 7 && day.getHomeworkduedate(a) >= date) //checks if due date is within 7 days
				{
					
					Node newnode = new Node (day.getHomeworkduedate(a), day); // makes a new node that contains the Day object that fit the criteria
					list.appendFront(newnode); // adds the new node to the linked list
					System.out.print(traverse + ". "+ day.getHomework(a)+ "    Due: ");// prints the school work information
					dateGenerator(day.getHomeworkduedate(a)); // converts absolute date to month, day format
					if (day.getHomeworkstate(a) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					traverse ++;
				}
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();

		}
		else if (input == 2)
		{
			System.out.println("List of Assignment due in the next 7 days: ");
			
			for (int c = 1; c < 366; c++)
			{
				
				Day day = new Day ();
				day = loadDate(c);
				for (int d = 0; d<5; d++)
				{
				if (day.getAssignmentduedate(d) < date + 7 && day.getAssignmentduedate(d) >= date)
				{
					
					Node newnode = new Node (day.getAssignmentduedate(d), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getAssignment(d)+ "    Due: ");
					dateGenerator(day.getAssignmentduedate(d));
					if (day.getAssignmentstate(d) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					traverse ++;
				}
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}
		else if (input == 3)
		{
			System.out.println("List of Quiz due in the next 7 days: ");
			
			for (int e = 1; e < 366; e++)
			{
				
				Day day = new Day ();
				day = loadDate(e);
				for (int f = 0; f<5; f++)
				{
				if (day.getQuizduedate(f) < date + 7 && day.getQuizduedate(f) >= date)
				{
					
					Node newnode = new Node (day.getQuizduedate(f), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getQuiz(f)+ "    Due: ");
					dateGenerator(day.getQuizduedate(f));
					if (day.getQuizstate(f) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					traverse ++;
				}
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}
		else if (input == 4)
		{
		System.out.println("List of Tests due in the next 7 days: ");
			
			for (int g = 1; g < 366; g++)
			{
				
				Day day = new Day ();
				day = loadDate(g);
				for (int h = 0; h<5; h++)
				{
				if (day.getTestduedate(h) < date + 7 && day.getTestduedate(h) >= date)
				{
					
					Node newnode = new Node (day.getTestduedate(h), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getTest(h)+ "    Due: ");
					dateGenerator(day.getTestduedate(h));
					if (day.getTeststate(h) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					traverse ++;
				}
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}

		}
		catch (InputMismatchException e)
		{
			System.out.println("Inappropriate input");
		}
	}
	
	/**
	 * the check method finds all school work due on a specific user entered date and displays this list.
	 * @throws IOException
	 */
	public void  check () throws IOException
	{

		int input, secondaryinput, newdate = 0, choice, worknumber;
		String info, name;
		boolean found = false;
		boolean error = false;
		Scanner sc = new Scanner (System.in);
		System.out.println("Search for school work/activity in respect to due date:");
		System.out.println("Which day is the school work/activity due?");
		System.out.println("1. Tomorrow");
		System.out.println("2. The Day After Tomorrow");
		System.out.println("3. Other");
		try{
		input = sc.nextInt();
		sc.nextLine();
		if (input == 1)
		{
			newdate = date+ 1;
		}
		else if (input == 2)
		{
			newdate = date + 2;
		}
		else if (input == 3)
		{
			newdate = askDate();
		}
		else error = true;
		if (error != true){
		int loop = 0, traverse = 1;
		LinkedList list = new LinkedList(); // linked list that stores the list of school work due on the specified day
		System.out.println("1. Display only Homework");
		System.out.println("2. Display only Assignment");
		System.out.println("3. Display only Quiz");
		System.out.println("4. Display only Test");
		input = sc.nextInt();
		sc.nextLine();
		
		if (input == 1)
		{
			System.out.println("List of Homework due on specified date:");
			for (int b = 1; b < 366; b++) // searches all saved files to find school work that is due on specified date
			{
				Day day = new Day ();
				day = loadDate(b);
				for (int a = 0; a<5; a++)
				if (day.getHomeworkduedate(a) == newdate)
				{
					Node newnode = new Node (day.getHomeworkduedate(a), day); // node of Day object with school work due on the specific day
					list.appendFront(newnode); // adds the node to the linked list
					System.out.print(traverse + ". "+ day.getHomework(a)+"    Due: "); // displays the data from the Day object
					dateGenerator(day.getHomeworkduedate(a));
					if (day.getHomeworkstate(a) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					
					traverse ++;
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();


		}
		else if (input == 2)
		{
			System.out.println("List of Assignment due on specified date:");
			for (int c = 1; c < 366; c++)
			{
				Day day = new Day ();
				day = loadDate(c);
				for (int d = 0; d<5; d++)
				if (day.getAssignmentduedate(d) == newdate)
				{
					Node newnode = new Node (day.getAssignmentduedate(d), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getAssignment(d)+"    Due: ");
					dateGenerator(day.getAssignmentduedate(d));
					if (day.getAssignmentstate(d) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					
					traverse ++;
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}
		else if (input == 3)
		{
			System.out.println("List of Quiz due on specified date:");
			for (int e = 1; e < 366; e++)
			{
				Day day = new Day ();
				day = loadDate(e);
				for (int f = 0; f<5; f++)
				if (day.getQuizduedate(f) == newdate)
				{
					Node newnode = new Node (day.getQuizduedate(f), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getQuiz(f)+"    Due: ");
					dateGenerator(day.getQuizduedate(f));
					if (day.getQuizstate(f) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					
					traverse ++;
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}
		else if (input == 4)
		{
			System.out.println("List of Test due on specified date:");
			for (int g = 1; g < 366; g++)
			{
				Day day = new Day ();
				day = loadDate(g);
				for (int h = 0; h<5; h++)
				if (day.getTestduedate(h) == newdate)
				{
					Node newnode = new Node (day.getTestduedate(h), day);
					list.appendFront(newnode);
					System.out.print(traverse + ". "+ day.getTest(h)+"    Due: ");
					dateGenerator(day.getTestduedate(h));
					if (day.getTeststate(h) == true)
					{
						System.out.println("finished");
					}
					else System.out.println("unfinished");
					
					traverse ++;
				}
				
			}
			System.out.println("Enter an Integer to Return to Main Menu");
			input = sc.nextInt();
			sc.nextLine();
		}
		}
		else System.out.println("Inappropriate Input");
		}
		catch (InputMismatchException e)
		{
			System.out.println("Inappropriate Input");
		}
	}
	/**
	 * the dateGenerator method takes date represented as integers from 1-365 and converts it to the format month, day
	 * @param date
	 */
	public void dateGenerator (int date)
	{
		String temp;
		if (date - (31+28+31+30+31+30+31+31+30+31+30) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30+31+31+30+31+30));
			System.out.println("December " + temp );
		}
		else if (date - (31+28+31+30+31+30+31+31+30+31) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30+31+31+30+31));
			System.out.println("November " + temp );
		}
		else if (date - (31+28+31+30+31+30+31+31+30) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30+31+31+30));
			System.out.println("October " + temp );
		}
		else if (date - (31+28+31+30+31+30+31+31) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30+31+31));
			System.out.println("September " + temp );
		}
		else if (date - (31+28+31+30+31+30+31) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30+31));
			System.out.println("August " + temp );
		}
		else if (date - (31+28+31+30+31+30) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31+30));
			System.out.println("July " + temp );
		}
		else if (date - (31+28+31+30+31) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30+31));
			System.out.println("June " + temp );
		}
		else if (date - (31+28+31+30) > 0)
		{
			temp = Integer.toString(date-(31+28+31+30));
			System.out.println("May " + temp );
		}
		else if (date - (31+28+31) > 0)
		{
			temp = Integer.toString(date-(31+28+31));
			System.out.println("April " + temp );
		}
		else if (date - (31+28) > 0)
		{
			temp = Integer.toString(date-(31+28));
			System.out.println("March " + temp );
		}
		else if (date - (31) > 0)
		{
			temp = Integer.toString(date-(31));
			System.out.println("February " + temp );
		}		
		else if (date > 0)
		{
			temp = Integer.toString(date);
			System.out.println("January " + temp );
		}
		
	}
}
