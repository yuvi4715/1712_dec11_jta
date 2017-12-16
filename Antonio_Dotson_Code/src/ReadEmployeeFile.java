import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class ReadEmployeeFile {

	/**
	 * Problems 24 through 28
	 */
	static public void main(String[] args) {
		//created employee.txt file 
		File file = new File("../employee.txt");
		String[] lines = new String[2];
		try {
			// open fileReader
			FileReader reader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(reader);
			//set the HashMap
			HashMap<String, Object> map = new HashMap<String, Object>();
			int x = 0;
			String s;
			// reading through file
			while ((s = buffReader.readLine()) != null) {
				// reading through file and separating by : and placing in a new object 
				StringTokenizer tokens = new StringTokenizer(s, ":");
				Storage rdline = new Storage(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(),
						tokens.nextToken());
				map.put(rdline.employeeID, rdline);
			}
			reader.close();
			buffReader.close();
			// using keys and enhance for loop to get values.
			Set<String> keys = map.keySet();
			for (String key : keys) {
				System.out.println(key + " " + map.get(key));
			}
		} catch (IOException e) {
			// handle exception
		}
	}
}
