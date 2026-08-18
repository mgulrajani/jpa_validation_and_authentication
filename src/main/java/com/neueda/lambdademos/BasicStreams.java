package com.neueda.lambdademos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BasicStreams {
    static List<Employee> employeeList=
         Arrays.asList(new Employee("Tom Jones", 45), 
                       new Employee("Harry Major", 25),
                       new Employee("Ethan Hardy", 65),
                       new Employee("Nancy Smith", 15),
                       new Employee("Deborah Sprightly", 29));
    public static void main(String args[]){
      Predicate<Employee> predicate =  e -> e.getAge() > 30;

      List<Employee> filteredList = employeeList.stream()
                           
                           .filter(predicate)
                           .collect(Collectors.toList());
                           //method reference 
      filteredList.forEach(System.out::println);
    } 
   }
   