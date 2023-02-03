package com.company;

public abstract class Animal {
    public void speak() {
        System.out.println("My name is " + getName() + ".");
    }
    abstract public String getName();
}

class Dog extends Animal {
    public String getName() {
        return "Tommy";
    }
    public static void main(String[] args) {
        Animal d = new Dog();
        d.speak();
        d.getName();
    }
}

