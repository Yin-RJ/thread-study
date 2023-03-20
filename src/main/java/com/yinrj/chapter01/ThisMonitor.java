package com.yinrj.chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author yinrongjie
 * @Date 2023/3/19
 * @Name ThisMonitor
 */

@Slf4j
public class ThisMonitor {
    public synchronized void method1() {
        log.info("Thread {} enter the method1.", Thread.currentThread().getName());
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void method2() {
        log.info("Thread {} enter the method2.", Thread.currentThread().getName());
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        ThisMonitor thisMonitor1 = new ThisMonitor();
        new Thread(thisMonitor::method1).start();
        new Thread(thisMonitor1::method2).start();
    }
}
