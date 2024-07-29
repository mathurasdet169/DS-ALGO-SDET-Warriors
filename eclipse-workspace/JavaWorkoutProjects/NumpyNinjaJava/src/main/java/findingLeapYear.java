
public class findingLeapYear {
	static boolean leapYear = false;
	public static boolean findLeapYear(int i) {
		if (i%4==0)
		  {
			leapYear=true;
			
			if(i%100==0)
			{
				if(i%400==0)
					leapYear = true;
				else
					leapYear = false;
			}
			return leapYear;
		  }
		else
			leapYear = false;
		    return leapYear;
	}

	public static void main(String[] args) {
		
		System.out.println("The following are the leap years between 2000 and 2100: ");
		for (int i=2000; i<=2100; i++) {
			if (findLeapYear(i)==true)
				System.out.println(i);			
		}

	}

}
