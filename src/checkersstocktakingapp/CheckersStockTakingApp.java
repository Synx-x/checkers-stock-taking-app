
package checkersstocktakingapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckersStockTakingApp {

    public static void main(String[] args) {
       
          //welcome message
       System.out.println("Welcome to Checkers Stock Taking App");
        int inc=0;
        do{
        int userInput = 0;
        String userInputString = "";
        double userInputDouble =0;
        
      
        
           
        try {

            DataOutputStream toServer = null;
            DataInputStream fromServer = null;
            String str = "";

            Scanner input = new Scanner(System.in);
            String clientAnswer = null;
            Socket s = new Socket("192.168.8.141", 8000);  // establishes socket connection to server

           
//input stream to receive data from the server
            fromServer = new DataInputStream(s.getInputStream());

//output stream to send data to the server
            toServer = new DataOutputStream(s.getOutputStream());

// reads the greeting from the server
          //  String greeting = (String) fromServer.readUTF();

//displays the greeting from the server
        //    System.out.println(greeting);

            
 
            System.out.println("Enter Product name: ");
//gets the users input
            userInputString = input.nextLine();
            if (userInputString =="stop") {
                System.exit(-1);
            }
//sends the user input to the server
            toServer.writeUTF(userInputString);
            
                        System.out.println("Enter Product Type: ");
//gets the users input
            userInputString = input.nextLine();

//sends the user input to the server
            toServer.writeUTF(userInputString);
            
                        System.out.println("Enter Product Price: ");
//gets the users input
            userInputDouble = input.nextDouble();

//sends the user input to the server
            toServer.writeDouble(userInputDouble);
            
            //displays the status of the servers addition of the product to the database
            String productAdded = (String) fromServer.readUTF();
            System.out.println(productAdded);
             inc+=1;
          //  s.close();  // closes socket connection
        } catch (InputMismatchException e) {
            System.out.println("You have entered an incorrect input type, please use INTEGER NUMBERS only.");
        } catch (Exception e) {
            System.out.println(" ERROR or Right click the server class and run from that file first then the client (shift + F6)");
        }

    }while (inc !=3);
    }
}

