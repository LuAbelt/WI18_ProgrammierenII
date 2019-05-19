package com.dhbw;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        //invokeExample();
        scheduledExample();
    }

    public static void invokeExample(){
        List<DelayedRunner> runners = new ArrayList<>();
        for(int i=0;i<5;i++){
            runners.add(new DelayedRunner((int)(Math.random()*10000)));
        }

        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        try {
            System.out.println("Running invokeAll()");
            results = pool.invokeAll(runners);
            System.out.println("invokeAll() finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Future<Integer> f : results){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("Running invokeAny...");
            pool.invokeAny(runners);
            System.out.println("invokeAny finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

    public static void scheduledExample(){
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(1);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println("Starting scheduled run at time: "+format.format(new Date()));
        scheduledPool.scheduleAtFixedRate(new TimeGivingRunner(1000),2,3,TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping scheduled run at time: "+ format.format(new Date()));
        scheduledPool.shutdown();

        scheduledPool =  Executors.newScheduledThreadPool(1);
        System.out.println("Starting scheduled run with fixed delay at: "+format.format(new Date()));
        scheduledPool.scheduleWithFixedDelay(new TimeGivingRunner(1000),2,3,TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping scheduled run with fixed delay at time: "+ format.format(new Date()));
        scheduledPool.shutdown();
    }
}
