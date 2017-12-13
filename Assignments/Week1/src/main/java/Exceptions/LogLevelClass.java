package Exceptions;

import org.apache.log4j.Logger;

public  class LogLevelClass {
	private  static Logger log = Logger.getLogger(LogLevelClass.class.getName());
	private  String setLevel;

	public LogLevelClass(String loglevel){
		setLevel = loglevel;
	}
	public void errorMessage(String message) {
		//fine finer finest all  off
		switch (setLevel) {
		case "info":
			log.info(message);
			//log.log(Level.INFO, message);
			break;
		case "warning":
			log.warn(message);
			break;
		case "debug":
			log.debug(message);
		default:
			break;
		}
	}
}
