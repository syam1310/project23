package org.hotelmanagement;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;

    UpdateCheck() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
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
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lblcheckin = new JLabel("Check in Time");
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblpaid.setBounds(30, 240, 100, 20);
        add(lblpaid);

        tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        add(tfpaid);

        JLabel lblpending = new JLabel("Pending amount");
        lblpending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblpending.setBounds(30, 280, 100, 20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 25);
        add(tfpending);

        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30, 340, 100, 30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150, 340, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270, 340, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/check.jpg"));

        int maxWidth = 500; // Maximum width for the image
        int maxHeight = 300; // Maximum height for the image
        Image i2 = i1.getImage();

        int newWidth, newHeight;
        if (i1.getIconWidth() > maxWidth || i1.getIconHeight() > maxHeight) {
            double widthRatio = (double) maxWidth / i1.getIconWidth();
            double heightRatio = (double) maxHeight / i1.getIconHeight();
            if (widthRatio < heightRatio) {
                newWidth = maxWidth;
                newHeight = (int) (i1.getIconHeight() * widthRatio);
            } else {
                newWidth = (int) (i1.getIconWidth() * heightRatio);
                newHeight = maxHeight;
            }
            i2 = i1.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        }

        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 450, 300);
        add(image);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = ccustomer .getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";

            try{

                Conn c = new Conn();
                ResultSet rs = c.st.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposite"));
                }

                ResultSet rs2 =c.st.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price)-
                            Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+ amountpaid);
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()== update){

            String number = ccustomer.getSelectedItem();

            String room= tfroom.getText();
            String name= tfname.getText();
            String checkin = tfcheckin.getText();
            String deposite= tfpaid.getText();

            try{
                Conn c = new Conn();
                c.st.executeUpdate("update customer set room = '"+room+"',name ='"+name+"',checkintime = '"+checkin+"',deposite ='"+deposite+"'where number ='"+number+"' ");

                JOptionPane.showMessageDialog(null,"Data Update Successfully");
                        setVisible(false);
                new Reception();
            }catch(Exception e ){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
