package com.dhbw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        //KeyValuePair Demo
        KeyValuePair<Integer, Double> pair1 = new KeyValuePair<>(-5,3.14159);
        System.out.println("Key of pair1 is:" + pair1.getKey());
        System.out.println("Value of pair1 is:" + pair1.getValue());
        System.out.println("pair1 is: "+pair1);

        pair1.setKey(42);
        System.out.println("pair1 is: "+pair1);

        pair1.setValue(2.7182818284590);
        System.out.println("pair1 is: "+pair1);

        //GenericArrayWrapper Demo

        //GenericNumberArrayWrapper Demo

        //GenericComparableArrayWrapper Demo

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
