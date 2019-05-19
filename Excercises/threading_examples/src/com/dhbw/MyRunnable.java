package com.dhbw;

/**
 * Beispiel für eine eigene Klasse, die das Runnable Interface implementiert.
 * Kann einem Thread übergeben werden, um diesen zu erzeugen
 */
public class MyRunnable implements Runnable {
    /**
     * Runnable
     */
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}
