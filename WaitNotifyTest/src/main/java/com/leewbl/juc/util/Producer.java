package com.leewbl.juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Producer implements Runnable{
    private int duration = 0;
    private final Queue<String> queue;

    public Producer(int duration, Queue<String> queue) {
        this.duration = duration;
        this.queue = queue;
    }

    private String simulation(int message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(duration);
        return "User:" + message + " requesting.";
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (queue) {
                try {
                    String request = simulation(i);
                    log.info("Producer offer request ==> " + request);
                    queue.offer(request);
                    queue.notifyAll();
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            }
            try { // monitor different user
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
