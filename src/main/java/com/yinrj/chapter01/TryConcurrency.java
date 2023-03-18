package com.yinrj.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * @author yinrongjie
 * @Date 2023/3/15
 * @Name TryConcurrency
 */
public class TryConcurrency {
    private static void browseNews() {
        for (;;) {
            System.out.println("the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (;;) {
            System.out.println("the good music.");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Thread(TryConcurrency::browseNews).start();
        enjoyMusic();
    }
}
