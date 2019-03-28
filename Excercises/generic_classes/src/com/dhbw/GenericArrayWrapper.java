package com.dhbw;

public class GenericArrayWrapper<T> {
    protected T[] dataArray;

    public GenericArrayWrapper(T[] initialData){
        dataArray=initialData;
    }

    public GenericArrayWrapper(){
        dataArray=null;
    }

    public T[] getDataArray(){
        return dataArray;
    }

    public void setDataArray(T[] newData){
        dataArray=newData;
    }

    public boolean contains(T element){
        for(T curElement: dataArray) {
            if(curElement.equals(element)){
                return true;
            }
        }
        return false;
    }

    public int countOccurences(T element) {
        int result = 0;
        for (T curElement:dataArray) {
            if (curElement.equals(element)) {
                result++;
            }
        }
        return result;
    }

    public void printData(){
        if(dataArray.length==0) {
            System.out.println("Data array is empty!");
        }

        for(T element:dataArray) {
            System.out.println(element);
        }
    }

    public boolean replaceFirst(T oldElement, T newElement){
        for(int i=0;i<dataArray.length;i++){
            if(dataArray[i].equals(oldElement)){
                dataArray[i]=newElement;
                return true;
            }
        }
        return false;
    }

    public boolean replaceLast(T oldElement, T newElement){
        for(int i=dataArray.length-1;i>=0;i--){
            if(dataArray[i].equals(oldElement)){
                dataArray[i]=newElement;
                return true;
            }
        }
        return false;
    }

    public int replaceAll(T oldElement, T newElement){
        int result =0;

        for(int i=0;i<dataArray.length;i++) {
            if(dataArray[i].equals(oldElement)){
                dataArray[i]=newElement;
                result++;
            }
        }

        return result;
    }

    public T getElement(int index){
        if(index>=dataArray.length){
            return null;
        }

        return dataArray[index];
    }

    public boolean setElement(int index, T element){
        if(index>=dataArray.length){
            return false;
        }
        dataArray[index]=element;
        return true;
    }

    public void invertData(){
        for(int i=0;i<dataArray.length/2;i++){
            T temp = dataArray[i];
            dataArray[i] = dataArray[dataArray.length-i-1];
            dataArray[dataArray.length-i-1] = temp;
        }
    }
}
