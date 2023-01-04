/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

/**
 *
 * @author Ayush Kumar [Student Number: 2028016]
 */

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class User {
    String name;
    String role;
    String password;
    String filename;
    
    public User(){
        name = "";
        role = "Manager";
        password = "";
        filename = "Login.txt";
    }
    
    public boolean isRegistered(String Name, String Password, String Role){
        boolean registered;
        name = Name;
        password = Password;
        role = Role;
        
        FileWriter writer;
        try{
            writer = new FileWriter(filename, true);
            writer.write(name+","+password+","+role+System.getProperty("line.separator"));
            writer.write("##"+System.getProperty("line.separator"));
            
            registered = true;
            
            writer.flush();
            writer.close();
            writer = null;
            
        }catch(IOException ioe){
            registered = false;
        }
        return registered;
    }
    
    public boolean isUser(String Name, String Password, String Role){
        name = Name;
        password = Password;
        role = Role;
        String records;
        boolean onDatabase = false;
        FileReader reader;
        
        try{
            reader = new FileReader(filename);
            BufferedReader bin = new BufferedReader(reader);
            records = new String();
            while ((records = bin.readLine()) != null){
                String[] split = records.split(",");
                if(name.contentEquals(split[0])&&password.contentEquals(split[1]));
                onDatabase = true;
            }
            bin.close();
            bin = null;
        }catch(IOException ioe){
            onDatabase = false;
        }
        return onDatabase;
    }
    
    public String RoleVerification(String Name, String Password, String Role){
        String hasRole = null;
        name = Name;
        password = Password;
        role = Role;
        String records;
        FileReader reader;
        try{
            reader = new FileReader(filename);
            BufferedReader bin = new BufferedReader(reader);
            records = new String();
            while ((records = bin.readLine()) != null){
                String[] split = records.split(",");
                if(name.contentEquals(split[0])&&password.contentEquals(split[1])){
                    hasRole = split[2];
                }
            }
            bin.close();
            bin = null;
        }catch(IOException ieo){
            hasRole = " ";
        }
        return hasRole;
    }
    
}
