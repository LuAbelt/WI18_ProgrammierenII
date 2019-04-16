package com.dhbw;

public class Main {

    /**
     * Primitiver Algorithmus um den größten ganzzahligen Teiler einer Zahl zu finden.
     * @param number Übergebene Zahl
     * @return Den größten ganzzahligen Teiler der nicht number ist (Sofern dieser existiert). Handelt es sich bei
     * number um eine Primzahö wird number zurückgegeben
     */
    public static int getGreatestDivisor(int number){
        //Setze Ergebnis auf number, falls kein anderes gefunden wird
        int res = number;
        //Iteriere über alle Zahlen von 2 bis n-1
        for(int i=2;i<number;i++){
            //Teilt unser aktuelles i die number ganzzahlig?
            if(number%i==0){
                //Wenn ja, aktualisiere unser Ergebnis
                res=i;
            }
        }
        //Gib das Ergebnis zurück
        return res;
    }

    /**
     * Erste Optimierung um den größten Teiler zu finden. Hierbei werden alle Zahlen größer als die Hälfte der übergebenen
     * Zahl ignoriert.
     * @param number Zahl zu der der Teiler gefunden werden soll
     * @return Den größten Teiler, der nicht Number ist (Sofern dieser existiert)
     */
    public static int getGreatestDivisorFirstOptimization(int number){
        //Methode fast identisch zur unoptimierten Variante außer, dass nur die Hälfte der Zahlen geprüft wird
        int res = number;
        for(int i=2;i<=number/2;i++){
            if(number%i==0){
                res=i;
            }
        }
        return res;
    }

    /**
     * Zweite Optimierung um den größten Teiler zu finden. Hierbei wird bei der Hälfte begonnen und von dort aus abwärts gezählt
     * @param number Zahl zu der der Teiler ermittelt werden soll
     * @return Den größten ganzzahligen Teiler der Zahö
     */
    public static int getGreatestDivisorSecondOptimization(int number){
        //Beginne bei number/2 und zähle abwärts
        for(int i=number/2;i>1;i--){
            //Wenn unser aktuelles i die Zahl ganzzahlig teilt
            if(number%i==0){
                //Fertig, größter Teiler gefunden
                return i;
            }
        }

        //Es wurde kein Teiler gefunden, gib number zurück (In diesem Fall ist number entweder prim oder negativ)
        return number;
    }

    /**
     * Optimierte Variante zum ermitteln des größten Teilers. Ermittelt den kleinsten Teiler und ermittelt über das Komplementär
     * den größten Teiler
     * @param number Zahl zu dem der Teiler gefunden werden soll
     * @return
     */
    public static int getGreatestDivisorOptimized(int number){
        //Aufgrund der kommutativen Eigenschaften der Multiplikation müssen wir nur alle Zahlen bis zur Wurzel von numbe prüfen
        for(int i=2;i<Math.sqrt(number);i++){
            //Teil unser aktuelles i die number ganzzahlig?
            if(number%i==0){
                //Wenn ja, Ermittle den zweiten Faktor der Multiplikation(=größter Teiler) und gib diesen zurück
                return number/i;
            }
        }

        //Es wurde kein ganzzahliger Teiler gefunden, gib Number zurück
        return number;
    }

    /**
     * Ermittelt ob eine gegebene Zahl prim ist oder nicht
     * @param number Zahl die geprüft werden soll
     * @return true, wenn number prim ist, false sonst
     */
    public static boolean isPrime(int number){
        //Iteriere über alle Zahlen von 2 bis n-1
        for(int i=2;i<number;i++){
            //Teilt unser aktuelles i unsere number ganzzahlig?
            if(number%i==0){
                //Es existiert ein Teiler, number ist also nicht prim. Gib false zurück
                return false;
            }
        }

        //Es wurde kein Teiler gefunden. Gib true zurück
        return true;
    }

    /**
     * Optimierte Variante um zu bestimmen, ob eine Zahl Prim ist
     * @param number Zahl die geprüft werden soll
     * @return True wenn number prim ist
     */
    public static boolean isPrimeFirstOptimization(int number){
        //Der Algorithmus ist identisch zu dem unoptimierten, außer dass lediglich die Hälfte der Zahlen geprüft wird
        for(int i=2;i<=number/2;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * Optimierter Primzahlenalgorithmus
     * @param number
     * @return
     */
    public static boolean isPrimeOptimized(int number){
        //Algorithmus ist identisch zu den beiden anderen Varianten, nur dass deutlich weniger Zahlen geprüft werden
        for(int i=2;i<Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
	int numberWithDivisor = 36;
	int primeNumber = 17;
	System.out.println(getGreatestDivisor(numberWithDivisor));
	System.out.println(getGreatestDivisor(primeNumber));

	System.out.println(getGreatestDivisorFirstOptimization(numberWithDivisor));
	System.out.println(getGreatestDivisorFirstOptimization(primeNumber));

	System.out.println(getGreatestDivisorSecondOptimization(numberWithDivisor));
	System.out.println(getGreatestDivisorSecondOptimization(primeNumber));

	System.out.println(getGreatestDivisorOptimized(numberWithDivisor));
	System.out.println(getGreatestDivisorOptimized(primeNumber));

    System.out.println(isPrime(numberWithDivisor));
    System.out.println(isPrime(primeNumber));

    System.out.println(isPrimeFirstOptimization(numberWithDivisor));
    System.out.println(isPrimeFirstOptimization(primeNumber));

    System.out.println(isPrimeOptimized(numberWithDivisor));
    System.out.println(isPrimeOptimized(primeNumber));

    //Große Primzahl um die Performance der Primzahlalgorithmen darzustellen.
    int largePrime = 179426549;

    System.out.println("Comparing prime number algorithms on very large prime number: "+ largePrime);

    long startTime = System.currentTimeMillis();
    boolean result = isPrime(largePrime);
    long endTime = System.currentTimeMillis();

    System.out.println("First algorithm took " + (endTime-startTime) + " milliseconds and returned " + result);

    startTime = System.currentTimeMillis();
    result = isPrimeFirstOptimization(largePrime);
    endTime = System.currentTimeMillis();

    System.out.println("Second algorithm took " + (endTime-startTime) + " milliseconds and returned " + result);

    startTime = System.currentTimeMillis();
    result = isPrimeOptimized(largePrime);
    endTime = System.currentTimeMillis();

    System.out.println("Third algorithm took " + (endTime-startTime) + " milliseconds and returned " + result);
    }
}
