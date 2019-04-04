package com.dhbw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        //KeyValuePair Demo

        //GenericArrayWrapper Demo

        //GenericNumberArrayWrapper Demo

        //GenericComparableArrayWrapper Demo

        //StaticListFunctions Demo
        List<Double> dList = Arrays.asList(0.,3.14159,2.7182818284590);
        List<Integer> iList = Arrays.asList(1,2,3,4,5);
        List<Number> out = new ArrayList<>();

        StaticListFunctions.printList(dList);
        StaticListFunctions.printList(iList);
        StaticListFunctions.combine(dList,iList,out);
        StaticListFunctions.printList(out);
        StaticListFunctions.elementWiseSum(dList,iList,out);
        StaticListFunctions.printList(out);
    }
}
