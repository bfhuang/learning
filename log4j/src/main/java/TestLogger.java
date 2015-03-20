import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by twer on 12/17/14.
 */
public class TestLogger {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(TestLogger.class);

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
        System.out.println("---------------------\n");
        log = Logger.getLogger("myPackage.Log4jExample");

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");

        System.out.println("---------------------\n");
        log = Logger.getLogger(TestLogger.class);
        FileAppender fileAppender = new FileAppender();
//        fileAppender.setFile("log4j/logging.log");
        fileAppender.setWriter(new FileWriter(new File("log4j/loggingFile.log")));
        fileAppender.setLayout(new PatternLayout());

        log.addAppender(fileAppender);

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");

    }
}
