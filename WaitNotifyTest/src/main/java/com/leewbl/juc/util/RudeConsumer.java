package com.leewbl.juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;

@Slf4j
public class RudeConsumer implements Runnable{
    private final Queue queue;
    private String consumerName;

    public RudeConsumer(Queue queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (check()) {
                    System.out.println("Consumer" + consumerName + " take message:" + queue.poll());
                }
            }
        }
    }

    private boolean check() {
        log.info("Consumer {} loop check" + consumerName);
        return !queue.isEmpty();
    }
}
