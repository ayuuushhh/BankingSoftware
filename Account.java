/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JTextArea;

/**
 *
 * @author Ayush Kumar
 */
public class Account{
    
    protected String SortCode;
    protected int AccountNo;
    protected double Balance;
    protected String NameOfBank;
    protected double Rate;
    protected LocalDate Date;
    protected LocalDate LastReportedDate;
    protected boolean jointAccount;
    protected Person customer;
    
   
    protected Account(){
        SortCode = "";
        AccountNo = 0;
        Balance = 0;
        NameOfBank = "";
        Rate = 0;
        Date = LocalDate.of(1999,01, 01);
        LastReportedDate = LocalDate.of(1999,02, 02);
        jointAccount = false;
       
    }
    protected Account(String aSortCode,int aAccountNo, double aBalance, String aNameOfBank, double aRate, LocalDate aDate, LocalDate aLastReportedDate){
        SortCode = aSortCode;
        Balance = aBalance;
        NameOfBank = aNameOfBank;
        AccountNo = aAccountNo;
        Rate = aRate;
        Date = aDate;
        LastReportedDate = aLastReportedDate;
        
    }
    
    protected void edit(String aSortCode,int aAccountNo, int aBalance, String aNameOfBank, int aRate, LocalDate aDate, LocalDate aLastReportedDate){
        SortCode = aSortCode;
        AccountNo = aAccountNo;
        Balance = aBalance;
        NameOfBank = aNameOfBank;
        Rate = aRate;
        Date = aDate;
        LastReportedDate = aLastReportedDate;
        
    }
 public String ToString(){
     return "\n"+ SortCode + "\n" + AccountNo + "\n" + Balance + "\n" + NameOfBank + "\n" + Rate + "\n" + Date + "\n" + LastReportedDate + "\n";
 }
    public void Display(JTextArea text){
        if(customer == null){
            customer = new Person();
        }
        customer.Display(text);
        text.append("\n"+ SortCode + "\n" + AccountNo + "\n" + Balance + "\n" + NameOfBank + "\n" + Rate + "\n" + Date + "\n" + LastReportedDate + "\n");
    }
    
    public double getBalance(){
        return Balance;
    }
    
    public int getAccountNo(){
        return AccountNo;
    }
    
    protected void Deposit(int AN, double AM){
        if(this.AccountNo == AN){
            Balance += AM;
        }
    }
    
    protected void WithDraw(int AN, double AM){
        if(this.AccountNo == AN){
            Balance -= AM;
        }
        
    }
    
    protected void Transfer(Account aAc, double AM){
        aAc.Deposit(aAc.getAccountNo(), AM);
        this.WithDraw(AccountNo, AM);
        
    }
    
    protected void Save(FileWriter aWriter){
        try{
            aWriter.write("@@"+System.getProperty("line.separator"));
            aWriter.write(SortCode + "\n" + AccountNo + "\n" + Balance + "\n" + NameOfBank + "\n" + Rate + "\n" + Date + "\n" + LastReportedDate);
        }catch(IOException ioe){
            System.out.println("Error");
            
        }
        
    }
    
    protected void Load(BufferedReader reader){
        try{
        SortCode = reader.readLine();
        AccountNo = Integer.valueOf(reader.readLine());
        Balance = Double.valueOf(reader.readLine());
        NameOfBank =reader.readLine();
        Rate = Double.valueOf(reader.readLine());
        Date = LocalDate.parse(reader.readLine());
        LastReportedDate = LocalDate.parse(reader.readLine());
        }catch(IOException ioe){
            System.out.println("Error");
        }
        
    }
    
 
    
    
        
    
}
