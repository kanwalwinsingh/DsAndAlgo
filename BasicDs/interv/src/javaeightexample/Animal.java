package javaeightexample;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public static void commonBehavior() {
        System.out.println("All animals need food.");
    }

    private void privateMethod() {
        System.out.println("Private method in abstract class.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    public static void main(String[] args) {
      //  Animal animal = new Animal()
    }
}

