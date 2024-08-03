package javaeightexample;

public interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Vehicle stopped.");
    }

    static void commonFeature() {
        System.out.println("All vehicles have wheels.");
    }

    private void privateMethod() {
        System.out.println("Private method in interface.");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    public static void main(String[] args) {
        //Vehicle vehicle = new V
    }
}
