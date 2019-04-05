package com.dhbw;

/**
 * Erweiterung der GenericArrayWrapper Klasse mit extra Methoden für die Number Klasse
 * @param <T> Typ des Arrays. Muss jetzt vom Typ Number sein
 */
public class GenericNumberArrayWrapper<T extends Number> extends GenericArrayWrapper<T> {

    /**
     * Konstruktor von außen nicht sichtbar machen, damit dataArray immer intialisiert wird
     */
    private GenericNumberArrayWrapper(){
    }

    /**
     * Konstruktor, mit dem das gespeicherte Array direkt initialisiert wird.
     * @param initialData Initiale Daten für das array
     */
    public GenericNumberArrayWrapper(T[] initialData){
        dataArray=initialData;
    }

    /**
     * Ermittelt die Summe aller Elemente im gespeicherten Array
     * @return Die Summe aller Elemente als double
     */
    public double getSum(){
        //Setze Ergebnis initial auf 0
        double result = 0;
        //Iteriere über alle Elemente im array
        for(T number: dataArray){
            //Erhöhe das Ergebnis um den doubleValue() des aktuellen Elements
            result+=number.doubleValue();
        }
        //Gib das Ergebnis zurück
        return result;
    }

    /**
     * Ermittelt das Produkt aller Elemente im Array
     * @return Das Produkt der Elemente als double
     */
    public double getProduct(){
        //Setze das Ergebnis initial auf 1
        double result = 1;
        //Iteriere über alle Elemente im Array
        for(T number: dataArray){
            //Multipliziere das Ergebnis mit dem aktuellen Wert
            result*=number.doubleValue();
        }
        //Gib das Ergebnis zurück
        return result;
    }

    /**
     * Ermittelt das Minimum aller im Array gespeicherten Elemente
     * @return Den niedrigsten Wert des Arrays, bzw. NaN wenn das Array leer ist
     */
    public double getMinimum(){
        //Initialisiere das Minimum mit NaN
        double min = Double.NaN;
        //Hat das Array Elemente?
        if(dataArray.length>0) {
            //Wenn ja, setze das Minimum auf den ersten Wert im array
            min = dataArray[0].doubleValue();
        }else{
            //Sonst gib direkt min (NaN) zurück
            return min;
        }

        //Iteriere über alle Elemente im Array
        for(T element: dataArray){
            //Prüfe, ob der aktuelle Wert niedriger ist als unser aktuelles Minimum
            if(element.doubleValue()<min){
                //Wenn ja, dann ist das aktuelle Element das neue Minimum
                min = element.doubleValue();
            }
        }

        //Gib das globale Minimum zurück
        return min;
    }

    /**
     * Ermittelt das Maximum aller Elemente im Array
     * @return Den höchsten Wert des Arrays als double bzw. NaN wenn das Array leer ist
     */
    public double getMaximum(){
        //Initialisiere das Maximum mit NaN
        double max = Double.NaN;

        //Überprüfe ob unser array Elemente hat
        if(dataArray.length>0) {
            //Wenn ja, setze das Maximum auf das erste Element im array
            max = dataArray[0].doubleValue();
        }else{
            //Sonst gib max zurück (NaN)
            return max;
        }

        //Iteriere über alle Elemente im Array
        for(T element: dataArray){
            //Prüfe obh das aktuelle Element größer als unser bisheriges Maximum ist
            if(element.doubleValue()>max){
                //Wenn ja, dann ist das aktuelle Element das neue Maximum
                max = element.doubleValue();
            }
        }

        //Gebe das Maximum zurück
        return max;
    }

    /**
     * Berechne den Durchschnitt aller Elemente im Array
     * @return Das arithmetische Mittel aller Elemente im Array. NaN wenn das Array leer ist
     */
    public double getAverage(){
        //Hier nutzen wir die bereits vorhandene getSum Methode und teilen einfach durch die Anzahl der Elemente
        //Für den Fall, dass das Array leer ist, wird dieser Wert zu NaN
        return getSum()/dataArray.length;
    }

    /**
     * Berechnet die Spannweite des Arrays
     * @return Die Distanz vom niedrigsten zum höchsten Element im Array
     */
    public double getRange(){
        //Hier nutzen wir die bereits vorhandenen getMinimum() und getMaximum() Methoden um Implementierungsaufwand
        //zu sparen
        return getMaximum()-getMinimum();
    }
}
