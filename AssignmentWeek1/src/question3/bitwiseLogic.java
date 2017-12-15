package question3;

public class bitwiseLogic {

	static boolean a = true;
	static boolean b = false;
	
	
	public static void main(String[] args)	{
		
		System.out.println(!a);
		System.out.println(a|b);
		System.out.println((!a & b)|(a & !b));
	}
}
