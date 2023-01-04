/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

import javax.swing.JTextArea; // This is a library important for the Display method
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ayush Kumar [Student Number: 2028016]
 */
public class Branch {
    // The following establishes the Branch class:
    private String WorkingHours;
    private String SortCode;
    private String Manager;
    private IAddress Address;
    public String filename;
    public String loadname;
    
    public Branch(){
        // This is the assignment of the values:
        WorkingHours = "09:00 - 17:00";
        SortCode = "00-00-00";
        Manager = "TBD";
        Address = new IAddress();
        Address.Edit("Main Bank", "Kingston Lane", 24, "Isambard Complex", "Uxbridge", "UB8 3AA", "London", "UK");
        filename = "Branch.txt";
    }
    
    public void Edit(String newWorkingHours, String newSortCode, String newManager){
        WorkingHours = newWorkingHours;
        SortCode = newSortCode;
        Manager = newManager;
    }
    
    public String ToString(){ 
        // ToString to implement when deploying in the Display method
        return "\n"+WorkingHours+"\n"+SortCode+"\n"+Manager+"\n"+Address.ToString(); 
    }
    
    public void Display(JTextArea jHeadOfficeTextArea){
        jHeadOfficeTextArea.append(ToString());
        //Address.Display(jHeadOfficeTextArea);
    }
    
    public String GetBranchInfo(String WorkingHours, String Manager, String SortCode){
         
         return (WorkingHours + Manager + SortCode);
         
     }
    
    public void SaveToFile(boolean append){ // This is the initialisation for the SaveToFile method:
        try{
            FileWriter writer = new FileWriter(new File (filename), append);
            // BufferedWriter buffered = new BufferedWriter(writer);
            writer.write(Manager+"\n"+SortCode+"\n"+WorkingHours+"\n");
            Address.SaveToFile(writer);
            writer.flush();
            writer.close();
            writer = null;
        }catch(IOException ioe){
            System.out.println("ERROR");
        }
    }
    
    public String LoadFromFile(){ // This is the initialisation for the LoadFromFile method for the file "HeadOfficeBranch.txt":
        String record;
        String InFile = "";
        String[] str;
        ArrayList<String>newStr = new ArrayList();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("HeadOfficeBranch.txt"));
            record = new String();
            record = reader.readLine();
            while(reader.readLine() != null){
                System.out.println(record);
            }
            str = record.split(",");
            for(int i = 3; i < 10; i++){
                newStr.add(str[i]);
        }
            System.out.println("Loading Complete");
            for (int i = 0; i <newStr.size();i++){
                System.out.println(newStr.get(i));
            }
            Address.LoadFromFile("HeadOfficeBranch.txt");
            InFile = record;
            reader.close();
            
        }catch(IOException ioe){
            System.out.println("ERROR!");
        }
        return InFile;
    }
    
}