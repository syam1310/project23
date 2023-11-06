package org.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    private JLabel welcomeLabel;
    private JButton loginButton;
    private Timer textScrollTimer;
    private int textX;
    private int direction = 1;
    private boolean paused = false;
    private int cycles = 0;
    private final int maxCycles = 3; // Number of times the text will scroll

    public HotelManagementSystem() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/img1.jpg"));
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        welcomeLabel = new JLabel("Welcome to Hotel Management System, please login");
        welcomeLabel.setFont(new Font("serif", Font.BOLD, 30));
        welcomeLabel.setForeground(Color.CYAN);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a panel for centering content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);

        // Add the welcome label to the center panel
        centerPanel.add(welcomeLabel);

        textX = -welcomeLabel.getPreferredSize().width;

        // Create the "Login" button
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("serif", Font.PLAIN, 25));
        loginButton.setForeground(Color.CYAN);
        loginButton.setBackground(Color.LIGHT_GRAY);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(this);

        // Add the login button to the center panel
        centerPanel.add(loginButton);

        // Add the center panel to the frame
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(centerPanel);
        backgroundPanel.add(Box.createVerticalGlue());
        add(backgroundPanel, BorderLayout.CENTER);

        textScrollTimer = new Timer(10, this);
        textScrollTimer.start();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == textScrollTimer) {
            if (!paused) {
                textX += direction;
                if (textX >= getWidth()) {
                    textX = -welcomeLabel.getPreferredSize().width;
                    if (cycles < maxCycles) {
                        cycles++;
                    }
                }
                welcomeLabel.setBounds(textX, welcomeLabel.getY(), welcomeLabel.getPreferredSize().width, welcomeLabel.getPreferredSize().height);
                repaint();
            }
        } else {
            setVisible(true);
            new Login(this);
        }
    }

//    public static void main(int[] arr) {
//
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelManagementSystem();
        });
    }
}
