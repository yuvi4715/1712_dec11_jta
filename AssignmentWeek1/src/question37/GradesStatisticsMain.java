package question37;

import java.io.IOException;

public class GradesStatisticsMain {

	public static void main(String[] args) throws IOException {
		
		GradesStatistics gs = new GradesStatistics();
		gs.getGrades();
		gs.computeMinimum();
		gs.computeMaximum();
		gs.computeStDev();
	}

}
