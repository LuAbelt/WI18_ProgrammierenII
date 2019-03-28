package com.dhbw;

public class GenericNumberArrayWrapper<T extends Number> extends GenericArrayWrapper<T> {

    public GenericNumberArrayWrapper(){
        dataArray=null;
    }

    public GenericNumberArrayWrapper(T[] initialData){
        dataArray=initialData;
    }

    public double getSum(){
        double result = 0;
        for(T number: dataArray){
            result+=number.doubleValue();
        }
        return result;
    }

    public double getProduct(){
        double result = 0;
        for(T number: dataArray){
            result*=number.doubleValue();
        }
        return result;
    }
}
