import javax.swing.*;
import java.awt.*;

public class VehicleServiceGUI extends JFrame {

    private ServiceCenter serviceCenter;

    private JTextArea outputArea;

    public VehicleServiceGUI(ServiceCenter serviceCenter) {

        this.serviceCenter = serviceCenter;

        setTitle("Vehicle Service Center Management System");

        setSize(900, 600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        createGUI();
    }

    private void createGUI() {

        JPanel mainPanel = new JPanel(
                new BorderLayout(10, 10)
        );

        JLabel title =
                new JLabel(
                        "VEHICLE SERVICE CENTER MANAGEMENT SYSTEM",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        mainPanel.add(
                title,
                BorderLayout.NORTH
        );

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(4, 3, 10, 10)
                );

        JButton addCustomer =
                new JButton("Add Customer");

        JButton addVehicle =
                new JButton("Register Vehicle");

        JButton addMechanic =
                new JButton("Add Mechanic");

        JButton addService =
                new JButton("Create Service");

        JButton searchVehicle =
                new JButton("Search Vehicle");

        JButton searchCustomer =
                new JButton("Search Customer");

        JButton showServices =
                new JButton("Show Services");

        JButton serviceHistory =
                new JButton("Service History");

        JButton updateStatus =
                new JButton("Update Status");

        JButton assignMechanic =
                new JButton("Assign Mechanic");

        JButton generateBill =
                new JButton("Generate Bill");

        JButton clear =
                new JButton("Clear");

        buttonPanel.add(addCustomer);
        buttonPanel.add(addVehicle);
        buttonPanel.add(addMechanic);

        buttonPanel.add(addService);
        buttonPanel.add(searchVehicle);
        buttonPanel.add(searchCustomer);

        buttonPanel.add(showServices);
        buttonPanel.add(serviceHistory);
        buttonPanel.add(updateStatus);

        buttonPanel.add(assignMechanic);
        buttonPanel.add(generateBill);
        buttonPanel.add(clear);

        mainPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        outputArea =
                new JTextArea();

        outputArea.setEditable(false);

        outputArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        mainPanel.add(
                scrollPane,
                BorderLayout.SOUTH
        );

        // Add Customer
        addCustomer.addActionListener(e ->
                addCustomer()
        );

        // Add Vehicle
        addVehicle.addActionListener(e ->
                addVehicle()
        );

        // Add Mechanic
        addMechanic.addActionListener(e ->
                addMechanic()
        );

        // Add Service
        addService.addActionListener(e ->
                addService()
        );

        // Search Vehicle
        searchVehicle.addActionListener(e ->
                searchVehicle()
        );

        // Search Customer
        searchCustomer.addActionListener(e ->
                searchCustomer()
        );

        // Show Services
        showServices.addActionListener(e -> {

            serviceCenter.displayServices();

            outputArea.setText(
                    "Services displayed in terminal.\n"
            );
        });

        // Service History
        serviceHistory.addActionListener(e ->
                serviceHistory()
        );

        // Update Status
        updateStatus.addActionListener(e ->
                updateStatus()
        );

        // Assign Mechanic
        assignMechanic.addActionListener(e ->
                assignMechanic()
        );

        // Generate Bill
        generateBill.addActionListener(e ->
                generateBill()
        );

        clear.addActionListener(e ->
                outputArea.setText("")
        );

        setContentPane(mainPanel);
    }

    private void addCustomer() {

        try {

            String idText =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Customer ID:"
                    );

            if (idText == null) return;

            int id =
                    Integer.parseInt(idText);

            String name =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Customer Name:"
                    );

            String phone =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Phone:"
                    );

