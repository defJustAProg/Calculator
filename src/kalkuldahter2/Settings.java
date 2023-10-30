/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkuldahter2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Settings extends javax.swing.JFrame {
    public Settings() {
        setResizable(false);
        setBounds(0,40,380,190);
        setLayout(null);
        initComponents();
        setVisible(true); 
        
        
        jButton1.addActionListener((java.awt.event.ActionEvent e) -> { 
            if(Kalkuldahter2.mode.equals("Default mode") |
               Kalkuldahter2.mode.equals("Anonimous")) {
                new Authorization("add");
            }
        });
        
        
        
        
        jButton2.addActionListener((java.awt.event.ActionEvent e) -> { 
            if(Kalkuldahter2.mode.equals("Default mode")) {
                new Authorization("confirm");
            }
        });
        
        
        
        
        jButton3.addActionListener((java.awt.event.ActionEvent e) -> { 
            new Authorization("confirm to delete");
        });
        
        
        
        
        if(Kalkuldahter2.mode.equals("Default mode")) {
            jComboBox1.setEditable(true);

            try{
                List path = Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8);
                String str=(String)path.get(0);
                short count=1;
                for(int i=0; i<Double.parseDouble((String) str.subSequence(16,17));i++){
                    jComboBox1.addItem(String.valueOf(path.get(count+3-1)).substring(6));
                    count+=5;
                }
            }
            catch (IOException exp) {
            }     
                        
        }
    }
    
    
    
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel("Учетная запись");
        jLabel1.setBounds(10,20,100,20);
        add(jLabel1);
        jButton1 = new javax.swing.JButton("Новая");
        jButton1.setBounds(110,50,240,20);
        add(jButton1);
        jButton2 = new javax.swing.JButton("Сменить данные авторизации");
        jButton2.setBounds(110,80,240,20);
        add(jButton2);
        jButton3 = new javax.swing.JButton("Удалить учетную запись");
        jButton3.setBounds(110,110,240,20);
        add(jButton3);
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setBounds(110,20,240,20);
        add(jComboBox1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
   
     }
   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    static javax.swing.JComboBox<String> jComboBox1;
}
