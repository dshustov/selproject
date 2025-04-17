package org.seltest;

public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{
        System.out.println(new Main().getGreeting());

      //  new MainPage().startPage();
    }
}