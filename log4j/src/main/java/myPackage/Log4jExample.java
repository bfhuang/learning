package myPackage;

import org.apache.log4j.Logger;

public class Log4jExample {

    public static void main(String[] args) {
        new Log4jExample().logTest();


    }

    public void logTest() {
//        Logger log = Logger.getLogger(getClass());
        System.out.println(getClass().getName());
        Logger log = Logger.getLogger(getClass().getName());
//        Logger log = Logger.getLogger("myPackage.Log4jExample");

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        log.fatal("fatal");
    }
}
