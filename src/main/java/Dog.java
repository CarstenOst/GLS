package main.java;

public class Dog extends Animal {

    public Dog(int weight, String name) {
        super(weight, name);
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        //  "null instanceof [type]" also returns false
        if (!(o instanceof Dog)) {
            return false;
        }
        // typecast o to Complex so that we can compare data members
        Dog other = (Dog) o;

        // Compare the data members and return accordingly
        return (this.weight == other.getWeight()) && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + this.weight;
        return hash;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog is barking");
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {

    }
}