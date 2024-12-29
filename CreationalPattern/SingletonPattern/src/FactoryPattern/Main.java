package FactoryPattern;

abstract class Vehicle {
    abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("TwoWheeler");
    }
}

class ThreeWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("ThreeWheeler");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class ThreeWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new ThreeWheeler();
    }
}

class Client {
    private Vehicle vehicle;

    public Client(VehicleFactory vehicleFactory) {
        this.vehicle = vehicleFactory.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory threeWheelerFactory = new ThreeWheelerFactory();
        Client threeWheelerClient = new Client(threeWheelerFactory);
        Vehicle threeWheeler = threeWheelerClient.getVehicle();
        threeWheeler.printVehicle();
    }
}



