import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import File_IO.Employee;

public class File_IO {

	public static class Employee {
		int ID;
		String first_name;
		String last_name;
		String role;

		public Employee(int empl_ID, String first, String last, String job_role) {
			ID = empl_ID;
			first_name = first;
			last_name = last;
			role = job_role;
		}
	}

	public static void lineStream() throws Exception {
		BufferedReader inputStream = null;
		String filePath = new File("").getAbsolutePath();
		System.out.println ("Current working directory: " + filePath);

		try {
			inputStream = new BufferedReader(new FileReader(filePath + "\\src\\text"));
			HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
			
			String current_line;
			while ((current_line = inputStream.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(current_line, ":");
				Employee e1 = new Employee(Integer.parseInt(tokenizer.nextToken()), tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
				map.put(e1.ID, e1);
				System.out.println("Added employee to HashMap: - ID: " + e1.ID + " First Name: " 
						+ e1.first_name + " Last Name: " + e1.last_name + " Role: " + e1.role);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		lineStream();
	}
	
}
