import java.util.ArrayList;
import java.util.Scanner;

public class restaurantBillCalc {
	
	public static void nonVegMenuDisplay() {
		System.out.println("Below are the dishes available currently to order :"+"\n"+"[1] Chicken briyani - Rs. 200.00 (per item)"
				+"\n"+"[2] Fish curry -  Rs. 150.00 (per item)"+"\n"+"[3] Chicken 65 - Rs. 120.00 (per item)"+"\n"
				+"[4] Mutton gravy -  Rs. 220.00 (per item)"+"\n"+"[5] Chicken fried rice - Rs. 180.00 (per item)"); 
		}
	
	public static void vegMenuDisplay() {
		System.out.println("Below are the dishes available currently to order :"+"\n"+"[1] Paneer tikka - Rs. 120.00 (per item)"
				+"\n"+"[2] Cashew pulao - Rs. 150.00 (per item)"+"\n"+"[3] Veg fried rice - Rs. 130.00 (per item)"+"\n"
				+"[4] Gobi 65 - Rs. 100.00 (per item)"+"\n"+"[5] Veg. thali - Rs. 140.00 (per item)"); 
		}
	
	public static int selectedNonVegItemCost(){
		Scanner myScan = new Scanner(System.in);
		int cost = 0;
		System.out.println("\n"+"Please enter the option number to order:");	
		int itemNo = myScan.nextInt();
		
		if(itemNo>5 || itemNo<1)
			{System.out.println("You entered an Invalid Option. Please enter a valid number...");
			itemNo = myScan.nextInt();}
		
		switch (itemNo)
		  {
			case 1:{System.out.println("Please enter number of “Chicken briyani” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*200;
					break;}
			case 2:{System.out.println("Please enter number of “Fish curry” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*150;
					break;}
			case 3:{System.out.println("Please enter number of “Chicken 65” you would like to order:");
					int noOfitem = myScan.nextInt();
					 cost = noOfitem*120;
					break;}
			case 4:{System.out.println("Please enter number of “Mutton gravy” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*220;
					break;}
			case 5:{System.out.println("Please enter number of “Chicken fried rice” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*180;
					break;}
			default:{System.out.println("Sorry the number you entered is invalid..");
					 cost = 0;
					 break;}
		   }
		
		return cost;
		
	}
	
	public static int selectedVegItemCost(){
		Scanner myScan = new Scanner(System.in);
		System.out.println("\n"+"Please enter the option number to order:");	
		int itemNo = myScan.nextInt();
		if(itemNo>5 || itemNo<1)
			{System.out.println("You entered an Invalid Option. Please enter a valid number...");
			itemNo = myScan.nextInt();}
		int cost = 0;
		switch (itemNo)
		  {
			case 1:{System.out.println("Please enter number of “Paneer tikka” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*120;
					break;}
			case 2:{System.out.println("Please enter number of “Cashew pulao” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*150;
					break;}
			case 3:{System.out.println("Please enter number of “Veg fried rice” you would like to order:");
					int noOfitem = myScan.nextInt();
					 cost = noOfitem*130;
					break;}
			case 4:{System.out.println("Please enter number of “Gobi 65” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*100;
					break;}
			case 5:{System.out.println("Please enter number of “Veg. thali” you would like to order:");
					int noOfitem = myScan.nextInt();
					cost = noOfitem*140;
					break;}
			default:{System.out.println("Sorry the number you entered is invalid..");
					 cost = 0;
					 break;}
		   }
		
		return cost;
		
	}
	
	public static int orderedNonVegItemsCostList(){
		
		nonVegMenuDisplay();
		int itemCost = selectedNonVegItemCost();
		return itemCost;
	}
	
    public static int orderedVegItemsCostList(){
		
    	vegMenuDisplay();
		int itemCost = selectedVegItemCost();
		return itemCost;
	}
	


	public static void main(String[] args) {
		
		ArrayList<Integer> dishCostList = new ArrayList<>();
		String myOption;
		System.out.println("Please select the order type by entering the option number:"+"\n"+"[1] dine-in"+"\n"+"[2] take away");
		Scanner myScan = new Scanner(System.in);
		int x = myScan.nextInt();
		
		System.out.println("Please select the food category and enter the option number: "+"\n"+"[1] Vegetarian"+"\n"+"[2] Non-vegetarian");
		int y = myScan.nextInt();
		if(y>2 || y<1)
		{System.out.println("You entered an Invalid Option. Please enter [1] or {2]");
		 y = myScan.nextInt();}	
		
		while(y==1)
		  {
			dishCostList.add(orderedVegItemsCostList());	
			System.out.println("Would you like to order one more dish in Veg? Enter [Y] or {N]");
			myOption = myScan.next();
			
			if(!((myOption.equalsIgnoreCase("y")||myOption.equalsIgnoreCase("n"))))
	    		{System.out.println("You entered an Invalid Option. Please enter [Y] or {N]");
	    		 myOption = myScan.next();}
			
		    if(myOption.equalsIgnoreCase("Y")) 
			    { y=1;
			    continue;}
		    else
			    {
		    	System.out.println("Would you like to order any other Non-Veg dish? Enter [Y] or {N]");
		    	myOption = myScan.next();
		    	if(!((myOption.equalsIgnoreCase("y")||myOption.equalsIgnoreCase("n"))))
		    		{System.out.println("You entered an Invalid Option. Please enter [Y] or {N]");
		    		 myOption = myScan.next();}
		    	while(myOption.equalsIgnoreCase("Y"))
					{
					dishCostList.add(orderedNonVegItemsCostList());
					System.out.println("Would you like to order any other Non-Veg dish? Enter [Y] or {N]");
					myOption = myScan.next();
					if(myOption.equalsIgnoreCase("Y")) 
					   {myOption="Y";
					   continue;}
					else
					   {y=3;
						break;
						}	
					
				   }	
			    }
		  }
		
		while(y==2)
		  {
			dishCostList.add(orderedNonVegItemsCostList());	
			System.out.println("Would you like to order one more dish in non-veg? Enter [Y] or {N]");
			myOption = myScan.next();
			if(!((myOption.equalsIgnoreCase("y")||myOption.equalsIgnoreCase("n"))))
	    		{System.out.println("You entered an Invalid Option. Please enter [Y] or {N]");
	    		 myOption = myScan.next();}
		    if(myOption.equalsIgnoreCase("Y")) 
			    {y=2;
			    continue;}
		    else
		      {
		    	System.out.println("Would you like to order any other Veg dish? Enter [Y] or {N]");
		    	myOption = myScan.next();
		    	if(!((myOption.equalsIgnoreCase("y")||myOption.equalsIgnoreCase("n"))))
		    		{System.out.println("You entered an Invalid Option. Please enter [Y] or {N]");
		    		 myOption = myScan.next();}
				while(myOption.equalsIgnoreCase("Y"))
					{
					dishCostList.add(orderedVegItemsCostList());
					System.out.println("Would you like to order any other Veg dish? Enter [Y] or {N]");
					myOption = myScan.next();
					if(myOption.equalsIgnoreCase("Y")) 
					   {myOption="Y";
					   continue;}
					else
					  {
						y=1;
						break;	
					  }
				   }	
		       }
		    
			}
		
		
		System.out.println("The cost of each items ordered are: "+dishCostList);
		int TotalCost=0;
		for(int i:dishCostList)
		{
			TotalCost = TotalCost+i;
		}
		System.out.println("The total cost of ordered items is: Rs."+TotalCost);
		double GST_tax = 63.6; 
		System.out.println("GST tax: Rs."+GST_tax);
		int Parcel_DineInCharge = 30; 
		System.out.println("Parcel/ Dine-in Charge: Rs."+Parcel_DineInCharge);
		double discount = 115.30;
		System.out.println("The discount amount is: Rs."+discount);
		double NetBillAmount = TotalCost+GST_tax+Parcel_DineInCharge-discount;
		System.out.println("The Net Bill Amount is: Rs. "+NetBillAmount);
		System.out.println("Thank you! Visit again!...");
	
			
	}
}

