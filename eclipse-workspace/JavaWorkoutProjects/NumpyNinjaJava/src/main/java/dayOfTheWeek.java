import java.util.Scanner;

public class dayOfTheWeek {

	public static void main(String[] args) {
	
    //----------Java program to print the day of the week when number is given---------
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number between 1 to 7 to print the corresponding day:");
		int x = sc.nextInt();
		if (x<=0 || x>7)
			System.out.println("You entered an invalid number. Please enter a number between 1 to 7.");
		x = sc.nextInt();
		switch (x) {
		case 1: System.out.println("The day of the week is 'SUNDAY'."); break;
		case 2: System.out.println("The day of the week is 'MONDAY'."); break;
		case 3: System.out.println("The day of the week is 'TUESDAY'."); break;
		case 4: System.out.println("The day of the week is 'WEDNESDAY'."); break;
		case 5: System.out.println("The day of the week is 'THURSDAY'."); break;
		case 6: System.out.println("The day of the week is 'FRIDAY'."); break;
		case 7: System.out.println("The day of the week is 'SATURDAY'."); break;
		default: System.out.println("The number entered is Invalid....");
		}
		
	}
}
