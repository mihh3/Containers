public class Bulk extends Container {

    private int weight;

    public Bulk(String code, String destination, int weight) {
        super(code, destination);
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive value");
        }
        this.weight = weight;
    }

    // Getter for weight
    public int getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive value");
        }
        this.weight = weight;
    }

    // Calculate the charge for bulk container
    @Override
    public double getCharge() {
        return 10 * weight;
    }

    // Additional method to provide a basic description of the bulk container
    @Override
    public String toString() {
        return "Bulk [weight=" + weight + ", code=" + getCode() + ", destination=" + getDestination() + "]";
    }
}
