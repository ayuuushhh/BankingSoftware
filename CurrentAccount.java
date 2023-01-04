/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee2606project_student2028016;

import java.time.LocalDate;
import javax.swing.JTextArea;

/**
 *
 * @author SLL700
 */
public class CurrentAccount extends Account {
    private double OverDraft;
    private String Condition;
    private double balance;
    private Person customer;
    
    public CurrentAccount(){
        OverDraft = 100;
        Condition = "";
        balance = 0;
        customer = new Person();
    }
    
    public CurrentAccount(double aOverDraft,String aCondition, double abalance){
        OverDraft = aOverDraft;
        Condition = aCondition;
        balance = abalance;
        
    }
    
   public CurrentAccount(String SortCode,int AccountNo, double Balance, String NameOfBank,double Rate,LocalDate Date, LocalDate LastReportedDate, double OverDraft,String Condition){
      super(SortCode,AccountNo,Balance,NameOfBank,Rate,Date,LastReportedDate);
       this.OverDraft = OverDraft;
       this.Condition = Condition;
       this.balance = Balance;
       
   }
   public void DisplayCurrentAccount(JTextArea text){
       Display(text);
       text.append(OverDraft+ Condition + balance);
   }
   
   public void depositInterest(int AN, double AM){
       super.Deposit(AN, AM);
       
   }
    
}
