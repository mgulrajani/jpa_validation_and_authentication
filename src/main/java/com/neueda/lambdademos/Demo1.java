package com.neueda.lambdademos;
//SAM -Single Abstract Method
//3 types of functional interfaces
//1. prior to jdk8 , one with jdk8 and one which are custom 

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//1. prior to jdk8 -- Callable, Runnable, Comparator 
//2. with jdk8 -- Predicate, Consumer, Supplier, Function

@FunctionalInterface
interface Calculator{
    int calculate(int a, int b);
}


@FunctionalInterface
interface Printable{
    void print(String message);
    default void print2(){ System.out.println("default printing");};
}
//normally what is the way to use interface in java
//class Printer implements Printable{
//    @Override 



public class Demo1 {
Printable p = (message) -> System.out.println(message);

Printable p2 = (m2)->System.out.println("hi from another implementation"+m2);


Calculator add = (a,b)->a+b;//dont have to create 
Calculator sub = (a,b)->a-b;

public static void main(String[] args) {
    
    Demo1 d = new Demo1();
    d.p.print("hello");
    d.p2.print("hello2");
    System.out.println(d.add.calculate(10, 20));
    System.out.println(d.sub.calculate(10, 20));    
}

}


