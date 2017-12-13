package fileio;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class FileIO24 {
	public static void main(String[] args) throws IOException {
		new FileIO24().parseFile();
	}

	private class Employee {
		private String employeeID;
		private String firstName;
		private String lastName;
		private String role;

		public Employee() {
		}

		public String getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(String employeeID) {
			this.employeeID = employeeID;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	}

	private void parseFile() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("text.txt"));
			Stream<String> str = br.lines();
			HashMap<String, Object> empData = new HashMap<String, Object>();
			str.forEachOrdered((line) -> {
				Employee emp = new Employee();
				StringTokenizer st = new StringTokenizer(line, ":");
				emp.setEmployeeID(st.nextToken());
				emp.setFirstName(st.nextToken());
				emp.setLastName(st.nextToken());
				emp.setRole(st.nextToken());
				empData.put(emp.getEmployeeID(), emp);
			});
			System.out.println(empData.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}
}
