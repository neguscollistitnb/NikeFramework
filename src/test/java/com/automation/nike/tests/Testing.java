package com.automation.nike.tests;

public class Testing {

    public static void main(String[] args) {

        System.out.println(searchCharacter("hello world", 'l'));
    }


    public static int searchCharacter(String str , char letter){

        int count = 0;
        int i = 0;

        while(i < str.length()){
            if (str.charAt(i) == letter){
                count++;
            }

            i++;
        }

        return count;

    }



}
