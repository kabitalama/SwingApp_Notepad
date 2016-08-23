/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.swingApp2.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kabi
 */
public class BrowserUI extends JFrame{
    private JLabel lblURL;
    private JTextField txtURL;
    private JTextArea txtBrowser;
    private JButton btnGo;
    private JScrollPane scBrowser;
    public BrowserUI() {
        setTitle("JFrame Web Browser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        initComponents();
        setVisible(true);
    }
    private void initComponents() {
        lblURL = new JLabel("Enter File Name ");
        txtURL = new JTextField(20);
        txtBrowser = new JTextArea(20, 40);
        scBrowser=new JScrollPane(txtBrowser);
        btnGo = new JButton("GO");
        btnGo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(txtURL.getText());
                    URLConnection conn = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\r\n");
                }
                reader.close();
                txtBrowser.setText(content.toString());
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, ioe.getMessage());
            }
            }
        });
        add(lblURL, 0);
        add(txtURL, 1);
         add(btnGo,2);
        add(scBrowser);
       
    }
}
