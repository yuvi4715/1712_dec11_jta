package ersjava;

import javax.servlet.ServletException;

public class SubmitData {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			new Submit().init();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
