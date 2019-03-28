package com.dhbw;

public class GenericNumberArrayWrapper<T extends Number> extends GenericArrayWrapper<T> {

    public GenericNumberArrayWrapper(){
        dataArray=null;
    }

    public GenericNumberArrayWrapper(T[] initialData){
        dataArray=initialData;
    }


}
