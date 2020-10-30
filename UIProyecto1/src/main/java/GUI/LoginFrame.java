package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class LoginFrame extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JLabel userLabel = new JLabel("Nombre de Usuario");
    JLabel passwordLabel = new JLabel("Contraseña");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Iniciar Sesión");
    JButton resetButton = new JButton("Resetear");
    JCheckBox showPassword = new JCheckBox("Mostrar Contraseña");
    
    ImageIcon icon = new ImageIcon("src\\main\\java\\img\\loginP.jpg");
    JLabel Picture = new JLabel(icon);
    Image imagenSinResize = icon.getImage();
    Image ImagenFinal = imagenSinResize.getScaledInstance(250, 450, Image.SCALE_DEFAULT);
    
 
 
    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        
        
        icon = new ImageIcon(ImagenFinal);
        Picture.setIcon(icon);
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 150, 30);
        passwordLabel.setBounds(50, 220, 150, 30);
        userTextField.setBounds(210, 150, 150, 30);
        passwordField.setBounds(210, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds((200-150/2), 300, 150, 30);
        resetButton.setBounds((200-150/2), 340, 150, 30);
        Picture.setBounds(450, 0, 250, 450);
 
    }
 
    public void addComponentsToContainer() {
        

        container.add(Picture);
        
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("johan") && pwdText.equalsIgnoreCase("123")) {
                JOptionPane.showMessageDialog(this, "Inicio de Sesión Aceptado");
                passwordField.setText("");
                userTextField.setText("");
                
                Login.VentanaMenuPrincipal(true);
                Login.VentanaLogin(false);
            } else {
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña inválidos");
            }
 
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
       //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
    }
 
}