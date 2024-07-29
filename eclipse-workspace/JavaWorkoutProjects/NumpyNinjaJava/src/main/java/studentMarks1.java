
public class studentMarks1 {
	int M1, M2, M3, M4;
	
	studentMarks1(int m1, int m2, int m3, int m4){
		M1 = m1;
		M2 = m2;
		M3 = m3;
		M4 = m4;
	}
	
	studentMarks1(int m1, int m2, int m3){
		M1 = m1;
		M2 = m2;
		M3 = m3;
		M4 = 35;		
	}
	
	studentMarks1(int m1, int m2){
		M1 = m1;
		M2 = m2;
		M3 = 35;
		M4 = 35;	
	}
	
	public int marksSum() {
		int Total = M1+M2+M3+M4;
		return Total;		
	}
	
	public double avgMark() {
		
		double avg = (double)(M1+M2+M3+M4)/4;
		return avg;		
	}

	public static void main(String[] args) {
	
		//-------java program to calculate sum & average  of given 4 marks via constructor---
		
		studentMarks1[] S = new studentMarks1[4];
		S[0]= new studentMarks1(78,99,87,89);
		S[1] = new studentMarks1(79,92,93);
		S[2] = new studentMarks1(77,99);
		S[3] = new studentMarks1(88,98,92,81);

		for (int i= 0; i<S.length;i++) {
			System.out.println("The sum of Marks of student "+(i+1)+" is "+S[i].marksSum());
			System.out.println("The average mark of student "+(i+1)+"  is "+S[i].avgMark());
		}
	}

}
