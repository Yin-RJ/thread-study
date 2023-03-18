package com.yinrj.chapter01.ticket;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yinrongjie
 * @Date 2023/3/18
 * @Name TicketWindowRunnable
 */
@Slf4j
public class TicketWindowRunnable implements Runnable{
    private static final int MAX = 50;

    private int index;

    @Override
    public void run() {
        log.info("线程{}的号码是{}", Thread.currentThread().getName(), index++);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
