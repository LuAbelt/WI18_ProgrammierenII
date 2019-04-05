package com.dhbw;

/**
 * Generische Wrapper-Klasse für Arrays
 * @param <T> Typ des Arrays
 */
public class GenericArrayWrapper<T> {
    /**
     * dataArray ist hier protected, dmait wir es auch in den Unterklassen verwenden können
     */
    protected T[] dataArray;

    /**
     * Erstellt ein neues Wrapper Element mit dem übergebenen Array als Daten
     * @param initialData Initiale Daten für das gehaltene Array
     */
    public GenericArrayWrapper(T[] initialData){
        dataArray=initialData;
    }

    /**
     * Standardkonstruktor
     * @apiNote Standardkonstruktor von außen nicht sichtbar machen, damit sichergestellt wird, dass dataArray mit validen Daten
     * initialisiert wird.
     * Ist in diesem Fall protected, da er durch die Unterklassen benötigt wird
     */
    protected GenericArrayWrapper(){
        dataArray = null;
    }

    /**
     * Ruft das Array ab, das von diesem Wrapper gehalten wird
     * @return Das Array, das verwaltet wird
     */
    public T[] getDataArray(){
        return dataArray;
    }

    /**
     * Setzt das aktuell gehaltene Array
     * @param newData Das array, das durch diese Klass gehalten wird
     */
    public void setDataArray(T[] newData){
        dataArray=newData;
    }

    /**
     * Überprüft, ob ein bestimmtes Element in dem gespeicherten Array vorhanden ist.
     * @param element Das gesuchte Element
     * @return True, wenn das Element enthalten ist, False sonst.
     */
    public boolean contains(T element){
        // Iteriere über alle Elemente vom Typ T in dataArray
        for(T curElement: dataArray) {
            //Prüfe, ob das aktuelle Element mit dem gesuchten übereinstimmt
            //ACHTUNG: Hier unbedingt die .equals() Methode der Object Klasse verwenden
            //Die Verwendung des == Operators führt ggf. zu falschen Ergebnissen
            if(curElement.equals(element)){
                //Das aktuelle Element stimmt mit dem gesuchten überein, gib true zurück
                return true;
            }
        }
        //Wenn über das gesamte Array iteriert wurde und noch nicht true zurück gegeben wurde, enthält das Array das
        //Element nicht.
        return false;
    }

    /**
     * Zählt die Vorkommnisse eines bestimmten Elements in dem Array
     * @param element Das gesuchte Element
     * @return Wie oft das Element im Array vorhanden ist
     */
    public int countOccurences(T element) {
        //Setze Ergebnisvariable auf 0
        int result = 0;
        //Iteriere über alle Elemente in dataArray
        for (T curElement:dataArray) {
            //Prüfe, ob das aktuelle Element mit dem gesuchten übereinstimmt
            //ACHTUNG: Hier unbedingt die .equals() Methode der Object Klasse verwenden
            //Die Verwendung des == Operators führt ggf. zu falschen Ergebnissen
            if (curElement.equals(element)) {
                //Wenn die Elemente übereinstimmen, inkrementiere das Ergebnis
                result++;
            }
        }
        //Gib das Ergebnis zurück
        return result;
    }

    /**
     * Gibt das gespeicherte Array auf der Kommandozeile aus
     */
    public void printData(){
        //Prüfe, ob das Array Elemente enthält
        if(dataArray.length==0) {
            //Meldung, dass das Array leer ist.
            System.out.println("Data array is empty!");
        }

        //Iteriere über alle Elemente im dataArray
        for(T element:dataArray) {
            //Gib jedes Element aus
            System.out.println(element);
        }
    }

