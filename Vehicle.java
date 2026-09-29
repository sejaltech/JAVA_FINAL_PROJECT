import java.util.LinkedList;

public class Vehicle {

    private String vehicleNumber;
    private String model;
    private String brand;
    private Customer owner;

    private LinkedList<Service> serviceHistory;

    public Vehicle(String vehicleNumber, String brand, String model, Customer owner) {

        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be empty.");
        }

        this.vehicleNumber = vehicleNumber.toUpperCase();
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.serviceHistory = new LinkedList<>();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Customer getOwner() {
        return owner;
    }

    public LinkedList<Service> getServiceHistory() {
        return serviceHistory;
    }

    public void addServiceHistory(Service service) {
        serviceHistory.add(service);
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + vehicleNumber +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Owner: " + owner.getName();
    }
}
