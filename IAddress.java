/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

/**
 *
 * @author Ayush Kumar [Student Number: 2028016]
 */

import javax.swing.JTextArea;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IAddress {
    // The following establishes the attributes of IAddress:
    private String Name;
    private String Street;
    private Integer HouseNo;
    private String HouseName;
    private String Area;
    private String PostCode;
    private String Town;
    private String Country;
    
    public IAddress(){
        // This is to create blank spaces for the attributes:
        Name = "";
        Street = "";
        HouseNo = 0;
        Area = "";
        PostCode = "";
        Town = "";
        Country = "";
    }
    
    public void Edit(String name, String street, int houseNo, String houseName, String area, String postCode, String town, String country){
        Name = name;
        Street = street;
        HouseNo = houseNo;
        HouseName = houseName;
        Area = area;
        PostCode = postCode;
        Town = town;
        Country = country;   
    }
    
    public  String ToString(){
        return Street+"\n"+HouseNo+"\n"+HouseName+"\n"+Area+"\n"+PostCode+"\n"+Town+"\n"+Country;
    }
    
    public void Display(JTextArea jHeadOfficeTextArea){
        jHeadOfficeTextArea.append(Street+"\n"+HouseNo+"\n"+HouseName+"\n"+Area+"\n"+PostCode+"\n"+Town+"\n"+Country);
    }
    
    public void SaveToFile(FileWriter src){
        try{
            src.append(Street+"\n"+HouseNo+"\n"+HouseName+"\n"+Area+"\n"+PostCode+"\n"+Town+"\n"+Country+"\n");
        }catch(IOException ieo){
            System.out.println("SYSTEM ERROR!");
        }
    }
    
    public void LoadFromFile(String filename){
        String records;
        String[] str;
        
        ArrayList<String>newStr = new ArrayList();
        try{
            BufferedReader bin = new BufferedReader(new FileReader("HeadOfficeBranch.txt"));
            records = new String();
            records = bin.readLine();
            while(bin.readLine() != null){
                System.out.println("Records "+records);
            }
            str = records.split(",");
            for(int i = 3; i < 10; i++){
                newStr.add(str[i]);
            }
        }catch(IOException ioe){}
    }
    
    public void loadfromfile(BufferedReader bin){
        try{
            this.Edit(bin.readLine(),bin.readLine(),Integer.valueOf(bin.readLine()),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine(),bin.readLine());
        }catch(IOException ioe){}
    }
}
