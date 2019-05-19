package com.dhbw;

public class SynchronizedIPlusPlusThread extends Thread {
    public static Integer count =0;

    @Override
    public void run() {
        synchronized (count) {
            for (int i = 0; i < 10000; i++) {
                synchronized (count) {
                    count++;
                }
            }
        }
    }
}
