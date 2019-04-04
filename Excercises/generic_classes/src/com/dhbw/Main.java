package com.dhbw;

import java.util.List;

public class Main{
    private static void combine(List<? super Number> out, List<? extends Number> in1, List<? extends Number> in2){
        out.clear();
        for(Number el: in1){
            out.add(el);
        }

        for(Number el: in2){
            out.add(el);
        }
    }

    public static void main(String[] args) {

    }
}
