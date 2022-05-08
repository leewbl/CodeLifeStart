package com.leewbl.juc.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
@Slf4j
public class ElegantConsumer implements Runnable{
    private final Queue queue;
    private String consumerName;

    public ElegantConsumer(Queue queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (!queue.isEmpty()) {
                        System.out.println("Consumer" + consumerName + " take message:" + queue.poll());
                    } else {
                        queue.wait();
                    }
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage() ,e);
            }
        }
    }
}
