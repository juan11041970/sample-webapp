package com.jda;

import java.awt.*;

public class SwapTest {

    public static void main(String[] args) {

        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);

        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");

        System.out.println("main " + pnt1.hashCode());

        swap(pnt1,pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);

//        int x = 10;
//        int y = 20;
//
//        System.out.println("Before swap: x = " + x + ", y = " + y);
//        swap(10, 20);
//        System.out.println("After swap: x = " + x + ", y = " + y);
//
//        System.out.println("-------------------------------------------");
//        Integer i = new Integer(10);
//        Integer j = new Integer(20);
//        swap(i, j);
//        System.out.println(" i = " + i + " , j = " + j);

    }

    public static void swap(Point pnt1, Point pnt2) {
        pnt1.x = 200;
        pnt1.y = 200;

        System.out.println("swap" + pnt1.hashCode());

        Point temp = pnt1;

        pnt1 = pnt2;
        pnt1.x = 500;
        pnt1.y = 500;

        pnt2 = temp;

        System.out.println("Done in swap()");
    }

    public static void swap(Integer i, Integer j)
    {
        System.out.println("In swap Integer......");
        Integer temp = new Integer(i);

        i = j;
        System.out.println(" i = " + i);
        j = temp;
        System.out.println(" j = " + j);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}


//List list = new LinkedList();
//list.add(new Integer(1));
//Integer i = list.iterator().next(); //compile error
