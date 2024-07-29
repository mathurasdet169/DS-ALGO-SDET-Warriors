import java.util.Arrays;
import java.util.Scanner;

public class Students {
	static int M[];
	public static void totalMarks(int[] M) {
		int Total = M[0]+M[1]+M[2]+M[3];
		System.out.println("The total score of this student is: " +Total);		
	}
	
	public static void avgMark(int[] M) {
		float avg = (M[0]+M[1]+M[2]+M[3])/4;
		System.out.println("The average score of this student is: "+ avg);		
	}
	
	public static void main(String[] args) {
		int M[] = new int[4];
		for (int i=1; i<=4; i++)
		 {
			System.out.println("Please enter the four subjects score of student "+i);
			for (int j=0; j<4; j++)
			{
				System.out.println("Enter the score"+(j+1));
				Scanner sc = new Scanner(System.in);	
				M[j] = sc.nextInt();
				if (M[j]<0 || M[j]>100)
				{
					System.out.println("Mark entered in Invalid. Marks should be between 0 and 100.");
					M[j]=sc.nextInt();
				}
								
			}
		
		   System.out.println("The scores of student "+i +" are "+Arrays.toString(M));
		   totalMarks(M);
		   avgMark(M);
		   
		 }
		
		System.out.println("All the students scores, Total and Average are calculated successfully!!");
	  }
	
	
	}


