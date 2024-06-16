import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class NewShipFrame extends JFrame {

    private JTextField nameField;
    private JTextField capacityField;
    private JButton createShipButton;
    private ChargeCalculator chargeCalculator;
    private ArrayList<Ship> ships;

    public NewShipFrame(ChargeCalculator chargeCalculator, ArrayList<Ship> ships) {
        this.chargeCalculator = chargeCalculator;
        this.ships = ships;

        // Set up the frame
        setTitle("Create New Ship");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components
        nameField = new JTextField();
        capacityField = new JTextField();
        createShipButton = new JButton("Create Ship");

        // Add components to the frame
        add(new JLabel("Ship Name:"));
        add(nameField);
        add(new JLabel("Capacity:"));
        add(capacityField);
        add(createShipButton);

        // Add action listener to the button
        createShipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createShip();
            }
        });

        setVisible(true);
    }

    private void createShip() 
    {
        String name = nameField.getText();
        int capacity = Integer.parseInt(capacityField.getText());
        Ship newShip = new Ship(name, capacity);
        ships.add(newShip);
        chargeCalculator.updateShipList();
        dispose();
    }
}
