public class Mechanic {

    private int mechanicId;
    private String name;
    private String specialization;

    public Mechanic(int mechanicId, String name, String specialization) {
        this.mechanicId = mechanicId;
        this.name = name;
        this.specialization = specialization;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Mechanic ID: " + mechanicId +
                ", Name: " + name +
                ", Specialization: " + specialization;
    }
}
