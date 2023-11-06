package org.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckouttime;
    JButton checkout, back;

    Checkout() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300, 200, 800, 400);
        setVisible(true);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);


        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 30);

        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);

        add(ccustomer);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 30);

        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);

        add(lblroomnumber);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);

        add(lblcheckin);


        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 100, 30);


        add(lblcheckintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);

        add(lblcheckout);

        lblcheckouttime = new JLabel();
        lblcheckouttime.setBounds(200, 130, 100, 30);

        add(lblcheckouttime);


        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150, 230, 100, 30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);


        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);


        try {
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from customer ");
            while (rs.next()) {

                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon i4 = new
                ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250,
                Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250);
        add(image);


        setBounds(300, 200, 800, 400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availablity = 'Available' where roomnumber = '" + lblroomnumber.getText() + "'";
            try {
                Conn c = new Conn();

                c.st.executeUpdate(query1);
                c.st.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "checkout done");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            setVisible(false);
            new Reception();
        }
    }

//    public static void main(String[] args) {
//        new Checkout();
//    }
}