package edu.sjsu;

public class Main {
    public static void main(String[] args) {
        boolean result = NameChecker.check(args[0]);

        System.out.println("Result: " + result);
    }
}