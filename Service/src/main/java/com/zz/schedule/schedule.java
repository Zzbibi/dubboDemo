package com.zz.schedule;

import org.jboss.netty.util.HashedWheelTimer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhangzhen
 * @create 2022/12/17 16:36
 */
public class schedule {

    private static final ScheduledExecutorService EXECUTOR_SERVICE =
            Executors.newScheduledThreadPool(1, new MyThreadFactory());

    public static void main(String[] args) {
        hashWheelTimer();
        //scheduledPool();
    }

    public static void scheduledPool() {
        EXECUTOR_SERVICE.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed delay run...");
            try {
                Thread.sleep(2000);
                System.out.println("sleep 2s...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 3, 3, TimeUnit.SECONDS);

        EXECUTOR_SERVICE.scheduleAtFixedRate(() -> System.out.println("Fixed rate run..."),
                3, 3, TimeUnit.SECONDS);
    }

    public static void hashWheelTimer() {
        HashedWheelTimer timer = new HashedWheelTimer(new MyThreadFactory("test"), 3, TimeUnit.SECONDS);
        timer.newTimeout(t -> System.out.println("TimerTask run..."), 3, TimeUnit.SECONDS);
        timer.newTimeout(t -> System.out.println("TimerTask run..."), 3, TimeUnit.SECONDS);
    }

}
