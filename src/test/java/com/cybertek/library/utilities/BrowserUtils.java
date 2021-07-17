package com.cybertek.library.utilities;

public class BrowserUtils {

    public static void sleep(int second) {

        //1sec = 1000 milli seconds
        //1 * 1000 = 1000

        second *= 1000;
        try {

            Thread.sleep(second);

        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");

        }

    }
}
