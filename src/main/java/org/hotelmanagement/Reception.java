package org.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {


    JButton newcustomers, rooms, department, allemployee, manageinfo, customers, searchroom, update, roomstatus, pickup, chekout, logout;

    Reception() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        newcustomers = new JButton("New Customer Form");
        newcustomers.setBounds(10, 30, 200, 30);
        newcustomers.setBackground(Color.black);
        newcustomers.setForeground(Color.white);
        newcustomers.addActionListener(this);
        add(newcustomers);


        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);


        department = new JButton("Department");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);


        allemployee = new JButton("All Employees");
        allemployee.setBounds(10, 150, 200, 30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.white);
        allemployee.addActionListener(this);
        add(allemployee);


        customers = new JButton("Customer Info");
        customers.setBounds(10, 190, 200, 30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);

        manageinfo = new JButton("Manager Info");
        manageinfo.setBounds(10, 230, 200, 30);

        manageinfo.setBackground(Color.black);
        manageinfo.setForeground(Color.white);
        manageinfo.addActionListener(this);
        add(manageinfo);

        chekout = new JButton("Checkout");
        chekout.setBounds(10, 270, 200, 30);
        chekout.setBackground(Color.black);
        chekout.setForeground(Color.white);
        chekout.addActionListener(this);
        add(chekout);


        update = new JButton("Update Status");
        update.setBounds(10, 310, 200, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);


        roomstatus = new JButton("Room Status");
        roomstatus.setBounds(10, 350, 200, 30);
        roomstatus.setBackground(Color.black);

        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);

        pickup = new JButton("Pickup Status");
        pickup.setBounds(10, 390, 200, 30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);


        searchroom = new JButton("Search Room");
        searchroom.setBounds(10, 430, 200, 30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);

        logout = new JButton("Logout ");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);

        add(logout);

        ImageIcon i1 = new
                ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);


        setBounds(350, 200, 800, 570);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newcustomers) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Departement();
        } else if (ae.getSource() == allemployee) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource() == manageinfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource() == searchroom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == roomstatus) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource() == pickup) {
            setVisible(false);
            new Pickup();
        } else if (ae.getSource() == chekout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == logout) {
            setVisible(false);

            System.exit(0);
        }
    }

//    public static void main(String[] args) {
//        new Reception();
//
//
//    }
}

