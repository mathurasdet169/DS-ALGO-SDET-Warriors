import java.util.Scanner;
import java.util.ArrayList;

public class binOctHexaNumber {
	ArrayList<Integer>dToB=new ArrayList<Integer>();
	ArrayList<Integer>d=new ArrayList<Integer>();
	Scanner reader=new Scanner(System.in);
	
    private void DecimalToBinary() {
    	String db=" ";  
    	String dtb=" ";
    	System.out.println("Enter one integer");
    	int num=reader.nextInt();
    	int i=0;
    	int j=0;
    	while(num>1) {
    		i=num/2;
    		j=num%2;
    		//dToB.add(j);
    		db=db+j+" ";
    		if(i<2) { 
    			j=i;
    			//dToB.add(j);
    			db=db+j+" ";
    		}num=i;    		 		
    		}//System.out.println(db);
    		char ch;
    		String nch="";
    		for(int k=0;k<db.length();k++) {
    		    ch=db.charAt(k);
    		    nch=ch+nch;
    		    }
    		    System.out.println(nch);
    		        			
    		}
    	   	   	
    private void decimal_octal() {
    	System.out.println("Enter decimal number to convert Octal: ");
    	int num=reader.nextInt();
    	int i=0;
    	int j=0;
    	while(num>4) {
    		i=num/8;
    		j=num%8;
    		dToB.add(j);
    		if(i<8) {
    			j=i;
    			dToB.add(j);
    		}num=i;
   	}
//    		System.out.println(((Object) dToB).reversed());
    }
    protected void decimal_hex() {
    	System.out.println("Enter decimal number to Hexadecimal: ");
    	int num=reader.nextInt();
    	String str="";
    	char c;
    	String revstr="";
    	int i=0;
    	int j=0;
    	while(num>8) {
    		i=num/16;
    		j=num%16;
    		str=str+j+"";
    		if(i<16) {
    			j=i;
    			str=str+j+"";
    		}num=i;
    	}//System.out.println(str);
    	for(int k=0;k<str.length();k++) {
    		c=str.charAt(k);
    		revstr=c+revstr;
    		    			
    		}System.out.println(revstr);
    	}
    
      
    public static void main(String[] args) {
		binOctHexaNumber obj=new binOctHexaNumber();
		obj.DecimalToBinary();
		obj.decimal_octal();
		obj.decimal_hex();
			}
}