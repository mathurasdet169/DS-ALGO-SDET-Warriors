import java.util.Scanner;

public class nthNumOfFibonacciSeries {

	public static void main(String[] args) {
		//  java program to print the nth fibonacci series number
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the sequence number you want to find in a fibonacci series:");
		int n = myScanner.nextInt();
		
		int[] fibonacciSeries = new int[n];
		fibonacciSeries[0] = 0;
		fibonacciSeries[1] = 1;
		
		for(int i=2; i<n;i++)
		  {
			fibonacciSeries[i]=fibonacciSeries[i-1]+fibonacciSeries[i-2];
			}
		
       System.out.println("The number "+n+" of fibonacci series is: "+fibonacciSeries[n-1]);
	}

}
