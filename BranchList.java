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

/**
 *
 * @author ayushkumar
 */
public class BranchList {
     ArrayList<Branch> Branches;
     private Branch branches;
     public String FileName;
   
    public BranchList() {
        Branches = new ArrayList<Branch>();
        branches = new Branch();
        FileName = "Braches.txt";
        
    }

    public void add(Branch src) {
        Branches.add(src);
    }

    public void remove(Branch src) {
        Branches.remove(src);

    }

    public void remove(String WorkingHours, String Manager, String SortCode) {
        for (int i = 0; i < Branches.size(); i++) {
            if (Branches.get(i).GetBranchInfo(WorkingHours,Manager,SortCode).equals(WorkingHours + Manager + SortCode)) {
                Branches.remove(i);
            }

        }

    }

    public void Display(JTextArea jPersonTextArea) {
        for (int i = 0; i < Branches.size(); i++) {
            Branches.get(i).Display(jPersonTextArea);

        }

    }
    public void ArraySaveToFile(FileWriter awriter){
        for(int i=0; i<Branches.size();i++){
            Branches.get(i).SaveToFile(true);
        }
    }
     public void savetofile(){
        FileWriter awriter;
        try{
            awriter = new FileWriter("Branches.txt", true);
            this.ArraySaveToFile(awriter);
            awriter.flush();
            awriter.close();
            awriter = null;
          
        }catch(IOException ioe){
            System.out.println("Error");
        }
    }

    public void loadfromfile(String Filename) {
        FileReader reader;
        
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            Branch dummyBranch = new Branch();
            while (bin.readLine() != null) {
                dummyBranch.LoadFromFile();
                this.add(dummyBranch);
                dummyBranch = new Branch();
                bin.readLine();
            }
        } catch (IOException ioe) {
            System.out.println("Error");

        }

    }
}
