public class Main {

    public static void main(String[] args) {

        ServiceCenter serviceCenter =
                new ServiceCenter();

        // ================= SAMPLE CUSTOMERS =================

        Customer c1 =
                new Customer(
                        101,
                        "Sejal Singh",
                        "9876543210",
                        "sejal@gmail.com"
                );

        Customer c2 =
                new Customer(
                        102,
                        "Rahul Sharma",
                        "9123456780",
                        "rahul@gmail.com"
                );

        serviceCenter.addCustomer(c1);
        serviceCenter.addCustomer(c2);

        // ================= SAMPLE VEHICLES =================

        Vehicle v1 =
                new Vehicle(
                        "MH46AB1234",
                        "Honda",
                        "City",
                        c1
                );

        Vehicle v2 =
                new Vehicle(
                        "MH04CD5678",
                        "Hyundai",
                        "Creta",
                        c2
                );

        serviceCenter.addVehicle(v1);
        serviceCenter.addVehicle(v2);

        // ================= SAMPLE MECHANICS =================

        Mechanic m1 =
                new Mechanic(
                        201,
                        "Amit",
                        "Engine Specialist"
                );

        Mechanic m2 =
                new Mechanic(
                        202,
                        "Rohit",
                        "Brake Specialist"
                );

        serviceCenter.addMechanic(m1);
        serviceCenter.addMechanic(m2);

        // ================= SAMPLE SERVICES =================

        try {

            Service s1 =
                    new Service(
                            301,
                            "Full Service",
                            2500,
                            v1
                    );

            Service s2 =
                    new Service(
                            302,
                            "Brake Service",
                            1800,
                            v2
                    );

            // ================= SAMPLE PARTS =================

            Part p1 =
                    new Part(
                            401,
                            "Engine Oil",
                            1200,
                            1
                    );

            Part p2 =
                    new Part(
                            402,
                            "Oil Filter",
                            500,
                            1
                    );

            Part p3 =
                    new Part(
                            403,
                            "Brake Pad",
                            1800,
                            1
                    );

            s1.addPart(p1);
            s1.addPart(p2);

            s2.addPart(p3);

            // Add services

            serviceCenter.addService(s1);
            serviceCenter.addService(s2);

            // Assign mechanics

            serviceCenter.assignMechanic(
                    301,
                    201
            );

            serviceCenter.assignMechanic(
                    302,
                    202
            );

            // Update status

            serviceCenter.updateServiceStatus(
                    301,
                    "Completed"
            );

            serviceCenter.updateServiceStatus(
                    302,
                    "In Progress"
            );

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        // ================= CONSOLE OUTPUT =================

        serviceCenter.displayCustomers();

        serviceCenter.displayVehicles();

        serviceCenter.displayMechanics();

        serviceCenter.displayServices();

        serviceCenter.displayServicesByCost();

        serviceCenter.displayServiceHistory(
                "MH46AB1234"
        );

        // ================= START GUI =================

        javax.swing.SwingUtilities.invokeLater(() -> {

            VehicleServiceGUI gui =
                    new VehicleServiceGUI(
                            serviceCenter
                    );

            gui.setVisible(true);
        });
    }
}
