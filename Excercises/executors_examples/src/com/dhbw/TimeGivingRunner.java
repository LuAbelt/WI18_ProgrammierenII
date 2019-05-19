package com.dhbw;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TimeGivingRunner implements Runnable {
    private int delay =0;

    TimeGivingRunner(){}

    TimeGivingRunner(int delay){
        this.delay = delay;
    }

    @Override
    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        System.out.println("Runnable was called at time: " + format.format(new Date()));
        System.out.println("Now waiting " + delay + "ms");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable finished at time: "+format.format(new Date()));
    }
}
