import org.apache.log4j.Logger;

public class Log4jExample {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(Log4jExample.class);

		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
}
