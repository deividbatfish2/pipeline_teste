package util.log;

import util.log.interfaces.ILogBdd;

public class LogManagerFactory {

	public static ILogBdd getLog(LogType tipo) {
		ILogBdd log = null;
		
		switch (tipo) {
		case BDD:
			log = new LogExtent();
			break;

		default:
			break;
		}
		return log;
	}

}
