package main.java;

public abstract class Animal {
    protected int weight;
    protected String name;
    //

    public Animal(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }

    public abstract void makeSound();

    public int getWeight(){return weight;}

    public void setWeight(int weight){this.weight = weight;}

    public String getName(){return name;}

    public void setName(String name) {this.name = name;}
}