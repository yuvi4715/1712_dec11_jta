package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem24to28 {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			String line;

			br = new BufferedReader(new FileReader("c:/textfile2.txt"));

			while ((line = br.readLine()) != null) {
				System.out.println(line);

				StringTokenizer stringTokenizer = new StringTokenizer(line, ":");

				while (stringTokenizer.hasMoreElements()) {

					Integer id = Integer.parseInt(stringTokenizer.nextElement().toString());
					String firstname = stringTokenizer.nextElement().toString();
					;
					String lastname = stringTokenizer.nextElement().toString();
					String role = stringTokenizer.nextElement().toString();
					
					StringBuilder sb = new StringBuilder();
					sb.append(id);
					sb.append(firstname);
					sb.append(lastname);
					sb.append(role);
					System.out.println(sb.toString());

					Employee emp = new Employee(id, firstname, lastname, role);

					Map<Integer, Employee> hashmap = new HashMap<Integer, Employee>();

					hashmap.put(id, emp);

					for (Map.Entry map : hashmap.entrySet()) {
						System.out.println("Key: " + map.getKey() + "  Value: " + map.getValue());
						System.out.println();
					}
					
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
