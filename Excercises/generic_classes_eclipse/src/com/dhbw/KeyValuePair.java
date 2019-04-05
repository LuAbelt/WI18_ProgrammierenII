package com.dhbw;

/**
 * Klasse, um ein Paar zu speichern
 * @param <K> Typ der "key" Variable
 * @param <V> Typ der "value" Variable
 */
public class KeyValuePair<K, V> {

    private K key;
    private V value;

    /**
     * Initialisiert KeyValuePair mit den übergebenen Variablen
     * @param key Initialer Wert für den Key
     * @param value Initialer Wert für den Value
     */
    public KeyValuePair(K key, V value){
        setKey(key);
        setValue(value);
    }

    /**
     * Standard Konstruktor. Nicht von außen sichtbar.
     * @apiNote Dadurch, dass wir den Konstruktor private machen, MUSS ein KeyValueObjekt mit intialem key und value
     * erzeugt werden
     */
    private KeyValuePair(){

    }

    /**
     * Setzt den Wert für key
     * @param newKey Neuer Wert für key
     */
    public void setKey(K newKey){
        key = newKey;
    }

    /**
     * Ruft den Wert von key ab
     * @return Den aktuellen Wert von key
     */
    public K getKey(){
        return key;
    }

    /**
     * Setzt den Wert für value
     * @param newValue Neuer Wert für value
     */
    public void setValue(V newValue){
        value=newValue;
    }

    /**
     * Ruft den aktuellen Wert von value ab
     * @return Den aktuellen Wert von value
     */
    public V getValue(){
        return value;
    }

    /**
     * Überladene toString() Methode für besser Ausgabe auf Konsole
     * @return Das Paar als String
     */
    public String toString(){
        return String.format("(%s, %s)", key, value);
    }
}
