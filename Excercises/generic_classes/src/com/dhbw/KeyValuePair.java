package com.dhbw;

public class KeyValuePair<K, V> {
    private K key;
    private V value;

    public void setKey(K newKey){
        key = newKey;
    }

    public K getKey(){
        return key;
    }

    public void setValue(V newValue){
        value=newValue;
    }

    public V getValue(){
        return value;
    }

    public String toString(){
        return String.format("(%s, %s)", key, value);
    }
}
