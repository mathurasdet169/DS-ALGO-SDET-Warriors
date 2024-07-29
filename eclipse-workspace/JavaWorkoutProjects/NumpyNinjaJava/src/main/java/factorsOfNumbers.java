import java.util.ArrayList;
import java.util.Scanner;

public class factorsOfNumbers {

	public static void main(String[] args) {
	
		ArrayList<Integer> factors = new ArrayList<>();
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter a number greater than zero to find its factors.");
		int myNo = myScanner.nextInt();
		   if(myNo<=0) 
			   System.out.println("The number entered is Invalid. Please enter a number greater than zero.");
			   myNo = myScanner.nextInt();
		   if(myNo>0) 
			{
			  for(int j=1; j<=myNo; j++)
			  {
				 if(myNo%j==0)
					 factors.add(j);
			  }
			}
			
			System.out.println("The number of factors for the given number is: "+factors.size());
			System.out.println("They are: "+"\n"+factors);
		
		}

	}


