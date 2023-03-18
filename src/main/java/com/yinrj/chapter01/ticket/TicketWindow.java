package com.yinrj.chapter01.ticket;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟银行大厅的出号机器
 * @author yinrongjie
 * @Date 2023/3/18
 * @Name TicketWindow
 */
@Slf4j
public class TicketWindow extends Thread{
    // 柜台名称
    private final String name;

    // 最多受理的业务数量
    private static final int MAX = 50;

    // 使用static进行修饰在一定程度上做到了多线程下共享资源的唯一性
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    public TicketWindow(Runnable task, String name) {
        super(task);
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            log.info("柜台{} 当前的号码是{}", name, (index++));
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable runnable = new TicketWindowRunnable();

        TicketWindow window1 = new TicketWindow(runnable, "一号机器");
        window1.start();

        TicketWindow window2 = new TicketWindow(runnable, "二号机器");
        window2.start();

        TicketWindow window3 = new TicketWindow(runnable, "三号机器");
        window3.start();

        TicketWindow window4 = new TicketWindow(runnable, "四号机器");
        window4.start();
    }
}
