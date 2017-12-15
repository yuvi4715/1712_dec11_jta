
import java.io.IOException;
import java.util.logging.*;

public class LogLevelClass {
	final static Logger log = Logger.getLogger(LogLevelClass.class.getName());
	private String setLevel;

	public LogLevelClass(String loglevel, String nameOfFile) {
		setLevel = loglevel;
		
		try {
			Handler fileHandler = new FileHandler(nameOfFile, true);
			Handler consoleHandler = new ConsoleHandler();
			log.addHandler(fileHandler);
			log.addHandler(consoleHandler);
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
			log.setLevel(Level.ALL);
			//log.config("config done");
			log.removeHandler(consoleHandler);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void errorMessage(String message) {
		// fine finer finest all off

		switch (setLevel) {
		case "info":
			log.log(Level.INFO, message);
			break;
		case "warning":
			log.log(Level.WARNING, message);
			break;
		case "severe":
			log.log(Level.SEVERE, message);
			break;
		case "fine":
			log.log(Level.FINE, message);
			break;
		case "finer":
			log.log(Level.FINER, message);
			break;
		case "finest":
			log.log(Level.FINEST, message);
			break;
		case "all":
			log.log(Level.ALL, message);
			break;
		default:
			log.log(Level.OFF, message);
			break;
		}

	}


}
