package com.archforce.arc.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static String SPLICE = " | ";

    public static void warn(Class clz, String title, String message, Throwable e) {
        Logger logger = getLogger(clz);
        if (logger.isWarnEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            logger.warn(s.toString(), e);
        }
    }

    public static void warn(Class clz, String title, String message) {
        Logger logger = getLogger(clz);
        if (logger.isWarnEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            logger.warn(s.toString());
        }
    }

    public static void info(Class clz, String title, String message, Object... objects) {
        Logger logger = getLogger(clz);
        if (logger.isInfoEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            String s1 = s.toString();
            logger.info(s1, objects);
        }
    }

    public static void error(Class clz, String title, String message, Object... objects) {
        Logger logger = getLogger(clz);
        if (logger.isErrorEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            logger.error(s.toString(), objects);
        }
    }

    public static void trace(Class clz, String title, String message) {
        Logger logger = getLogger(clz);
        if (logger.isTraceEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            logger.trace(s.toString());
        }
    }

    public static void debug(Class clz, String title, String message) {
        Logger logger = getLogger(clz);
        if (logger.isDebugEnabled()) {
            StringBuilder s = new StringBuilder();
            s.append(title).append(SPLICE).append(message);
            logger.debug(s.toString());
        }
    }

    public static Logger getLogger(Class clz) {
        return LoggerFactory.getLogger(clz);
    }
}
