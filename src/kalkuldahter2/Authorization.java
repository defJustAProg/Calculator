/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkuldahter2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Authorization extends javax.swing.JFrame {
     public Authorization(String action) {
        setResizable(false);
        setBounds(0,40,270,220);
        setLayout(null);
        initComponents();
        add(jLabel1);
        add(jLabel2);
        add(jTextField1);
        add(jTextField2);
        add(jButton1);
        setVisible(true); 
        
        
        
        
        
        
        
        
        
        
        
        
        if(action.equals("change")) {
            jButton1.addActionListener((java.awt.event.ActionEvent e) -> {
                if (jTextField1.getText()!="" & jTextField2.getText()!=""){
                    try{
                        FileWriter fileWriter = new FileWriter("authorization.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        List accounts_data = Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8);
                        String str=(String)accounts_data.get(0);
                        short count=1;
                        for(int i=0; i<Double.parseDouble((String) str.subSequence(16,17));i++){

                            if(String.valueOf(accounts_data.get(count+3-1)).substring(6).equals(Kalkuldahter2.login) 
                             & String.valueOf(accounts_data.get(count+4-1)).substring(9).equals(Kalkuldahter2.password)){
                                
                                accounts_data.set(count+3-1,"login "+jTextField1.getText());
                                accounts_data.set(count+4-1,"password "+jTextField2.getText());
                                Files.write(Path.of("authorization.txt"), accounts_data, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
                                bufferedWriter.close();
                                fileWriter.close();
                                Kalkuldahter2.login=jTextField1.getText();
                                Kalkuldahter2.password=jTextField2.getText();
                                dispose();
                                break;
                            }
                            count+=5;
                        }
                    }
                    catch (IOException exp) {
                    } 

                }
            });
        }
        
        
        
        
        
        
        
        
        if(action.equals("confirm to delete")) {
            jButton1.addActionListener((java.awt.event.ActionEvent e) -> {
                if (jTextField1.getText()!="" & jTextField2.getText()!=""){

                                       
                    if(Kalkuldahter2.login.equals(jTextField1.getText()) 
                     & Kalkuldahter2.password.equals(jTextField2.getText())){
                        short count=1;
                        
                        try{
                        List path = Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8);
                        String str=(String)path.get(0);
                        short accounts_count = Short.parseShort((String) str.subSequence(16,17));
                        
                        for(int i=0; i<accounts_count;i++){

                            if(String.valueOf(path.get(count+3-1)).substring(6).equals(jTextField1.getText()) 
                             & String.valueOf(path.get(count+4-1)).substring(9).equals(jTextField2.getText())){
                                
                                path.set(0,"Security flag = "+(--accounts_count));                                
                                path.remove(count+2-1);
                                path.remove(count+2-1);
                                path.remove(count+2-1);
                                path.remove(count+2-1);
                                try{
                                    path.remove(count+2-1);
                                }catch(java.lang.IndexOutOfBoundsException exp){
                                    
                                }
                                
                                try (BufferedWriter bf = Files.newBufferedWriter(Path.of("authorization.txt"),StandardOpenOption.TRUNCATE_EXISTING)) {
                                    bf.close();
                                } 
                                catch (IOException exp) {
                                }
                                
                                
                                Files.write(Path.of("authorization.txt"), path, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
                                
                                Kalkuldahter2.mode = "Anonimous";
                                GUI.jLabel2.setText("Anonimous");
                                dispose();
                                
                                break;
                            }
                            count+=5;
                        }
                    }
                    catch (IOException exp) {
                    } 
                        
                        
                    }
                    
                    
                }
                
            });
        }
        
        
        
        
        
        if(action.equals("confirm")) {
            jButton1.addActionListener((java.awt.event.ActionEvent e) -> {
                if (jTextField1.getText()!="" & jTextField2.getText()!=""){
                    
                    if(Kalkuldahter2.login.equals(jTextField1.getText()) 
                     & Kalkuldahter2.password.equals(jTextField2.getText())){
                                
                        new Authorization("change");
                        dispose();
                    }
                    
                }
                
            });
        }
        
        
        
        
        if(action.equals("Authorization")) {
            jButton1.addActionListener((java.awt.event.ActionEvent e) -> {
                if (jTextField1.getText()!="" & jTextField2.getText()!=""){
                    try{
                        List path = Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8);
                        String str=(String)path.get(0);
                        short count=1;
                        for(int i=0; i<Double.parseDouble((String) str.subSequence(16,17));i++){

                            if(String.valueOf(path.get(count+3-1)).substring(6).equals(jTextField1.getText()) 
                             & String.valueOf(path.get(count+4-1)).substring(9).equals(jTextField2.getText())){

                                //Save prevelige mode of account authorization
                                Kalkuldahter2.mode = String.valueOf(path.get(count+4)).substring(5);
                                Kalkuldahter2.login=String.valueOf(path.get(count+3-1)).substring(6);
                                Kalkuldahter2.password=String.valueOf(path.get(count+4-1)).substring(9);
                                
                                dispose();
                                new GUI().setVisible(true);  
                                GUI.jLabel2.setText(Kalkuldahter2.mode);
                                break;
                            }
                            count+=5;
                        }
                    }
                    catch (IOException exp) {
                    } 

                }
            });
        }
        else if(action.equals("add")) {
            jButton1.addActionListener((java.awt.event.ActionEvent e) -> {
                if (jTextField1.getText()!="" & jTextField2.getText()!=""){
                    try{
                        FileWriter fileWriter = new FileWriter("authorization.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        List accaunts_list = Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8);
                        String str=(String)accaunts_list.get(0);
                        int accounts_count =  (int) Double.parseDouble((String) str.subSequence(16,17));
                        int count=3+5*accounts_count;
                        
                         accounts_count++;
                            accaunts_list.set(0,"Security flag = "+accounts_count);
                            Files.write(Path.of("authorization.txt"), accaunts_list, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
                            bufferedWriter.newLine();
                            bufferedWriter.write("account "+accounts_count);
                            bufferedWriter.newLine();
                            bufferedWriter.write("login "+jTextField1.getText());
                            bufferedWriter.newLine();
                            bufferedWriter.write("password "+jTextField2.getText());
                            bufferedWriter.newLine();
                            try{
                            if(jTextField1.getText().subSequence(0, 5).equals("Admin"))
                                bufferedWriter.write("mode Default mode");
                            }
                            catch (IndexOutOfBoundsException exp){
                                bufferedWriter.write("mode Protected mode");
                            }
                            
                        bufferedWriter.close();
                        fileWriter.close();
                        dispose();
                    }
                    catch (IOException exp) {
                        exp.printStackTrace();
                    } 

                }
            }); 
        }
        
        
        
        
        
    }
     
     
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel("Логин:");
        jLabel1.setBounds(60,40,50,20);
        jLabel2 = new javax.swing.JLabel("Пароль:");
        jLabel2.setBounds(60,70,50,20);
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setBounds(130,40,80,20);
        jTextField2 = new javax.swing.JTextField();
        jTextField2.setBounds(130,70,80,20);
        jButton1 = new javax.swing.JButton("Войти");
        jButton1.setBounds(90,110,80,20);
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     }
     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
