package Bonus;

public class CommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] firstName = new String[] {"Jose","Carlos", "William","James","Robin","Coney","Robin","William","Carlos"};
		Object[] secondName = new String[] {"Juan","William","Johnathan","Peter","Robin"};
		Object[] numbers = new Integer[] {1,2,4,3,6,5,3,7};
		
		common(firstName,secondName);
		common(numbers,secondName);


	}
	private static void common(Object[] array1, Object[] array2) {
		for(Object x : array1) {
			for(Object y : array2) {
				if(x.equals(y)) {
					System.out.println("Found dupe: " + y);
				}
			}
		}		
	}
}
