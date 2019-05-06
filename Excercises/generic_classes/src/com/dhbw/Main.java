package com.dhbw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        //KeyValuePair Demo

        System.out.println("Test");
        KeyValuePair<Integer, Double> pair1 = new KeyValuePair<>(-5,3.14159);
        System.out.println("Key of pair1 is: " + pair1.getKey());
        System.out.println("Value of pair1 is: " + pair1.getValue());
        System.out.println("pair1 is: "+pair1);

        pair1.setKey(42);
        System.out.println("pair1 is: "+pair1);

        pair1.setValue(2.7182818284590);
        System.out.println("pair1 is: "+pair1);

        //GenericArrayWrapper Demo
        String[] stringArray = {"Foo","Bar","Demo","Hello","World","Foo","DHBW","WWI218"};
        String[] otherArray = {"Some","Other","array","for","demonstration"};

        String search = "Foo";

        GenericArrayWrapper<String> stringWrapper = new GenericArrayWrapper<>(stringArray);
        System.out.println("Wrapper now holds:");
        stringWrapper.printData();

        if(stringWrapper.contains(search)){
            System.out.println("Wrapper array contains the value '"+search+"'");
        } else{
            System.out.println("Wrapper array does not contain the value '"+search+"'");
        }

        System.out.println("Wrapper element contains the element '"+search+"' " + stringWrapper.countOccurences(search) + " times!");

        int index = 3;

        System.out.println("The element at index " + index + " is '" + stringWrapper.getElement(index) +"'");

        String newElement = "Java";

        System.out.println("Setting the element at index " + index + " to '" + newElement + "'");
        stringWrapper.setElement(index, newElement);

        System.out.println("Wrapper now holds:");
        stringWrapper.printData();

        System.out.println("Inverting array data...");
        stringWrapper.invertData();

        System.out.println("Wrapper now holds:");
        stringWrapper.printData();

        System.out.println("Replacing array contents");
        stringWrapper.setDataArray(otherArray);

        System.out.println("Wrapper now holds:");
        stringWrapper.printData();

        //GenericNumberArrayWrapper Demo

        Float[] floatArray = {1.f, 3.542f, 3.7f, -2.8965745f, 3f, 5f,12f};
        GenericNumberArrayWrapper<Float> floatWrapper = new GenericNumberArrayWrapper<>(floatArray);

        System.out.println("Float wrapper holds the following elements:");
        floatWrapper.printData();

        System.out.println("The sum of all elements in the wrapper is: " + floatWrapper.getSum());

        System.out.println("The product of all elements in the array is: " + floatWrapper.getProduct());

        System.out.println("The minimum of the array is: " + floatWrapper.getMinimum());

        System.out.println("The maximum of the array is: " + floatWrapper.getMaximum());

        System.out.println("The range of the array is: " + floatWrapper.getRange());

        System.out.println("The average of the array is: " + floatWrapper.getAverage());

        //GenericComparableArrayWrapper Demo

        Character[] charArray = {'c','e','f','#','<','A','&','1','3','7'};
        GenericComparableArrayWrapper<Character> charWrapper = new GenericComparableArrayWrapper<>(charArray);

        System.out.println("The Character wrapper now holds:");
        charWrapper.printData();

        System.out.println("The smallest element is: '" + charWrapper.getMinimum() + "'");

        System.out.println("The greatest element is: '" + charWrapper.getMax() + "'");

        System.out.println("Clamping elements to 'a' and 'z'");
        charWrapper.clampData('a','z');

        System.out.println("Wrapper now holds:");
        charWrapper.printData();

        //StaticListFunctions Demo
        List<Double> dList = Arrays.asList(0.,3.14159,2.7182818284590);
        List<Integer> iList = Arrays.asList(1,2,3,4,5);
        List<Number> out = new ArrayList<>();

        System.out.println("dlist is:");
        StaticListFunctions.printList(dList);
        System.out.println("ilist is:");
        StaticListFunctions.printList(iList);
        System.out.println("Sum of all elements in dList is:" + StaticListFunctions.getSum(dList));
        System.out.println("Sum of all elements in iList is:" + StaticListFunctions.getSum(iList));
        System.out.println("Combining dList and iList...");
        StaticListFunctions.combine(dList,iList,out);
        System.out.println("Combined list is:");
        StaticListFunctions.printList(out);
        System.out.println("Calculating elementwise sum of dList and iList...");
        StaticListFunctions.elementWiseSum(dList,iList,out);
        System.out.println("Elementwise sums are:");
        StaticListFunctions.printList(out);
    }
}
