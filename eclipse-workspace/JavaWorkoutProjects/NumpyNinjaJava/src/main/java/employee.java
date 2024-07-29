public class employee{
	int level;
	double basic,boa,bonus;
	
	employee(int level,double basic, double boa, double bonus) {
		this.level =level;
		this.basic = basic;
		this.boa = boa;	
		this.bonus = bonus;
	}
	
	public double monthlyPF() {
		double monthlyPF =  0.12*basic;
		return monthlyPF;
	}
	
	public double monthlyGrossInc() {
		double monthlyGrossIncome = basic+bonus+boa-monthlyPF();
		return monthlyGrossIncome;
	}
	
	public  double monthlyTax() {
		double tax =0;
		double yearlyGrossIncome = monthlyGrossInc()*12;
		
			if (yearlyGrossIncome<=250000)
			   tax = 0;
			else if (yearlyGrossIncome>250000 && yearlyGrossIncome<=500000)
				tax = 0.05*monthlyGrossInc();
			else if (yearlyGrossIncome>500000 && yearlyGrossIncome<=750000)
				tax = 1.2*monthlyGrossInc();
			else if (yearlyGrossIncome>750000 && yearlyGrossIncome<=1000000)
				tax = 0.15*monthlyGrossInc();
			else if (yearlyGrossIncome>1000000 && yearlyGrossIncome<=1250000)
				tax = 0.2*monthlyGrossInc();
			else if (yearlyGrossIncome>1250000 && yearlyGrossIncome<=1500000)
				tax = 0.25*monthlyGrossInc();
			else if (yearlyGrossIncome>1500000)
				tax = 0.3*monthlyGrossInc();
		
		return tax;
	}
	
	public double monthlyTakeHomeSal() {
		double monthlyTakeHomeSal = monthlyGrossInc()-monthlyTax();
		return monthlyTakeHomeSal;		
	}
	
	
	public static void main(String[] args) {
		//-------To Calculate the monthly take home salary of employees----
	    employee[] emp = new employee[4];		 
		emp[0]= new employee(1,7000,5000,2000);
		emp[1]= new employee(1,10000,7000,2500);
		emp[2]= new employee(1,12000,9000,3000);
		emp[3]= new employee(1,15000,10000,3500);
		
		for(int i=0; i<emp.length; i++)
			System.out.println("The monthly take home salary of employee "+(i+1)+" is "+ emp[i].monthlyTakeHomeSal());
					
	}

}
