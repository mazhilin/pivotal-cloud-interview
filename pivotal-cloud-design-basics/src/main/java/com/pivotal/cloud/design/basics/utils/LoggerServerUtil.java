package com.pivotal.cloud.design.basics.utils;

import org.slf4j.Logger;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @className: com.pivotal.cloud.design.basics.utils.LoggerServerUtil
 * @title: LoggerServerUtil
 * @description: 封装Pivotal项目LoggerServerUtil类
 * @content: //TODO
 * @author: marklin
 * @datetime: 2020-07-30 07:55
 * @version: 1.0.0
 * @copyright: Copyright © 2018-2020 Pivotal Systems Incorporated. All rights reserved.
 */
public class LoggerServerUtil {
private LoggerServerUtil() {}

public static synchronized LoggerServerUtil getInstance() {
    return LoggerServerHolder.instance;
}

/**
 * debug print log.
 *
 * @param logger log
 * @param format log information
 * @param supplier supplier
 */
public void debug(Logger logger, String format, Supplier<Object> supplier) {
    if (logger.isDebugEnabled()) {
        logger.debug(format, supplier.get());
    }
}

/**
 * Debug.
 *
 * @param logger the logger
 * @param supplier the supplier
 */
public void debug(Logger logger, Supplier<Object> supplier) {
    if (logger.isDebugEnabled()) {
        logger.debug(Objects.toString(supplier.get()));
    }
}

/**
 * Info.
 *
 * @param logger the logger
 * @param format the format
 * @param supplier the supplier
 */
public void info(Logger logger, String format, Supplier<Object> supplier) {
    if (logger.isInfoEnabled()) {
        logger.info(format, supplier.get());
    }
}

/**
 * Info.
 *
 * @param logger the logger
 * @param supplier the supplier
 */
public void info(Logger logger, Supplier<Object> supplier) {
    if (logger.isInfoEnabled()) {
        logger.info(Objects.toString(supplier.get()));
    }
}

/**
 * Error.
 *
 * @param logger the logger
 * @param format the format
 * @param supplier the supplier
 */
public void error(Logger logger, String format, Supplier<Object> supplier) {
    if (logger.isErrorEnabled()) {
        logger.error(format, supplier.get());
    }
}

/**
 * Error.
 *
 * @param logger the logger
 * @param supplier the supplier
 */
public void error(Logger logger, Supplier<Object> supplier) {
    if (logger.isErrorEnabled()) {
        logger.error(Objects.toString(supplier.get()));
    }
}

/**
 * Warn.
 *
 * @param logger the logger
 * @param format the format
 * @param supplier the supplier
 */
public void warn(Logger logger, String format, Supplier<Object> supplier) {
    if (logger.isWarnEnabled()) {
        logger.warn(format, supplier.get());
    }
}

/**
 * Warn.
 *
 * @param logger the logger
 * @param supplier the supplier
 */
public void warn(Logger logger, Supplier<Object> supplier) {
    if (logger.isWarnEnabled()) {
        logger.warn(Objects.toString(supplier.get()));
    }
}

private static class LoggerServerHolder {
    private static LoggerServerUtil instance = new LoggerServerUtil();
}
}
