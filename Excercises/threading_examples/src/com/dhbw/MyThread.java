package com.dhbw;

/**
 * Eigene Thread Klasse, die nebenläufig die Fibonacci Zahl für 50 berechnet
 */
public class MyThread extends Thread {

    /**
     * Run Methode beschreibt den nebenläufigen Cide
     */
    @Override
    public void run() {
        System.out.println(fib(50));
    }

    /**
     * Berechnet die Fibonacci Zahl eines gegebenen Wertes rekursiv
     * @param n
     * @return
     */
    public long fib(long n){
        if(n<3){
            return 1;
        }
        return fib(n-1)+ fib(n-2);
    }
}
