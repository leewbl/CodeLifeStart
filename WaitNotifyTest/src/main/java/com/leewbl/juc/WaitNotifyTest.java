package com.leewbl.juc;

import com.leewbl.juc.util.ElegantConsumer;
import com.leewbl.juc.util.Producer;
import com.leewbl.juc.util.RudeConsumer;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class WaitNotifyTest {

    public static void runRudeConsumeTest() throws InterruptedException {
        Queue<String> queue = new ArrayBlockingQueue<String>(10);
        Producer producer = new Producer(2, queue);
        Thread consumerThread = new Thread(new RudeConsumer(queue, " RudeConsumer"));
        consumerThread.setDaemon(true);
        consumerThread.start();
        Thread producerThread = new Thread(producer);
        producerThread.start();
        producerThread.join();
    }

    public static void runElegantConsumeTest() throws InterruptedException {
        Queue<String> queue = new ArrayBlockingQueue<String>(10);
        Producer producer = new Producer(2, queue);
        Thread consumerThread = new Thread(new ElegantConsumer(queue, " ElegantConsumer"));
        consumerThread.setDaemon(true);
        consumerThread.start();
        Thread producerThread = new Thread(producer);
        producerThread.start();
        producerThread.join();
    }

    public static void main(String[] args) throws InterruptedException {

        runElegantConsumeTest();
//        runRudeConsumeTest();
    }
}
