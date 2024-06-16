import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ContainerFrame extends JFrame {

    private JButton backButton; // Back button
    private JTextField codeField;
    private JTextField destinationField;
    private JTextField weightField;
    private JTextField powerField;
    private JButton createBulkButton;
    private JButton createRefridgeratorButton;
    private JList<String> shipList;
    private JPanel containerPanel;
    private JPanel centralPanel;
    private ArrayList<Ship> ships;
    private JFrame previousFrame; // Reference to the previous frame

    public ContainerFrame(JFrame previousFrame, ArrayList<Ship> someShips) {
        this.previousFrame = previousFrame;
        ships = someShips;
        
        // Initialize GUI components
        codeField = new JTextField();
        destinationField = new JTextField();
        weightField = new JTextField();
        powerField = new JTextField();
        createBulkButton = new JButton("Create Bulk");
        createRefridgeratorButton = new JButton("Create Refridgerator");
        shipList = new JList<>();
        containerPanel = new JPanel();
        centralPanel = new JPanel();

        // Layout setup
        centralPanel.setLayout(new BorderLayout());

        // Add back button
        backButton = new JButton("Back");
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(backButton);
        centralPanel.add(topPanel, BorderLayout.NORTH);

        containerPanel.setLayout(new GridLayout(5, 2));
        containerPanel.add(new JLabel("Code:"));
        containerPanel.add(codeField);
        containerPanel.add(new JLabel("Destination:"));
        containerPanel.add(destinationField);
        containerPanel.add(new JLabel("Weight (Bulk only):"));
        containerPanel.add(weightField);
        containerPanel.add(new JLabel("Power (Refridgerator only):"));
        containerPanel.add(powerField);
        containerPanel.add(createBulkButton);
        containerPanel.add(createRefridgeratorButton);

        centralPanel.add(new JScrollPane(shipList), BorderLayout.CENTER);
        centralPanel.add(containerPanel, BorderLayout.SOUTH);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Ship ship : ships) {
            model.addElement(ship.getName());
        }
        shipList.setModel(model);

        this.setContentPane(centralPanel);

        // Back button listener
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide ContainerFrame
                previousFrame.setVisible(true); // Show previous frame (ChargeCalculator)
            }
        });

        // Button listener for creating Bulk containers
        createBulkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeField.getText();
                String destination = destinationField.getText();
                String selectedShipName = shipList.getSelectedValue();

                Ship selectedShip = null;
                for (Ship ship : ships) {
                    if (ship.getName().equals(selectedShipName)) {
                        selectedShip = ship;
                        break;
                    }
                }

                if (selectedShip == null) {
                    JOptionPane.showMessageDialog(containerPanel, "Selected ship not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int weight = Integer.parseInt(weightField.getText());
                    Bulk newContainer = new Bulk(code, destination, weight);
                    selectedShip.addContainer(newContainer);
                    JOptionPane.showMessageDialog(containerPanel, "Bulk container created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Clear the text fields
                    codeField.setText("");
                    destinationField.setText("");
                    weightField.setText("");
                    powerField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(containerPanel, "Please enter a valid weight.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Button listener for creating Refridgerator containers
        createRefridgeratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeField.getText();
                String destination = destinationField.getText();
                String selectedShipName = shipList.getSelectedValue();

                Ship selectedShip = null;
                for (Ship ship : ships) {
                    if (ship.getName().equals(selectedShipName)) {
                        selectedShip = ship;
                        break;
                    }
                }

                if (selectedShip == null) {
                    JOptionPane.showMessageDialog(containerPanel, "Selected ship not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double power = Double.parseDouble(powerField.getText());
                    Refridgerator newContainer = new Refridgerator(code, destination, power);
                    selectedShip.addContainer(newContainer);
                    JOptionPane.showMessageDialog(containerPanel, "Refridgerator container created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Clear the text fields
                    codeField.setText("");
                    destinationField.setText("");
                    weightField.setText("");
                    powerField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(containerPanel, "Please enter a valid power value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
     
        
        this.setVisible(true);
        this.setSize(400, 400);
        this.setTitle("Container Creator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}