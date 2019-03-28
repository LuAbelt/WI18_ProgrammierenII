package com.dhbw;

public class GenericComparableArrayWrapper<T extends Comparable> extends GenericArrayWrapper<T>{


    public GenericComparableArrayWrapper(T[] initialData){
        dataArray = initialData;
    }

    public GenericComparableArrayWrapper(){
        dataArray=null;
    }

    public int countNumSmaller(T element){
        int result =0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)<0){
                result++;
            }
        }
        return result;
    }

    public int countNumGreater(T element){
        int result = 0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)>0){
                result++;
            }
        }
        return result;
    }

    public int countNumEqual(T element){
        int result = 0;
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(element)==0){
                result++;
            }
        }
        return result;
    }

    public int countNumInRange(T lowerBound, T upperBound){
        int result = 0;
        for(T element: dataArray){
            if(element.compareTo(lowerBound)>=0 && element.compareTo(upperBound)<=0){
                result++;
            }
        }
        return result;
    }

    public boolean allSmaller(T bound){
        for(T element: dataArray){
            if(element.compareTo(bound)>0){
                return false;
            }
        }
        return true;
    }

    public boolean allGreater(T bound){
        for(T element: dataArray){
            if(element.compareTo(bound)<0){
                return false;
            }
        }
        return true;
    }

    public void clampData(T lowerBound, T upperBound){
        for(int i =0;i<dataArray.length;i++){
            if(dataArray[i].compareTo(lowerBound)<0){
                dataArray[i]=lowerBound;
            }
            if(dataArray[i].compareTo(upperBound)>0){
                dataArray[i]=upperBound;
            }
        }
    }
}
