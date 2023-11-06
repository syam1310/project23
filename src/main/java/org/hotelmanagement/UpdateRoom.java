package org.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfavailable, tfstatus, tfpaid, tfpending;
    JButton check, update, back;

    UpdateRoom() {
        getContentPane().setBackground(Color.white);

        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.blue);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);


        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);


        try {
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from customer ");
            while (rs.next()) {

                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);

        add(tfroom);


        JLabel lblname = new JLabel("Availablity");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblname.setBounds(30, 180, 100, 20);
        add(lblname);

        tfavailable = new JTextField();
        tfavailable.setBounds(200, 180, 150, 25);
        add(tfavailable);

        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);

        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);

 /* JLabel lblpaid = new JLabel ("Amount Paid");
 lblpaid.setFont(new Font ("Tahoma", Font.PLAIN,14));
 lblpaid.setBounds(30,240,100,20);

 add(lblpaid);

 tfpaid = new JTextField();
 tfpaid.setBounds(200,240,150,25);
 add(tfpaid);

 JLabel lblpending = new JLabel ("Pending amount");
 lblpending.setFont(new Font ("Tahoma", Font.PLAIN,14));
 lblpending.setBounds(30,280,100,20);
 add(lblpending);

 tfpending = new JTextField();
 tfpending.setBounds(200,280,150,25);
 add(tfpending);*/


        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30, 300, 100, 30);
        check.addActionListener(this);
        add(check);


        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150, 300, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new
                ImageIcon(ClassLoader.getSystemResource("icons/img4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,
                Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 500, 300);
        add(image);


        setBounds(300, 200, 980, 450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";

            try {
                Conn c = new Conn();
                ResultSet rs = c.st.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));


                }

                ResultSet rs2 = c.st.executeQuery("select * from room where roomnumber = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailable.setText(rs2.getString("availablity"));
                    tfstatus.setText(rs2.getString("cleaning_status"));


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {

            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();


            try {
                Conn c = new Conn();
                c.st.executeUpdate("update room set availablity = '" + available + "',cleaning_status ='" + status + "'where roomnumber = '" + room + "'");

                JOptionPane.showMessageDialog(null, "Data Update Successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();
        }

    }
//    public static void main(String[] args) {
//        new UpdateRoom();
//    }
}

