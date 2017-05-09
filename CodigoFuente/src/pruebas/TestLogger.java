package pruebas;

import java.util.logging.FileHandler;

import java.util.logging.Logger;

public class TestLogger {

	public static void main(String[] args) throws Exception {

		boolean append = true;

		FileHandler handler = new FileHandler("log.log", append);

		Logger logger = Logger.getLogger("com.javacodegeeks.snippets.core");

		logger.addHandler(handler);

		logger.severe("severe message");

		logger.warning("warning message");

		logger.info("info message");

		logger.config("config message");

		logger.fine("fine message");

		logger.finer("finer message");

		logger.finest("finest message");
	}
}
