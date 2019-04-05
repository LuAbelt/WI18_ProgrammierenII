package com.dhbw;

/**
 * Erweiterugn der GenericArrayWrapper Klasse für Arrays, deren Basistyp das Comparable Interface implementiert
 * @param <T> Typ des Araays, muss jetzt das Comparable Interface implementieren
 */
public class GenericComparableArrayWrapper<T extends Comparable<T>> extends GenericArrayWrapper<T>{

    /**
     * Konstruktor, der das Array direkt mit Daten befüllt
     * @param initialData Initiale Daten für das arrays
     */
    public GenericComparableArrayWrapper(T[] initialData){
        dataArray = initialData;
    }

    /**
     * Standardkonstruktor
     * @apiNote Dadurch, dass wir diesen private machen, kann er von außen nicht aufgerufen werden. Dadurch wird sichergestellt,
     * dass dataArray immer Daten enthält
     */
    private GenericComparableArrayWrapper(){
    }

    /**
     * Zählt, wie viele Elemente im Array kleiner als das gegebene Element sind
     * @param element Vergleichselement
     * @return Wie viele Elemente kleiner als das Vergleichselement sind
     */
    public int countNumSmaller(T element){
        //Setze initialen Ergebniszähle auf 0
        int result =0;
        //Iteriere über das gesamte Array
        for(int i=0;i<dataArray.length;i++){
            //Prüfe ob das aktuelle Element kleiner als das Vergleichselement ist
            if(dataArray[i].compareTo(element)<0){
                //Wenn ja, erhöhe den Zähle
                result++;
            }
        }
        //Gib das Ergebnis zurück
        return result;
    }

    /**
     * Zählt, wie viele Elemente im Array größer als das gegebene Element sind
     * @param element Vergleichselement
     * @return Wie viele Elemente größer als das Vergleichselement sind
     */
    public int countNumGreater(T element){
        //Setze Ergebniszähler auf 0
        int result = 0;
        //Iteriere über das gesamte Array
        for(int i=0;i<dataArray.length;i++){
            //Prüfe ob das aktuelle Element größer als das Vergleichselement ist
            if(dataArray[i].compareTo(element)>0){
                //Wenn ja, erhöhe den Zähler
                result++;
            }
        }
        //Gib den Ergebniszähler zurück
        return result;
    }

    /**
     * Überprüft, wie viele Elemente den gleichen Wert wie das Vergleichselement haben
     * @param element Das Vergleichselement
     * @return Wie viele Elemente gleich sind
     */
    public int countNumEqual(T element){
        //Setze Ergebniszähler auf 0
        int result = 0;
        //Iteriere über alle Elemente
        for(int i=0;i<dataArray.length;i++){
            //Überprüfe, ob die Elemente gleich sind
            if(dataArray[i].compareTo(element)==0){
                //Erhöhe den Ergebniszähler
                result++;
            }
        }
        //Gib das Ergebnis zurück
        return result;
    }

    /**
     * Zählt, wie viele Elemente in einer gegebenen Wertebereichs sind
     * @param lowerBound Untere Grenze des Wertebereichs
     * @param upperBound Obere Grenze des Wertebereichs
     * @return Wie viele Elemente im Wertebereich liegen
     */
    public int countNumInRange(T lowerBound, T upperBound){
        //Setze initialen Zähler auf 0
        int result = 0;
        //Iteriere über alle Elemente
        for(T element: dataArray){
            //Überprüfe, ob das aktuelle Element größer als die untere Grenz und kleiner als die obere Grenze ist
            if(element.compareTo(lowerBound)>=0 && element.compareTo(upperBound)<=0){
                //Wenn ja, Erhöhe den Ergebniszähler
                result++;
            }
        }
        //Gib den Ergebniszähler zurück
        return result;
    }

    /**
     * Überprüft, ob alle Elemente im array kleiner als ein gegebener Wert sind
     * @param bound Vergleichswert
     * @return true, wenn alle Elemente kleiner sind, false sonst
     */
    public boolean allSmaller(T bound){
        //Iteriere über alle Elemente im Array
        for(T element: dataArray){
            //Ist das aktuelle Element größer (oder gleich) unserem  Vergleichselement?
            if(element.compareTo(bound)>=0){
                //Gib false zurück
                return false;
            }
        }
        //Kein Element ist größer oder gleich unserem Vergleichselement. Gib true zurück
        return true;
    }

