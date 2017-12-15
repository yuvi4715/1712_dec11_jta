package Bonus;

public class Factoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factoring(5);
	}
	private static void factoring(int number) {		
		int answer = 1;
		for (int i = 1; i <= number; i++) {
			answer = answer*i;
		}		
		System.out.println(answer);		
	}
}