            String email =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Email:"
                    );

            if (name == null ||
                    name.trim().isEmpty()) {

                throw new IllegalArgumentException(
                        "Customer name cannot be empty."
                );
            }

            if (phone == null ||
                    phone.length() != 10) {

                throw new IllegalArgumentException(
                        "Phone number must contain 10 digits."
                );
            }

            Customer customer =
                    new Customer(
                            id,
                            name,
                            phone,
                            email
                    );

            serviceCenter.addCustomer(customer);

            outputArea.setText(
                    "Customer added successfully!\n\n" +
                    customer
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void addVehicle() {

        try {

            String number =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Vehicle Number:"
                    );

            String brand =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Brand:"
                    );

            String model =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Model:"
                    );

            String customerIdText =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Customer ID:"
                    );

            if (number == null ||
                    number.trim().isEmpty()) {

                throw new IllegalArgumentException(
                        "Vehicle number cannot be empty."
                );
            }

            int customerId =
                    Integer.parseInt(
                            customerIdText
                    );

            Customer customer =
                    serviceCenter.searchCustomer(
                            customerId
                    );

            if (customer == null) {

                throw new IllegalArgumentException(
                        "Customer not found."
                );
            }

            Vehicle vehicle =
                    new Vehicle(
                            number,
                            brand,
                            model,
                            customer
                    );

            serviceCenter.addVehicle(vehicle);

            outputArea.setText(
                    "Vehicle registered successfully!\n\n" +
                    vehicle
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void addMechanic() {

        try {

            int id =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Mechanic ID:"
                            )
                    );

            String name =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Mechanic Name:"
                    );

            String specialization =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Specialization:"
                    );

            Mechanic mechanic =
                    new Mechanic(
                            id,
                            name,
                            specialization
                    );

            serviceCenter.addMechanic(mechanic);

            outputArea.setText(
                    "Mechanic added successfully!\n\n" +
                    mechanic
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void addService() {

        try {

            int serviceId =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Service ID:"
                            )
                    );

            String type =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Service Type:"
                    );

            double cost =
                    Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Service Cost:"
                            )
                    );

            String vehicleNumber =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Vehicle Number:"
                    );

            Vehicle vehicle =
                    serviceCenter.searchVehicle(
                            vehicleNumber
                    );

            if (vehicle == null) {

                throw new InvalidServiceException(
                        "Vehicle not found."
                );
            }

            Service service =
                    new Service(
                            serviceId,
                            type,
                            cost,
                            vehicle
                    );

            serviceCenter.addService(service);

            outputArea.setText(
                    "Service request created successfully!\n\n" +
                    service
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Service Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void searchVehicle() {

        String number =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Vehicle Number:"
                );

        if (number == null) return;

        Vehicle vehicle =
                serviceCenter.searchVehicle(number);

        if (vehicle != null) {

            outputArea.setText(
                    "Vehicle Found:\n\n" +
                    vehicle
            );

        } else {

            outputArea.setText(
                    "Vehicle not found."
            );
        }
    }

    private void searchCustomer() {

        try {

            int id =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Customer ID:"
                            )
                    );

            Customer customer =
                    serviceCenter.searchCustomer(id);

            if (customer != null) {

                outputArea.setText(
                        "Customer Found:\n\n" +
                        customer
                );

            } else {

                outputArea.setText(
                        "Customer not found."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Customer ID."
            );
        }
    }

    private void serviceHistory() {

        String number =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Vehicle Number:"
                );

        if (number == null) return;

        Vehicle vehicle =
                serviceCenter.searchVehicle(number);

        if (vehicle == null) {

            outputArea.setText(
                    "Vehicle not found."
            );

            return;
        }

        StringBuilder result =
                new StringBuilder();

        result.append(
                "SERVICE HISTORY\n\n"
        );

        for (Service service :
                vehicle.getServiceHistory()) {

            result.append(service)
                    .append("\n");
        }

        outputArea.setText(
                result.toString()
        );
    }

    private void updateStatus() {

        try {

            int serviceId =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Service ID:"
                            )
                    );

            String status =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter New Status:\n" +
                            "Pending / In Progress / Completed"
                    );

            boolean updated =
                    serviceCenter.updateServiceStatus(
                            serviceId,
                            status
                    );

            if (updated) {

                outputArea.setText(
                        "Service status updated successfully."
                );

            } else {

                outputArea.setText(
                        "Service not found."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );
        }
    }

    private void assignMechanic() {

        try {

            int serviceId =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Service ID:"
                            )
                    );

            int mechanicId =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Mechanic ID:"
                            )
                    );

            boolean assigned =
                    serviceCenter.assignMechanic(
                            serviceId,
                            mechanicId
                    );

            if (assigned) {

                outputArea.setText(
                        "Mechanic assigned successfully."
                );

            } else {

                outputArea.setText(
                        "Service or mechanic not found."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input."
            );
        }
    }

    private void generateBill() {

        try {

            int serviceId =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(
                                    this,
                                    "Enter Service ID:"
                            )
                    );

            Service service =
                    serviceCenter.searchService(
                            serviceId
                    );

            if (service == null) {

                throw new Exception(
                        "Service not found."
                );
            }

            Bill bill =
                    new Bill(
                            serviceId,
                            service
                    );

            bill.printBill();

            outputArea.setText(
                    "Bill generated successfully.\n\n" +
                    "Bill ID: " + bill.getBillId() +
                    "\nService Amount: ₹" +
                    bill.getServiceAmount() +
                    "\nParts Amount: ₹" +
                    bill.getPartAmount() +
                    "\nGST: ₹" +
                    bill.getTax() +
                    "\nTotal: ₹" +
                    bill.getTotalAmount()
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Billing Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
