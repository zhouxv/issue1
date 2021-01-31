package com.issue1.demo;

public class testMain {
    public static void main(String[] args) {
        System.out.println("1/2".matches("\\d+/\\d+"));
        System.out.println("z/2".matches("\\d+/\\d+"));
        System.out.println("1/z".matches("\\d+/\\d+"));
        System.out.println("-1/23".matches("\\d+/\\d+"));
        System.out.println("d/d".matches("d+/d+"));
    }
}
