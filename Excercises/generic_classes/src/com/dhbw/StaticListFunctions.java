package com.dhbw;

import java.util.List;

public class StaticListFunctions {
    /**
     * Gibt alle Elemente der Liste aus
     * @param data Liste die ausgegeben werden soll
     * @apiNote Hier wird eine unbegrenzte Wildcard verwendet, um Listen eines beliebigen Typs zu erlauben
     */
    public static void printList(List<?> data){
        for(Object o: data){
            System.out.println(o);
        }
    }

    /**
     * Berechnet die Summe für eine beliebige Liste vom Typ Number
     * @param numbers Liste mit Number Elementen
     * @return Die Summe aller Elemente der Liste
     * @apiNote Vergleichbar mit getSum() aus der GenericNumberArrayWrapper Klasse
     */
    public static double getSum(List<? extends Number> numbers){
        double res = 0.;
        for(Number n: numbers){
            res += n.doubleValue();
        }
        return res;
    }

    /**
     * Kombiniert zwei Listen vom Typ Number zu einer einzigen
     * @param in1 Erste Eingabeliste
     * @param in2 Zweite Eingabeliste
     * @param out Ausgabeliste
     */
    public static void combine(List<? extends Number> in1, List<? extends Number> in2, List<? super Number> out){
        //Ausgabeliste leeren
        out.clear();

        //Iteriere n1 und n2 elementweise und füge Elemente der Ausgabeliste hinzu
        for(Number n: in1){
            out.add(n);
        }

        for(Number n: in2){
            out.add(n);
        }
    }

    public static void elementWiseSum(List<? extends Number> in1, List<? extends Number> in2, List<? super Number> out){
        //Ausgabeliste leeren
        out.clear();

        //Iteriere solange, bis die kürzere Liste zuende ist
        for(int i=0;i<Math.min(in1.size(),in2.size());i++){
            //Füge der Ausgabeliste die Summe der Elemente aus der ersten und zweiten Liste hinzu
            out.add(in1.get(i).doubleValue()+in2.get(i).doubleValue());
        }
    }
}
