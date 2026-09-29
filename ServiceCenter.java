import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Comparator;

public class ServiceCenter {

    // ArrayList collections
    private ArrayList<Customer> customers;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Mechanic> mechanics;
    private ArrayList<Service> services;

    // HashMap: Vehicle Number -> Vehicle
    private HashMap<String, Vehicle> vehicleMap;

    // TreeMap: Service Cost -> Service
    private TreeMap<Double, Service> servicesByCost;

    public ServiceCenter() {

        customers = new ArrayList<>();
        vehicles = new ArrayList<>();
        mechanics = new ArrayList<>();
        services = new ArrayList<>();

        vehicleMap = new HashMap<>();
        servicesByCost = new TreeMap<>();
    }

    // ================= CUSTOMER CRUD =================

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer searchCustomer(int customerId) {

        for (Customer customer : customers) {

            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    public boolean deleteCustomer(int customerId) {

        Customer customer = searchCustomer(customerId);

        if (customer != null) {
            customers.remove(customer);
            return true;
        }

        return false;
    }

    // ================= VEHICLE =================

    public void addVehicle(Vehicle vehicle) {

        vehicles.add(vehicle);

        vehicleMap.put(
                vehicle.getVehicleNumber(),
                vehicle
        );
    }

    public Vehicle searchVehicle(String vehicleNumber) {

        return vehicleMap.get(
                vehicleNumber.toUpperCase()
        );
    }

    public boolean deleteVehicle(String vehicleNumber) {

        Vehicle vehicle = searchVehicle(vehicleNumber);

        if (vehicle != null) {

            vehicles.remove(vehicle);

            vehicleMap.remove(
                    vehicleNumber.toUpperCase()
            );

            return true;
        }

        return false;
    }

    // ================= MECHANIC =================

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public Mechanic searchMechanic(int mechanicId) {

        for (Mechanic mechanic : mechanics) {

            if (mechanic.getMechanicId() == mechanicId) {
                return mechanic;
            }
        }

        return null;
    }

    // ================= SERVICE =================

    public void addService(Service service)
            throws InvalidServiceException {

        if (service == null) {
            throw new InvalidServiceException(
                    "Invalid service request."
            );
        }

        if (service.getServiceCost() <= 0) {
            throw new InvalidServiceException(
                    "Service cost must be greater than zero."
            );
        }

        services.add(service);

        service.getVehicle()
                .addServiceHistory(service);

        servicesByCost.put(
                service.getServiceCost(),
                service
        );
    }

    public Service searchService(int serviceId) {

        for (Service service : services) {

            if (service.getServiceId() == serviceId) {
                return service;
            }
        }

        return null;
    }

    public boolean deleteService(int serviceId) {

        Service service = searchService(serviceId);

        if (service != null) {

            services.remove(service);

            servicesByCost.remove(
                    service.getServiceCost()
            );

            return true;
        }

        return false;
    }

    // ================= ASSIGN MECHANIC =================

    public boolean assignMechanic(
            int serviceId,
            int mechanicId) {

        Service service = searchService(serviceId);
        Mechanic mechanic = searchMechanic(mechanicId);

        if (service != null && mechanic != null) {

            service.assignMechanic(mechanic);

            return true;
        }

        return false;
    }

    // ================= UPDATE STATUS =================

    public boolean updateServiceStatus(
            int serviceId,
            String status) {

        Service service = searchService(serviceId);

        if (service != null) {

            service.setStatus(status);

            return true;
        }

        return false;
    }

    // ================= SORT BY COST =================

    public void sortServicesByCost() {

        services.sort(
                Comparator.comparingDouble(
                        Service::getServiceCost
                )
        );
    }

    // ================= SORT BY STATUS =================

    public void sortServicesByStatus() {

        services.sort(
                Comparator.comparing(
                        Service::getStatus
                )
        );
    }

    // ================= DISPLAY CUSTOMERS =================

    public void displayCustomers() {

        System.out.println("\n===== CUSTOMERS =====");

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // ================= DISPLAY VEHICLES =================

    public void displayVehicles() {

        System.out.println("\n===== VEHICLES =====");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    // ================= DISPLAY MECHANICS =================

    public void displayMechanics() {

        System.out.println("\n===== MECHANICS =====");

        for (Mechanic mechanic : mechanics) {
            System.out.println(mechanic);
        }
    }

    // ================= DISPLAY SERVICES =================

    public void displayServices() {

        System.out.println("\n===== SERVICES =====");

        for (Service service : services) {
            System.out.println(service);
        }
    }

    // ================= SERVICE HISTORY =================

    public void displayServiceHistory(
            String vehicleNumber) {

        Vehicle vehicle =
                searchVehicle(vehicleNumber);

        if (vehicle == null) {

            System.out.println(
                    "Vehicle not found."
            );

            return;
        }

        System.out.println(
                "\n===== SERVICE HISTORY ====="
        );

        if (vehicle.getServiceHistory().isEmpty()) {

            System.out.println(
                    "No service history available."
            );

            return;
        }

        for (Service service :
                vehicle.getServiceHistory()) {

            System.out.println(service);
        }
    }

    // ================= TREE MAP =================

    public void displayServicesByCost() {

        System.out.println(
                "\n===== SERVICES SORTED BY COST ====="
        );

        for (Service service :
                servicesByCost.values()) {

            System.out.println(service);
        }
    }
}