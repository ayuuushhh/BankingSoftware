/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.time.LocalDate;

/**
 *
 * @author SLL700
 */
public class CustomerList {
    ArrayList<Person> Clients;
    private Person Customers;
    String Filename = "Customers.txt";
    private IAddress cAddress;
    
   

    public CustomerList() {
        Clients = new ArrayList<Person>();
        Customers = new Person();
        this.loadfromfile();        
    }
    
    public void edit(String aFname, String aSname, LocalDate aDOB, LocalDate aCS ){
        Customers.edit(aFname, aSname, aDOB, aCS);
        
    }

    public void add(Person src) {
        Clients.add(src);
    }


    public void remove(String FirstName,String Surname) {
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getName().equals(FirstName)&&Clients.get(i).getSurname().equals(Surname)) {
                //System.out.println(i);
                Clients.remove(i);
            }
        }
        this.savetofileLIST();
        
    }

   
    public void Display(JTextArea jDisplayClientTextArea) {
        for (int i = 0; i < Clients.size(); i++) {
            Clients.get(i).Display(jDisplayClientTextArea);
        }

    }
    
    public void savetofile(){
        FileWriter awriter;
        try{
            awriter = new FileWriter("Customers.txt", true);
            Customers.savetofile(awriter);
            cAddress.SaveToFile(awriter);
            awriter.flush();
            awriter.close();
            awriter = null;
          
        }catch(IOException ioe){
            System.out.println("Error");
        }
    }

    public void loadfromfile() {
        FileReader reader;

        try {
            reader = new FileReader("Customers.txt");
            BufferedReader bin = new BufferedReader(reader);
            
            while (bin.readLine() != null) {
                Person dummyPerson = new Person();
                dummyPerson.loadfromfile(bin);
                this.add(dummyPerson);
            }
        } catch (IOException ioe) {
            System.out.println("Error");

        }

    }
    
    public void search(String FirstName, String Surname, JTextArea jDisplayClientTextArea){
        for(int i=0; i<Clients.size();i++){
            if (Clients.get(i).getName().equals(FirstName)&&Clients.get(i).getSurname().equals(Surname)){
                Clients.get(i).Display(jDisplayClientTextArea);
                jDisplayClientTextArea.setText(Clients.get(i).Display());
                System.out.println("balls");
            }else{
                jDisplayClientTextArea.append("Error!");
            }
        }
    }
    
    public void savetofileLIST(){
        //System.out.println("here");
        for(int i =0;i<Clients.size();i++){
            //System.out.println(Clients.get(i).toString());
            Clients.get(i).savetofile(false);
        }
    }
}