    /**
     * Ersetzt das erste Vorkommen eines gesuchten Elements im Array durch einen neuen Wert
     * @param oldElement Das zu ersetzende Element
     * @param newElement Das neue Element
     * @return true, wenn ein Element ersetzt wurde, false sonst
     */
    public boolean replaceFirst(T oldElement, T newElement){
        //Iteriere über alle Element im dataArray, beginne vorn
        for(int i=0;i<dataArray.length;i++){
            //Prüfe, ob das aktuelle Element mit dem gesuchten übereinstimmt
            //ACHTUNG: Hier unbedingt die .equals() Methode der Object Klasse verwenden
            //Die Verwendung des == Operators führt ggf. zu falschen Ergebnissen
            if(dataArray[i].equals(oldElement)){
                //Elemente stimmen überein, ersetze das Element und gib true zurück
                dataArray[i]=newElement;
                return true;
            }
        }
        //Element ist nicht enthalten, gib false zurück
        return false;
    }

    /**
     * Ersetzt das letzte Vorkommen eines gesuchten Elements im Array durch einen neuen Wert
     * @param oldElement Das zu ersetzende Element
     * @param newElement Das neue Element
     * @return true, wenn ein Element ersetzt wurde, false sonst
     */
    public boolean replaceLast(T oldElement, T newElement){
        //Iteriere über alle Element im dataArray, beginne hinten
        for(int i=dataArray.length-1;i>=0;i--){
            //Prüfe, ob das aktuelle Element mit dem gesuchten übereinstimmt
            //ACHTUNG: Hier unbedingt die .equals() Methode der Object Klasse verwenden
            //Die Verwendung des == Operators führt ggf. zu falschen Ergebnissen
            if(dataArray[i].equals(oldElement)){
                //Elemente stimmen überein, ersetze das Element und gib true zurück
                dataArray[i]=newElement;
                return true;
            }
        }
        //Element wurde nicht gefunden, gib false zurück
        return false;
    }

    /**
     * Ersetzt alle Vorkommnisse eines gegebenen Elements mit einem neuen Wert
     * @param oldElement Das zu ersetzende Element
     * @param newElement Das neue Element
     * @return Die Anzahl an ersetzten Elementen
     */
    public int replaceAll(T oldElement, T newElement){
        //Setze Ergebniszähler auf 0
        int result =0;

        //Iteriere über alle Elemente im Array
        for(int i=0;i<dataArray.length;i++) {
            //Prüfe, ob das aktuelle Element mit dem gesuchten übereinstimmt
            //ACHTUNG: Hier unbedingt die .equals() Methode der Object Klasse verwenden
            //Die Verwendung des == Operators führt ggf. zu falschen Ergebnissen
            if(dataArray[i].equals(oldElement)){
                //Elemente stimmen überein, Ersetze Element
                dataArray[i]=newElement;
                //Erhöhe Zähler
                result++;
            }
        }

        //Gebe Zähler zurück
        return result;
    }

    /**
     * Gibt ein bestimmtes Element des Arrays zurück
     * @param index Index des Elements
     * @return Das Element am angegebenen Index
     * @apiNote Durch angeben der "throws" clause wird nach außen kommuniziert, dass diese Methode einen Fehler auslösen kann
     */
    public T getElement(int index) throws ArrayIndexOutOfBoundsException{
        return dataArray[index];
    }

    /**
     * Setzt den Wert eines Elements an einer bestimmten Stelle
     * @param index Index des Elements
     * @param element Neues Element
     * @apiNote Durch angeben der "throws" clause wird nach außen kommuniziert, dass diese Methode einen Fehler auslösen kann
     */
    public void setElement(int index, T element) throws ArrayIndexOutOfBoundsException{
        dataArray[index]=element;
    }

    /**
     * Invertiert die Reihenfolge der Elemente im Array
     */
    public void invertData(){
        //Iteriere das Array bis zur Hälfte
        for(int i=0;i<dataArray.length/2;i++){
            //Speichere das aktuelle Element zwischen
            T temp = dataArray[i];
            //Tausche Element an der Stelle i mit dem i-ten Element von hinten
            dataArray[i] = dataArray[dataArray.length-i-1];
            dataArray[dataArray.length-i-1] = temp;
        }
    }

    /**
     * Überschreibe toString Methode. Delegation an gespeichertes Array
     * @return toString Implementierung von Array
     */
    public String toString(){
        return dataArray.toString();
    }
}
