package com.dhbw;

import java.util.concurrent.Callable;

public class DelayedRunner implements Callable<Integer> {
    private int delay = 1000;

    DelayedRunner(int delay){
        this.delay=delay;
    }

    @Override
    public Integer call() {
        System.out.println(toString() + " was called and has a delay of " + delay + "ms");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(toString()+ " has finished.");
        return delay;
    }
}
