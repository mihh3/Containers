public class Refridgerator extends Container {

    private double power;

    public Refridgerator(String code, String destination, double power) {
        super(code, destination);
        if (power <= 0) {
            throw new IllegalArgumentException("Power must be a positive value");
        }
        this.power = power;
    }

    // Getter for power
    public double getPower() {
        return power;
    }

    // Setter for power
    public void setPower(double power) {
        if (power <= 0) {
            throw new IllegalArgumentException("Power must be a positive value");
        }
        this.power = power;
    }

    // Calculate the charge for refrigerator container
    @Override
    public double getCharge() {
        return 2000 * power;
    }

    // Additional method to provide a basic description of the refrigerator container
    @Override
    public String toString() {
        return "Refridgerator [power=" + power + ", code=" + getCode() + ", destination=" + getDestination() + "]";
    }
}
