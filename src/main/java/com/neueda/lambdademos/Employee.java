package com.neueda.lambdademos;
public class Employee{
    private String name;
    private Integer age;
    public Employee(String name, Integer age){
      this.name=name;
      this.age=age;
    } 
    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name=name;
    } 
    public Integer getAge(){
      return this.age;
    } 
    public void setAge(Integer age){
      this.age=age;
    }  
    public String toString(){
      return "Employee Name:"+this.name
        +"  Age:"+this.age;
    } 
  }