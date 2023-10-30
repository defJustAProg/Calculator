
package kalkuldahter2;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Kalkuldahter2 {
    
    public static String mode;
    public static String login;
    public static String password;


    public static void main(String[] args) {
        mode = "Anonimous";
        try {
            if(Files.readAllLines(Paths.get("authorization.txt"),StandardCharsets.UTF_8).get(0).subSequence(16,17).equals("0")) {
                new GUI().setVisible(true);  
                new StartFrame().setVisible(true);
            }
            else{
                new Authorization("Authorization");
            }
            
        } catch (IOException e) {
        }     
    }   
}
