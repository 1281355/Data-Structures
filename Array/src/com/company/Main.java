package com.company;


public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 15; i++) {
            array.addFirst(i);
        }
        array.add(0,10);
//
//        array.addFirst(-1);
//        System.out.println(array.get(2));
//        System.out.println(array);
//
//        System.out.println(array.remove(2));
//        System.out.println(array);
//
//        array.removeElement(4);
        System.out.println(array);
    }
}
