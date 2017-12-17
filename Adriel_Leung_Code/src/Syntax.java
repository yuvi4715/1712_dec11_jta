public class Syntax {

	public static class ComputeOneClass {
		static int result;

		public static void add(int a, int b) {
			result = a + b;
			System.out.println(result);
		}

		public static void subtract(int a, int b) {
			result = a - b;
			System.out.println(result);

		}

		public static void multiply(int a, int b) {
			result = a * b;
			System.out.println(result);

		}

		public static void divide(int a, int b) {
			result = a / b;
			System.out.println(result);

		}
	}

	public static class Program {
		static int result;

		public static void add(int a, int b) {
			result = a + b;
			System.out.println(result);

		}

		public static void subtract(int a, int b) {
			result = a - b;
			System.out.println(result);

		}

		public static void multiply(int a, int b) {
			result = a * b;
			System.out.println(result);

		}

		public static void divide(int a, int b) {
			result = a / b;
			System.out.println(result);

		}
	}

	public static class RunProgram {
		public static void print() {
			Program.add(12, 17);
			Program.subtract(12, 17);
			Program.multiply(12, 17);
			Program.divide(12, 17);
		}
	}

	public static class Question_6 {
		public static void controlStatements() {
			// if else
			if (1 == 2) {
				System.out.println("1 equals 2");
			} else {
				System.out.println("1 does not equal 2");

			}

			// if else-if
			if (1 > 2) {
				System.out.println("1 is bigger than 2");
			} else if (3 > 2) {
				System.out.println("1 is not bigger than 2, but 3 is bigger than 2");
			} else {
				System.out.println("This should not print.");
			}

			// if else
			if (1 > 2) {
				System.out.println("1 is bigger than 2");
			} else {
				System.out.println("1 is not bigger than 2");
			}

			// switch, break
			int number = 3;
			switch (number) {
			case 1:
				System.out.println("The number is 1");
				break;
			case 2:
				System.out.println("The number is 2");
				break;
			case 3:
				System.out.println("The number is 3");
				break;
			default:
				System.out.println("The number is not 1, 2, nor 3");
				break;
			}

			// while
			int counter = 0;
			while (counter < 3) {
				System.out.println("The counter is currently bigger than 0");
				counter++;
			}

			// for
			for (int i = 0; i < 3; i++) {
				System.out.println("This is iteration " + i + " of the for loop");
			}

			// do-while
			int count = 0;
			do {
				System.out.println("This is iteration " + count + " of the do-while loop");
				count++;
			} while (count < 3);

			int[] array = { 1, 2, 3 };
			for (int i : array) {
				System.out.println(i);
			}

			// continue
			for (int i = 0; i < 3; i++) {
				System.out.println("The current iteration is " + i + " and this for loop will skip the 2nd iteration");
				if (i == 1) {
					continue;
				}
			}
		}
	}

	public static void main(String[] args) {
		ComputeOneClass.add(12, 17);
		ComputeOneClass.subtract(12, 17);
		ComputeOneClass.multiply(12, 17);
		ComputeOneClass.divide(12, 17);
		
		RunProgram.print();
		
		Question_6.controlStatements();
		
		return;
	}
}
