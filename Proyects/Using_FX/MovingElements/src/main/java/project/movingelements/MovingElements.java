/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package project.movingelements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leon
 */
public class MovingElements {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.forEach(System.out::println);
        System.out.println("");

        int position = list.indexOf("e");

        System.out.println("position of e:" + position);
        list.remove(position);
        list.add(position - 1, "e");
        list.forEach(System.out::println);
        System.out.println("");

         position = list.indexOf("e");

        System.out.println("position of e:" + position);
        list.remove(position);
        list.add(position - 1, "e");
        list.forEach(System.out::println);
        System.out.println("");

         position = list.indexOf("e");

        System.out.println("position of e:" + position);
        list.remove(position);
        list.add(position - 1, "e");
        list.forEach(System.out::println);
        System.out.println("");

         position = list.indexOf("e");

        System.out.println("position of e:" + position);
        list.remove(position);
        list.add(position - 1, "e");
        list.forEach(System.out::println);
        System.out.println("");

         position = list.indexOf("e");

        System.out.println("position of e:" + position);
        list.remove(position);
        list.add(position - 1, "e");


    }
}
