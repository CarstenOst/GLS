package main.java;

public class Cat extends Animal implements FastAf{

    public Cat(int weight, String name) {
        super(weight, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Im a cat, meow");
    }

    @Override
    public void fast() {
        System.out.println("Im fast");
    }
}
