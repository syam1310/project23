package org.hotelmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java .sql.*;
public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    JFrame jFrame;

    Login(JFrame jFrame){
         this.jFrame = jFrame;
        getContentPane().setBackground(Color.white);

        setLayout(null);
        setSize(400,300);

        JLabel user= new JLabel ("username");
        user.setBounds(40,20,100,30);
        add (user);


        username =new JTextField();
        username.setBounds(150,20,150,30);
        add(username);


        JLabel pass= new JLabel ("password");
        pass.setBounds(40,70,100,30);
        add (pass);

        password =new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login =new JButton("Login");
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.setBounds(40,150,120,30);
        login.addActionListener(this);
        add(login);

        cancel =new JButton("Cancel");
        cancel.setBackground(Color.black);

        cancel.setForeground(Color.WHITE);
        cancel.setBounds(180,150,120,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/img3.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        setBounds(500,200,600,300);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login) {
            String user =username.getText();
            String pass = password.getText();

            try{
                Conn c = new Conn();

                String query = "select * from login where username = '"+ user +"' and password = '"+ pass
                        +"'" ;


                ResultSet rs= c.st.executeQuery(query);

                if (rs.next()){
                    setVisible(true);
                    new Dashboard(this);

                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource()==cancel){
            setVisible(false);
        }

    }
}
