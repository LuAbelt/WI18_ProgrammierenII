package com.dhbw;

/**
 * Eigene Thread Klasse um die Join Funktionalität zu demonstieren
 */
public class JoinThread extends Thread {
    /**
     * Ergebnisvariable
     */
    public int res = 0;


    @Override
    /**
     * Ergebnisvariable wird in der run() Methode verändert
     */
    public void run() {
        res =2;
    }
}
