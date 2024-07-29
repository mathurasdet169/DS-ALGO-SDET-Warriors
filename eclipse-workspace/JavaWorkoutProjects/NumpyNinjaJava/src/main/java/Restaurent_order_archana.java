	import java.util.Scanner;
	import java.util.ArrayList;

	public class Restaurent_order_archana {
		static int sum=0;
		static int dining_charges=0;
		int item=0;
		static float GST_tax=0.0f;
		Scanner reader=new Scanner(System.in);
		ArrayList<String>receipe=new ArrayList<String>();
		ArrayList<Integer>amount=new ArrayList<Integer>();
		public static void main(String[] args) {
			float Total=0;
			Restaurent_order_archana obj=new Restaurent_order_archana();
			obj.ch_dining_parcel();
			obj.choose_category();
			Total=Total+sum;
			System.out.println("Here is your Total : "+Total);
			GST_tax =(1*Total)/100f;
			float Discount = 115.30f;
			Total=Total+GST_tax-Discount+dining_charges;
			System.out.println("Gst_tax 1percent "+GST_tax+"\nDiscount:"+Discount+"\nDining charges:"+dining_charges+"\nNet Bill amount: "+Total);

				}
		
		public void ch_dining_parcel() {
			int Dining=100;
			int parcel=20;
			boolean i=true;
			while(i) {
			System.out.println("[1] dine-in \n[2] take away");
			int dining_choice=reader.nextInt();
			if(dining_choice==1) {
				dining_charges=Dining;
				i=false;
			}
			else if (dining_choice==2)
			{
				dining_charges=parcel;
				i=false;
			}
			else {
				System.out.println("Invalid selection. Please try again !!");
			}
		}
		}
		
		public void choose_category() {
			System.out.println("category 1 is vegetarian and category 2 is Non_vegetarian:");
			int category=reader.nextInt();
			
			if(category==1) {
				Vegetarian();
			}
			if(category==2) {
				Non_vegetarian();
			}}
		public void Vegetarian() {
			System.out.println("[1] Panner Tikka -Rs.120.00(per item)");
			System.out.println("[2] Cashew pulao-Rs.150.00(per item)");
			System.out.println("[3] Veg fried Rice_Rs.130.00(per item");
			System.out.println("[4] Gobi 65-Rs.100.00(per item)");
			System.out.println("[5] Veg Thali-Rs.140.00(per item)");
			boolean option=true;
			while(option) {
				System.out.println("Enter your Option number");
				int num=reader.nextInt();
				System.out.println("How many parcels do you want?");
				int num_of_items=reader.nextInt();
				switch(num) {
				case 1:item=120;break;
				case 2:item=150;break;
				case 3:item=130;break;
				case 4:item=100;break;
				case 5:item=140;break;
				default:item=0;System.out.println("invalid option");break;
				}
				sum = sum + item*num_of_items;
				System.out.println("your amount is:"+sum);
				
				System.out.println("Do you want to continue?");
				String yes_no=reader.next().toLowerCase();
				
				if((yes_no).equals("yes")) {
					option=true;
					choose_category();
				}
				else if((yes_no).equals("no")) {
					System.out.println("Your amount is "+sum);
					option=false;
					break;
					
			}
				else
					option=false;
				break;
				}
				
				}
		public void Non_vegetarian() {
			System.out.println("[1] Chicken Biryani-Rs.200.00(per item)");
			System.out.println("2.Fish curry-Rs.150.00(per item)");
			System.out.println("3.Chicken 65-Rs.120.00(per item");
			System.out.println("4.Mutton gravy-Rs 220.00(per item)");
			System.out.println("5.Chicken Frien Rice-Rs 180.00(per item)");
			boolean option=true;
			while(option) {
				System.out.println("Enter your Option number");
				int num=reader.nextInt();
				System.out.println("How many plates do you want?,enter in number");
				int num_of_items=reader.nextInt();
				switch(num) {
				case 1:item=200;break;
				case 2:item=150;break;
				case 3:item=120;break;
				case 4:item=220;break;
				case 5:item=180;break;
				default:item=0;System.out.println("invalid option");break;
				}
				
				sum = sum+item*num_of_items;
				System.out.println("your amount is:"+sum);
				System.out.println("Do you want to continue?");
				String yes_no=reader.next().toLowerCase();
				if((yes_no).equals("yes")) {
					option=true;
					choose_category();
				}
				else if((yes_no).equals("no")){
					System.out.println("Your amount is "+sum);
					option=false;
					break;
			}
				else
					System.out.println("Your amount is "+sum);
				    option=false;
					break;
				}
				}
		
		
			
		
	}


