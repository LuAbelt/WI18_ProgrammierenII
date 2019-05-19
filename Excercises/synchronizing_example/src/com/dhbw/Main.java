package com.dhbw;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //iplusplusExample();
        //concurrentPointAccess();
        //simpleLockExample();
        //tryLockExample();
        synchronizedPointExample();
    }

    private static void synchronizedPointExample() {
        final Point p = new Point();

        Runnable r = ()->{
            int num = new Random().nextInt(1000);

            while(true){
                int xc,yc=0;
                synchronized (p) {
                    p.x = num;
                    p.y = num;
                    xc = p.x;
                    yc = p.y;
                }
                if(xc!=yc){
                    System.out.println("x und y sind nicht gleich!");
                    System.out.println("x="+xc);
                    System.out.println("y="+yc);
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
        t2.stop();
    }

    private static void tryLockExample() {
        final Lock lock = new ReentrantLock();
        Runnable r = () ->{
            int x = new Random().nextInt(5000);
            while(true){
                System.out.println(Thread.currentThread().getName()+ " will das Lock");
                if(lock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " hat das Lock bekommen und wartet " + x + "ms");
                    try {
                        Thread.sleep(x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }else{
                    System.out.println(Thread.currentThread().getName()+ " hat das lock nicht bekommen");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
        t2.stop();
        t3.stop();
    }

    private static void simpleLockExample() {
        final ReentrantLock lock = new ReentrantLock();

        Runnable r = () ->{
            int x = new Random().nextInt(5000);
            while(true){
                System.out.println(Thread.currentThread().getName()+ " will das Lock");
                lock.lock();
                System.out.println(Thread.currentThread().getName()+ " hat das Lock und wartet "+x+"ms");
                try {
                    Thread.sleep(x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
        t2.stop();
        t3.stop();

        //System.out.println(lock.isLocked());
    }

    private static void iplusplusExample() {
        iPlusPlusThread t1 = new iPlusPlusThread();
        iPlusPlusThread t2 = new iPlusPlusThread();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count is now: "+iPlusPlusThread.count);
    }

    private static void concurrentPointAccess(){
        final Point p = new Point();

        Runnable r = ()->{
            int num = new Random().nextInt(1000);

            while(true){
                p.x=num;
                p.y=num;
                int xc = p.x, yc=p.y;

                if(xc!=yc){
                    System.out.println("x und y sind nicht gleich!");
                    System.out.println("x="+xc);
                    System.out.println("y="+yc);
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
        t2.stop();
    }
}
