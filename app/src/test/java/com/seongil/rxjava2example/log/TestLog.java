package com.seongil.rxjava2example.log;

/**
 * @author seong-il, kim
 * @since 18. 9. 18
 */
public class TestLog {

    public static void log(String msg) {
        String millis = String.valueOf(System.currentTimeMillis());
        String threadName = Thread.currentThread().getName();
        System.out.println(millis + " [" + threadName + "] " + msg);
    }
}
