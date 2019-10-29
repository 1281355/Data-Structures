package com.company;

/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/29 18:56
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)",name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("马云",56));
        arr.addLast(new Student("李彦宏",51));
        arr.addLast(new Student("马化腾",52));
        System.out.println(arr);

    }
}
