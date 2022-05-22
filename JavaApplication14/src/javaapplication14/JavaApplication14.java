/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication14;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author home
 */
class  Register {
     FileWriter filew;
        BufferedWriter buffw;
        PrintWriter printw;

    public String username;
    public String password;
    public String data;
    public boolean check = true;
    public void ask(){
      try {
          
      File tempdb = new File("records.txt");
      Scanner ask = new Scanner(tempdb);  
      Scanner form  = new Scanner(System.in); 
      while (ask.hasNextLine()) {
         data = ask.nextLine();

       while(check == true){
        System.out.print("Enter your Desire Username:");
        username = form.next();
          System.out.println("\n");
        boolean checkpoint = data.contains("User:"+username+":");
        if(checkpoint == false){
            check = false;
        }else{
            System.out.println("Username already Exist");
            System.out.println("Please try adding number ex("+username+"123..)");
        }
        if(check == false){
            System.out.print("Enter your Password:");
        password = form.next();
          System.out.println("\n");
         filew = new FileWriter("records.txt", true);
            buffw = new BufferedWriter(filew);
            printw = new PrintWriter(buffw);
             printw.println("User:"+username+":"+password);
               printw.flush();
                System.out.println("You Have sucessfully registered");
              form.close();
         
        }
      }
     

       
      }
      ask.close();
      } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }finally {
            try {
                 
         buffw.close();
                printw.close();
                filew.close();
            } catch (IOException io) {// can't do anything }
            }

        }


    
}
    
}
class  Login extends Register {
     FileWriter filew;
        BufferedWriter buffw;
        PrintWriter printw;

    public String username;
    public String password;
    public String data;
    public String sessionnew;
    public boolean passc;
    public int sucesscp = 0;
    public boolean check = true;
    public int session = 0;
    public String sessionc ;
    public void ask(){
      try {
          
      File tempdb = new File("records.txt");
      Scanner ask = new Scanner(tempdb);  
      Scanner form  = new Scanner(System.in); 
      while (ask.hasNextLine()) {
         data = ask.nextLine();

       while(check == true){
        System.out.print("Enter your Username:");
        username = form.next();
        System.out.println("\n");
        boolean checkpoint = data.contains("User:"+username+":");
        if(checkpoint ==  true){
            check = false;
        }else{
            System.out.println("Username dont exist");
               }
        }
        if(check == false){
            while(passc == false){
            System.out.print("Enter your Password:");
        password = form.next();
          System.out.println("\n");
        passc = data.contains("User:"+username+":"+password);
        if(passc == true){
            session = 1;
        }
        }
            
        if(session == 1 || sucesscp == 1){
            sucesscp = 0;
             Scanner asku  = new Scanner(System.in); 
             while(session == 1){
                     System.out.println("\n Menu:\n changep - Changepassword \n logout - Destroy Your Session");
            System.out.print("Welcome:"+username+"\n What do you want?");
            System.out.print(":");
              sessionc = asku.nextLine();
           
            if(sessionc.equals("logout")){
                 System.out.println("You logout youre account");
                 System.exit(0);
                 asku.close();
            }
            
            if(sessionc.equals("changep")){
                session = 0;
                  boolean passd =false;
                  String sessioncs = "User:"+username+":"+password;
                while(passd == false){
                System.out.print("Enter your current Password:");
            
                 String passwords = asku.next();
                     System.out.println("\n");
                 passd = data.contains("User:"+username+":"+passwords);
             
                 }
                 if(passd == true){
                         System.out.print("Enter your new Password:");
                           
                 String passwordsn = asku.next();
                       System.out.println("\n");
                 sessionnew = "User:"+username+":"+passwordsn;
                     String c = data.replace(sessioncs, sessionnew);
                      FileWriter changep = new FileWriter("records.txt");
      changep.write(c);
      changep.close();
                     sucesscp = 1;
                     passd= true;
                     session = 1;
                     System.out.println("Change password sucessfully");
                 }else{
                     
                 }
            }
            
       
        
        }
             }
              form.close();
         
        }
      
     

       
      }
      ask.close();
      } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }finally {
            try {
                 
         buffw.close();
                printw.close();
                filew.close();
            } catch (IOException io) {// can't do anything }
            }

        }


    
}
    
}
public class JavaApplication14 extends Register {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner asku  = new Scanner(System.in); 
          System.out.println("Welcome Guest Please type Login or Register to continue");
          System.out.print(":");
          String askuform = asku.next();
           System.out.print("\n");
           
           if(askuform.equals("register")){
               Register reg = new Register();
               reg.ask();
           }else if(askuform.equals("login")){
               Login reg = new Login();
               reg.ask();
           }
    }
    
}
