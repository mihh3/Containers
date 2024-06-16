import java.util.ArrayList;

public class Ship {

    private ArrayList<Container> containers = new ArrayList<>();
    private String name;
    private int capacity;

    public Ship(String name, int capacity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive value");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public void addContainer(Container aContainer) {
        if (containers.size() < capacity) {
            containers.add(aContainer);
        } else {
            System.out.println("Sorry, the ship is full!");
        }
    }

    public double getTotalCharge() {
        double totalCharge = 0;
        for (Container container : containers) {
            totalCharge += container.getCharge();
        }
        return totalCharge;
    }

    public String getName() {
        return name;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter for capacity
    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive value");
        }
        this.capacity = capacity;
    }

    // Getter for containers list
    public ArrayList<Container> getContainers() {
        return new ArrayList<>(containers);
    }

    // Override toString method
    @Override
    public String toString() {
        return "Ship [name=" + name + ", capacity=" + capacity + ", total charge=" + getTotalCharge() + "]";
    }
}
