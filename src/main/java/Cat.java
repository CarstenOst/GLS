package main.java;

public class Cat extends Animal{

    public Cat(int weight, String name) {
        super(weight, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Im a cat, meow");
    }
}
