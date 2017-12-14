package com.revature.as1;

public class Project5 implements TestableProject{

	int[] argsI = new int[2];
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
		KeyboardInputScanner in = new KeyboardInputScanner();
		
		argsI = in.setIntArgs(2);
		
		in.close();
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		//unused due to project nature
		
	}
	
	public static void main(String[] args) {
		
		Project5 tester = new Project5();
		
		tester.setup();
		
		
		System.out.println("Adding input vars: " + (tester.new InnerMathods()).add(tester.argsI[0],tester.argsI[1]));
		System.out.println("Subtracting input vars: " + (tester.new InnerMathods()).subtract(tester.argsI[0],tester.argsI[1]));
		System.out.println("Multiplying input vars: " + (tester.new InnerMathods()).multiply(tester.argsI[0],tester.argsI[1]));
		System.out.println("Dividing input vars: " + (tester.new InnerMathods()).divide(tester.argsI[0],tester.argsI[1]));

	}
	
	private class InnerMathods {
		
		private int add(int A, int B) {
			return A + B;
		}

		private int subtract(int A, int B) {
			return A - B;
		}

		private int multiply(int A, int B) {
			return A * B;
		}

		private float divide(int A, int B) {
			try {
				if (B != 0) {
					return (float) A / B;
				} else {
					return Float.NaN;
				}
			} catch (Exception e) {
				System.out.println("You shouldn't be here. Stop breaking things.");
				return Float.NaN;
			}
		}
		
	}
	

}
