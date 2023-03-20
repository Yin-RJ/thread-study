package com.yinrj.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * @author yinrongjie
 * @Date 2023/3/19
 * @Name Mutex
 */
public class Mutex {
    private final static Object MUTEX = new Object();

    public void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 5; ++i) {
            new Thread(mutex::accessResource).start();
        }
    }
}
