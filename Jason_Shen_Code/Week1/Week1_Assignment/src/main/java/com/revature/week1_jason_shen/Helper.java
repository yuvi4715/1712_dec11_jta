package com.revature.week1_jason_shen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Helper {
	
	// Running without arguments runs all the questions
	public static void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		int NUM_QUESTIONS = 46;	
		
		for (int i = 1; i < NUM_QUESTIONS + 1; i++) {

			if (i == 35) {
				System.out.println("Please run question 35 separately.\n");
				continue;
			}
			Helper.run(i);	

		}

	}		
	
	public static void run(int questionNumber) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		QuestionLoader q_loader = new QuestionLoader();
		
		String method_name;
		try {
			Method method;
			switch(questionNumber) {
				default:
					method_name = "question" + questionNumber;
					break;
				case(5):
					method_name = "question4_5";
					break;
				case(8):
					method_name = "question7_8";
					break;
				case(11): case(12): case(13): case(14): case(15):
					method_name = "question10_15";
					break;
				case(19):
					method_name = "question18_19";
					break;
				case(22): case(23):
					method_name = "question21_23";
					break;
				case(25): case(26): case(27): case(28):
					method_name = "question24_28";
					break;
				case(30): case(31):
					method_name = "question29_31";
					break;
			}
			
			method = q_loader.getClass().getMethod(method_name);
			method.invoke(q_loader, (Object[]) null);	
				
		
		} catch (NoSuchMethodException e) {
			System.out.println("Method not found");
		} catch (SecurityException e) {
			e.printStackTrace();
		}


	}
	
	public static void run(int startQuestion, int endQuestion) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (int i = startQuestion; i < endQuestion; i++) {
			if (i == 35) {
				System.out.println("Please run Question 35 separately.\n");
				continue;
			}
			Helper.run(i);
		}
	}
	
}
