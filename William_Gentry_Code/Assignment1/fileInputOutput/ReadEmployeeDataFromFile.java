package fileInputOutput;
import java.io.*;
import java.util.*;

public class ReadEmployeeDataFromFile {

	private static String FILENAME = "src/fileInputOutput/employee_info.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String currentLine;
			HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
			while ((currentLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(currentLine, ":");
				while (st.hasMoreElements()) {
					int id = Integer.parseInt(st.nextElement().toString());
					String first = (String) st.nextElement();
					String last = (String) st.nextElement();
					String role = (String) st.nextElement();
					employees.put(id, new Employee(id, first, last, role));
				}
			}
			
			Iterator<Map.Entry<Integer, Employee>> entries = employees.entrySet().iterator();
			while (entries.hasNext()) {
				HashMap.Entry<Integer, Employee> entry = entries.next();
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue() + " (" + entry.getValue().getClass() + ")\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

}
