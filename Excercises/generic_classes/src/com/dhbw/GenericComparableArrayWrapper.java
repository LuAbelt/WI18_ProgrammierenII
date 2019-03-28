package com.dhbw;

public class GenericComparableArrayWrapper<T extends Comparable> extends GenericArrayWrapper<T>{


    public GenericComparableArrayWrapper(T[] initialData){
        dataArray = initialData;
    }

    public GenericComparableArrayWrapper(){
        dataArray=null;
    }

    public int getNumSmaller(T element){
        int result =0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)<0){
                result++;
            }
        }
        return result;
    }

    public int getNumGreater(T element){
        int result = 0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)>0){
                result++;
            }
        }
        return result;
    }

    public int getNumEqual(T element){
        int result = 0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)==0){
                result++;
            }
        }
        return result;
    }
}