    /**
     * Überprüft ob alle Elemente im Array größer als ein Vergleichswert sind
     * @param bound Vergleichswert
     * @return true, wenn alle Elemente größer sind. false sonst
     */
    public boolean allGreater(T bound){
        //Iteriere über alle Elemente
        for(T element: dataArray){
            //Ist das aktuelle Element kleiner als das Vergleichselement?
            if(element.compareTo(bound)<=0){
                //Wenn ja, gib false zurück
                return false;
            }
        }
        //Kein Element ist kleiner als das Vergleichselement. Gib true zurück
        return true;
    }

    /**
     * Prüft, ob alle Elemente innerhalb eines gegebenen Weertebereichs liegen
     * @param lowerBound Untere Grenze des Wertebereichs
     * @param upperBound Obere Grenze des Wertebereichs
     * @return true, wenn alle Elemente im Wertebereich liegen
     */
    public boolean allInRange(T lowerBound, T upperBound){
        //Iteriere über alle Elemente im array
        for(T element: dataArray){
            //Ist unser Element kleiner als das Minimum oder größer als das Maximum?
            if(element.compareTo(lowerBound)<0||element.compareTo(upperBound)>0){
                //Gib false zurück
                return false;
            }
        }
        return true;
    }

    /**
     * Prüft, ob alle Elemente außerhalb eines gegebenen Weertebereichs liegen
     * @param lowerBound Untere Grenze des Wertebereichs
     * @param upperBound Obere Grenze des Wertebereichs
     * @return true, wenn alle Elemente außerhalb Wertebereich liegen
     */
    public boolean allOutOfRange(T lowerBound, T upperBound){
        //Iteriere über alle Elemente im array
        for(T element: dataArray){
            //Ist unser Element innerhalb des Wertebereichs?
            if(element.compareTo(lowerBound)>=0||element.compareTo(upperBound)<=0){
                //Gib false zurück
                return false;
            }
        }
        return true;
    }

    /**
     * Begrenzt die Werte im Array auf einen bestimmten Wertebereich. Alle Werte außerhalb werden auf das Minimum bzw. Maximum
     * des Wertebereichs gesetzt
     * @param lowerBound Untere Grenze des Wertebereichs
     * @param upperBound Obere Grenze des Wertebereichs
     */
    public void clampData(T lowerBound, T upperBound){
        //Iteriere über alle Elemente im array
        for(int i =0;i<dataArray.length;i++){
            //Ist das aktuelle Element kleiner als unsere untere Grenze?
            if(dataArray[i].compareTo(lowerBound)<0){
                //Setze den Weret auf die untere Grenze
                dataArray[i]=lowerBound;
                continue;
            }
            //Ist das aktuelle Element größer als die obere Grenze?
            if(dataArray[i].compareTo(upperBound)>0){
                //Setze den Wert auf die obere Grenze
                dataArray[i]=upperBound;
            }
        }
    }

    /**
     * Bestimmt das Minimum des arrays
     * @return Den niedrigsten Wert des Arrays
     */
    public T getMinimum(){
        T min;
        //Hat unser array Elemente?
        if(dataArray.length>0){
            //Dann setze das Minimum auf das erste Element im Array
            min = dataArray[0];
        }else{
            //Sonst gib null zurück
            return null;
        }

        //Iteriere über alle Elemente im Array
        for(T element: dataArray){
            //Ist das aktuelle Element kleiner als unser aktuelles Minimum?
            if(element.compareTo(min)<0){
                //Wenn ja, setze das aktuelle Element als neues Minimum
                min=element;
            }
        }
        //Gib das bestimmte Minimum zurück
        return min;
    }

    /**
     * Bestimmt das Maximum des Arrays
     * @return Den höchsten Wert des Arrays
     */
    public T getMax(){
        T max;
        //Prüfe ob unser array Elemente enthält
        if(dataArray.length>0){
            //Wenn ja, setze das aktuelle Maximum auf das erste Element im Array
            max = dataArray[0];
        }else{
            //Sonst gib null zurück
            return null;
        }

        //Iteriere über alle Elemente im Array
        for(T element: dataArray){
            //Ist das aktuelle Element größer als unser aktuelles Maximum
            if(element.compareTo(max)>0){
                //Setze das aktuelle Element als neues Maximum
                max = element;
            }
        }

        //Gib das Maximum zurück
        return max;
    }
}
