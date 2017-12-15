package question43;

public class ArmstrongCheck {

	public static void main(String[] args) {
		
		String armstrongNumber = "153";
		int power = armstrongNumber.length();
		int armstrongTotal = 0;
		for(int i = 0; i < armstrongNumber.length(); i++) {
			armstrongTotal += (int) Math.pow(Character.getNumericValue(armstrongNumber.charAt(i)), power);
		}
		if(armstrongTotal == Integer.parseInt(armstrongNumber)) {
			System.out.println("This is an armstrong number!");
		}
		else {
			System.out.println("This is not an armstrong number.");
		}
	}

}
