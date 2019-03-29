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

    public double getMinimum(){
        double min = Double.NaN;
        if(dataArray.length>0) {
            min = dataArray[0].doubleValue();
        }else{
            return min;
        }

        for(T element: dataArray){
            if(element.doubleValue()<min){
                min = element.doubleValue();
            }
        }

        return min;
    }

    public double getMaximum(){
        double max = Double.NaN;

        if(dataArray.length>0) {
            max = dataArray[0].doubleValue();
        }else{
            return max;
        }

        for(T element: dataArray){
            if(element.doubleValue()>max){
                max = element.doubleValue();
            }
        }

        return max;
    }

    public double getAverage(){
        if(dataArray.length>0){
            return getSum()/dataArray.length;
        }
        return 0.;
    }

    public double getRange(){
        return getMaximum()-getMinimum();
    }
}
