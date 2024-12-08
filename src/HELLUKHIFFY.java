/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HELLUKHIFFY {
    public static void main(String[] args) {
        // Prices for items
        double[] prices = {10.0, 15.0, 20.0, 25.0, 30.0};
        String[] items = {
                "KHIFFY MOCHA",
                "KHIFFY VANILLA",
                "KHIFFY CHOCO",
                "KHIFFY BARAKO",
                "KHIFFY MATCHA"
        };

        // Create main frame
        JFrame frame = new JFrame("HELLUKHIFFY Store");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Welcome to HELLUKHIFFY Store!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Items Panel
        JPanel itemsPanel = new JPanel(new GridLayout(items.length, 1));
        ButtonGroup group = new ButtonGroup();
        JRadioButton[] itemButtons = new JRadioButton[items.length];
        for (int i = 0; i < items.length; i++) {
            itemButtons[i] = new JRadioButton(items[i] + " - $" + prices[i]);
            group.add(itemButtons[i]);
            itemsPanel.add(itemButtons[i]);
        }
        frame.add(itemsPanel, BorderLayout.CENTER);

        // Promo Section
        JTextArea promoArea = new JTextArea();
        promoArea.setEditable(false);
        promoArea.setText("PROMO:\nBuy 3, Take 1 Free!\nTotal Order $100+ gets a Free Drink.\nDISCOUNTS:\n1. Couple Discount - 5%\n2. Birthday Discount - 10%");
        promoArea.setBorder(BorderFactory.createTitledBorder("Promos & Discounts"));
        frame.add(promoArea, BorderLayout.EAST);

        // Bottom Panel (Input and Buttons)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 2));

        JLabel cashLabel = new JLabel("Cash: $");
        JTextField cashField = new JTextField();
        bottomPanel.add(cashLabel);
        bottomPanel.add(cashField);

        JButton buyButton = new JButton("Buy");
        JButton exitButton = new JButton("Exit");
        bottomPanel.add(buyButton);
        bottomPanel.add(exitButton);

        JLabel resultLabel = new JLabel("");
        bottomPanel.add(resultLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add Action Listeners
        buyButton.addActionListener((ActionEvent e) -> {
            int selectedItemIndex = -1;
            for (int i = 0; i < itemButtons.length; i++) {
                if (itemButtons[i].isSelected()) {
                    selectedItemIndex = i;
                    break;
                }
            }
            
            if (selectedItemIndex == -1) {
                resultLabel.setText("Please select an item.");
                return;
            }
            
            double price = prices[selectedItemIndex];
            try {
                double cash = Double.parseDouble(cashField.getText());
                if (cash < price) {
                    resultLabel.setText("Insufficient cash!");
                } else {
                    double change = cash - price;
                    resultLabel.setText("Purchased " + items[selectedItemIndex] + ". Change: $" + change);
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid cash amount.");
            }
        });

        exitButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frame, "Thank you for shopping with us!");
            frame.dispose();
        });

        // Display the GUI
        frame.setVisible(true);
    }
}
