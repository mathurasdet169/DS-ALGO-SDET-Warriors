import java.util.ArrayList;

public class firstThirtyPrimeNos {

	public static void main(String[] args) {
		ArrayList<Integer> PrimeNos = new ArrayList<>();
		System.out.println("The first thirty prime numbers are: ");
		int i=2, NoOfPrimeNos = 0;
		while(NoOfPrimeNos<30) {
			int count = 0;
			for(int j=2; j<=i;j++) 
			 {
			   	if(i%j==0) 
		  		 count++;				      
			 }
			
		    if(count==1)
		    {
		    	PrimeNos.add(i);
		    	NoOfPrimeNos++;
			}
		    i++;
		  }
		
		System.out.println(PrimeNos);
		
		}
	}

	


