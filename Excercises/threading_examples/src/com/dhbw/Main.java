package com.dhbw;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
	// write your code here
        callableExample();
    }

    /**
     * Beispielmethode zur Verwendung von Interrupt bei Threads
     * @throws InterruptedException
     */
    public static void interruptExample() throws InterruptedException {
        //Erstelle neuen Thread als anonyme Klasse
        Thread t = new Thread(){

            @Override
            public void run() {
                //Run Methode läuft in einer Dauerschleife, und prüft, ob von außen das interrupted Flag gesetzt wurde
                while(!isInterrupted()) {
                    //Textausgabe damit sichtbar ist, ob der Thread noch läuft
                    System.out.println("Running...");

                    try {
                        //Wartezeit um Ausgabe zu verlangsamen
                        Thread.sleep(500);
                    //Ausnahme wird abgefangen  da interrupt sehr wahrscheinlich während des Sleeps auftriit
                    } catch (InterruptedException e) {
                        //Manuell interrupt auslösen, da die interrupted flag durch auslösen der Ausnahme zurückgesetzt wird
                        interrupt();
                        System.out.println("Exception abgefangen");
                    }
                }
            }
        };
        //Thread starten
        t.start();
        //2 Sekunden warten
        Thread.sleep(2000);
        //Thread unterbrechen
        t.interrupt();
        System.out.println("Ende");
    }

    /**
     * Beispielmethode zur Verwendung von Join
     * @throws InterruptedException
     */
    public static void joinExample() throws InterruptedException {
        //Neuen JoinThread erstellen
        JoinThread t = new JoinThread();
        //Thread erstellen
        t.start();
        //Warten bis die Run Methode beendet ist und der res Wert gesetzt wurde
        //Wird das join auskommentiert, wird 0 ausgegeben anstatt 2
        t.join();
        System.out.println(t.res);
    }

    /**
     * Beispielmethode zur Verwendung von Executor
     * @throws InterruptedException
     */
    public static void executorExample() throws InterruptedException {
        //Neuen Thread Pool erstellen
        ExecutorService pool = Executors.newCachedThreadPool();
        //Zwei runnables definieren (über Lambda Expressions) die den Namen des aktuellen Threads ausgeben
        Runnable r1 = ()->{
            System.out.println("A1 "+Thread.currentThread().getName());
            System.out.println("A2 "+Thread.currentThread().getName());
        };

        Runnable r2 = ()->{
            System.out.println("B1 "+Thread.currentThread().getName());
            System.out.println("B2 "+Thread.currentThread().getName());
        };

        //Beide runnables in den pool zur bearbeitung geben
        pool.submit(r1);
        pool.submit(r2);

        //Warten
        Thread.sleep(500);

        //Runnables erneut starten
        //ZU beobachten ist, dass die Namen der Threads identisch sind zu den im ersten Anlauf verwendeten
        pool.submit(r1);
        pool.submit(r2);

        //Pool stoppen, damit die Methode beendet wird
        pool.shutdown();
    }

    /**
     * Beispiel für die Verwendung von Callables zusammen mit Thread pools
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void callableExample() throws ExecutionException, InterruptedException {
        //Erstellen eines neuen Thread pools
        ExecutorService pool = Executors.newCachedThreadPool();
        //Durch submit der Callable in den Thread pool wird ein future Objekt zurück gegeben
        Future<Integer> f = pool.submit(new MyCallable());
        //Get wartet bis der nebenläufige Code abgeschlossen ist und gitb dann das Ergebnis zurück
        System.out.println(f.get());
    }


    public static long fib(long n){
        if(n<3){
            return 1;
        }
        return fib(n-1)+ fib(n-2);
    }
}
