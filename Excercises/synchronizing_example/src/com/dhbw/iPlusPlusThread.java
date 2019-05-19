package com.dhbw;

public class iPlusPlusThread extends Thread {
    public static int count=0;
    @Override
    public void run() {
        super.run();
        for(int i=0;i<10000;i++){
            count++;
        }
    }
}
