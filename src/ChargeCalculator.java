import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ChargeCalculator extends JFrame {

    private JButton calculateChargeButton;
    private JPanel panel;
    private ArrayList<Ship> ships;
    private JButton containerFrameOpenButton;
    private JComboBox<String> shipComboBox;
    private JButton createNewShipButton;

    public ChargeCalculator(ArrayList<Ship> someShips) {
        ships = someShips;
        shipComboBox = new JComboBox<>();
        for (Ship ship : ships) {
            shipComboBox.addItem(ship.getName());
        }
        shipComboBox.setPreferredSize(new Dimension(200, 25));

        panel = new JPanel(new BorderLayout());
        calculateChargeButton = new JButton("Calculate Charge");
        containerFrameOpenButton = new JButton("Open Container Creator Window");
        createNewShipButton = new JButton("Create New Ship");

        // Create sub-panel for the combo box and calculate button
        JPanel comboBoxAndButtonPanel = new JPanel();
        comboBoxAndButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        comboBoxAndButtonPanel.add(calculateChargeButton);
        comboBoxAndButtonPanel.add(shipComboBox);

        // Create a panel for the buttons at the bottom
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(containerFrameOpenButton);
        bottomPanel.add(createNewShipButton);

        // Add components to main panel
        panel.add(comboBoxAndButtonPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        this.setContentPane(panel);

        ButtonListener listener = new ButtonListener();
        calculateChargeButton.addActionListener(listener);
        containerFrameOpenButton.addActionListener(listener);
        createNewShipButton.addActionListener(listener);

        this.setVisible(true);
        this.setSize(400, 200); // Adjusted size to better fit the components
        this.setTitle("Charge Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateShipList() {
        shipComboBox.removeAllItems();
        for (Ship ship : ships) {
            shipComboBox.addItem(ship.getName());
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == calculateChargeButton) {
                String selectedShipName = (String) shipComboBox.getSelectedItem();
                Ship selectedShip = null;
                for (Ship ship : ships) {
                    if (ship.getName().equals(selectedShipName)) {
                        selectedShip = ship;
                        break;
                    }
                }
                if (selectedShip != null) {
                    JOptionPane.showMessageDialog(panel, "Total Charge: " + selectedShip.getTotalCharge(),
                            "Charge Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a ship.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == containerFrameOpenButton) {
                setVisible(false); // Hide ChargeCalculator frame
                new ContainerFrame(ChargeCalculator.this, ships);
            } else if (e.getSource() == createNewShipButton) {
                new NewShipFrame(ChargeCalculator.this, ships);
            }
        }
    }

  
}
