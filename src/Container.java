public abstract class Container {

    private String code;
    private String destination;
    
    public Container(String code, String destination) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }
        this.code = code;
        this.destination = destination;
    } 
    
    // Getter for code
    public String getCode() {
        return code;
    }
    
    // Setter for code
    public void setCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        this.code = code;
    }
    
    // Getter for destination
    public String getDestination() {
        return destination;
    }
    
    // Setter for destination
    public void setDestination(String destination) {
        if (destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }
        this.destination = destination;
    }
    
    // Abstract method to get the charge
    public abstract double getCharge();
    
    // Additional method to provide a basic description of the container
    @Override
    public String toString() {
        return "Container [code=" + code + ", destination=" + destination + "]";
    }
}
