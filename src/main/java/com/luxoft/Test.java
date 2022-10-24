package com.luxoft;

public class Test {

    public static void main(String[] args) {
        Footprint footprint = Footprint.create(14, 22, 17, 32, 87, 65, 34, 23);
        boolean res1 = footprint.isClosest(21, 16, 32);
        System.out.println("footprint1 result : " + res1);

        System.out.println("===================================");

        Footprint footprint2 = Footprint.create(55, 34, 55, 33, 65, 34, 65);
        boolean res2 = footprint2.isClosest(21, 16, 32);
        System.out.println("footprint2 result : " + res2);

        System.out.println("===================================");

        Footprint footprint3 = Footprint.create(55, 34, 12, 18, 9, 12, 14, 5, 30);
        boolean res3 = footprint3.isClosest(12, 15, 7);
        System.out.println("footprint3 result : " + res3);

        System.out.println("===================================");

        Footprint footprint4 = Footprint.create(12, 34, 5, 15, 67, 12, 7, 5, 30);
        boolean res4 = footprint4.isClosest(12, 15, 7);
        System.out.println("footprint4 result : " + res4);

    }
}
