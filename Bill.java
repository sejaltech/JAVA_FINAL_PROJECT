public class Bill {

    private int billId;
    private Service service;
    private double serviceAmount;
    private double partAmount;
    private double tax;
    private double totalAmount;

    public Bill(int billId, Service service) {

        if (service == null) {
            throw new IllegalArgumentException("Service cannot be null.");
        }

        this.billId = billId;
        this.service = service;

        this.serviceAmount = service.getServiceCost();
        this.partAmount = service.calculatePartCost();

        this.tax = (serviceAmount + partAmount) * 0.18;

        this.totalAmount =
                serviceAmount + partAmount + tax;
    }

    public int getBillId() {
        return billId;
    }

    public double getServiceAmount() {
        return serviceAmount;
    }

    public double getPartAmount() {
        return partAmount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void printBill() {

        System.out.println("\n========== SERVICE BILL ==========");
        System.out.println("Bill ID       : " + billId);
        System.out.println("Service ID    : " + service.getServiceId());
        System.out.println("Vehicle       : " +
                service.getVehicle().getVehicleNumber());

        System.out.println("----------------------------------");
        System.out.println("Service Cost  : ₹" + serviceAmount);
        System.out.println("Parts Cost    : ₹" + partAmount);
        System.out.println("GST (18%)     : ₹" + tax);
        System.out.println("----------------------------------");
        System.out.println("TOTAL         : ₹" + totalAmount);
        System.out.println("==================================");
    }
}
