package com.jda;

import java.awt.*;

public class SwapTest {

    public static void main(String[] args) {

        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);

        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");

        swap(pnt1,pnt2);

        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);

    }

    public static void swap(Point pnt1, Point pnt2) {
        pnt1.x = 100;
        pnt1.y = 100;

        Point temp = pnt1;

        pnt1 = pnt2;
        pnt2 = temp;

        System.out.println("Done in swap()");
    }
}
