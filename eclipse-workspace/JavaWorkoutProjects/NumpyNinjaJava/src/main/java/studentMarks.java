import java.util.Scanner;

public class studentMarks {
	int M1, M2, M3,M4;
	public studentMarks(int m1, int m2, int m3, int m4) {
		
		M1 = m1;
		M2 = m2;
		M3 = m3;
		M4 = m4;
	}
	
	public void totalMarks() {
		int Total = M1+M2+M3+M4;
		System.out.println("The total marks is: "+ Total);		
	}
	
	public void avgMark() {
		float avg = (M1+M2+M3+M4)/4;
		System.out.println("The average score is: "+ avg);		
	}

	public static void main(String[] args) {
		
		studentMarks S1, S2, S3, S4;
		S1 = new studentMarks(78,89,91,99);
		S2 = new studentMarks(88,91,93,79);
		S3 = new studentMarks(78,98,56,90);
		S4 = new studentMarks(81,93,67,89);
		
		S1.totalMarks();
		S1.avgMark();
		
		S2.totalMarks();
		S2.avgMark();
		
		S3.totalMarks();
		S3.avgMark();
		
		S4.totalMarks();
		S4.avgMark();
		
	}

}
