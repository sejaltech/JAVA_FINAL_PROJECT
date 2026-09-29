import java.util.Arrays;

public class Service {

    private int serviceId;
    private String serviceType;
    private double serviceCost;
    private String status;
    private Vehicle vehicle;
    private Mechanic mechanic;

    // Array for spare parts
    private Part[] parts;
    private int partCount;

    public Service(int serviceId, String serviceType,
                   double serviceCost, Vehicle vehicle) {

        if (serviceCost <= 0) {
            throw new IllegalArgumentException(
                    "Service cost must be greater than zero."
            );
        }

        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.vehicle = vehicle;
        this.status = "Pending";

        this.parts = new Part[10];
        this.partCount = 0;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public String getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void assignMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public void addPart(Part part) throws InvalidPartException {

        if (part == null) {
            throw new InvalidPartException("Invalid part.");
        }

        if (partCount >= parts.length) {
            throw new InvalidPartException("Maximum parts limit reached.");
        }

        parts[partCount++] = part;
    }

    public Part[] getParts() {
        return Arrays.copyOf(parts, partCount);
    }

    public double calculatePartCost() {

        double total = 0;

        for (int i = 0; i < partCount; i++) {
            total += parts[i].getTotalPrice();
        }

        return total;
    }

    public double calculateTotalCost() {
        return serviceCost + calculatePartCost();
    }

    @Override
    public String toString() {

        String mechanicName =
                mechanic == null ? "Not Assigned" : mechanic.getName();

        return "Service ID: " + serviceId +
                ", Type: " + serviceType +
                ", Cost: ₹" + serviceCost +
                ", Status: " + status +
                ", Vehicle: " + vehicle.getVehicleNumber() +
                ", Mechanic: " + mechanicName;
    }
}
