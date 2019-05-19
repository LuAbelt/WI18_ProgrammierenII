package com.dhbw;

import java.util.concurrent.Callable;

/**
 * Eigene Callable Klasse, die einem ExecutorService übergeben werden kann
 */
public class MyCallable implements Callable<Integer> {
    /**
     * Die call() MEthode spezifiziert, welcher Code nebenläufig ausgeführt werden soll
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        int res =0;
        for(int i=0;i<=100;i++){
            res +=i;
        }
        return res;
    }
}
