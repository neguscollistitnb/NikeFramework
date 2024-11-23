package com.automation.nike.tests;

public class Test {

    public static void main(String[] args) {

        /*
        Hello my name is Negus and I work for TITNB and I live in TX and I am 190 years old.
         */
        String name = "Negus";
        String job = "TITNB";
        String state = "TX";
        int age = 190;



        System.out.println("Hello my name is " + name + " and I work for " + job + " and I live in " + state +" and I am " + age + " years old.");
        System.out.printf("Hello my name is %s and I work for %s and I live in %s and I am %s years old." , name , job , state , age );


    }

}
