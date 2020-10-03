package checkersstocktakingapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class CheckersStockTakingAppServer {

    public static void main(String[] args) throws Exception {
        int inc=0;
        do{
        String operator = null;

        ServerSocket ss = new ServerSocket(8000); //creates a socket and listens until it recieves a terminate call 

        System.out.println("server is starting...."); // once server has started this message is displayed

        Socket s = ss.accept();//establishes connection 

        //  Connect to an MySQL Database
        String url = "jdbc:mysql://127.0.0.1:3306/checkersproducts";
        String user = "root";
        String password = "";
        //run query
        String sql = "select * from products;";

        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        
        
            
        
        try {

            // Create data input and output streams
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            // removing jdbc:mysql://127.0.0.1:3306/ string from string to allow for database name to be recieved
            String master = url;
            String target = "jdbc:mysql://127.0.0.1:3306/";
            String replacement = "";
            String processed = master.replace(target, replacement);
            
            // database name
            String databaseName = processed;

            //recieves product details from the client and combines  them into a single string
            String proName = input.readUTF();
            String proType = input.readUTF();
            double proPrice = (double) input.readDouble();
            String proProduct = proName + " " + proType + " " + proPrice;

            
            //displays a list of all the product details
            System.out.println("Server received Product Details: " + proProduct);

            //displays what databse is connected to currently
            System.out.println("Connected to the database " + databaseName);

            // sends message to client that product has been added
            output.writeUTF("Server says: Product has been added");

            System.out.println("Product has been added to database");
            //sends question to the client
            //output.writeUTF("Question from the Server: " + "What is " + result);

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            String query1 = "INSERT INTO products " + "VALUES (null, '" + proName + "', '" + proType + "', '" + proPrice + "')";
            stmt.executeUpdate(query1);

            //recieves product details from the client and combines  them into a single string
            proName = input.readUTF();
            proType = input.readUTF();
            proPrice = (double) input.readDouble();
            proProduct = proName + " " + proType + " " + proPrice;

            //displays a list of all the product details
            System.out.println("Server received Product Details: " + proProduct);

            //displays what databse is connected to currently
            System.out.println("Connected to the database " + databaseName);

            // sends message to client that product has been added
            output.writeUTF("Server says: Product has been added");

            System.out.println("Product has been added to database");

            query1 = "INSERT INTO products " + "VALUES (null, '" + proName + "', '" + proType + "', '" + proPrice + "')";
            stmt.executeUpdate(query1);

            //recieves product details from the client and combines  them into a single string
            proName = input.readUTF();
            proType = input.readUTF();
            proPrice = (double) input.readDouble();
            proProduct = proName + " " + proType + " " + proPrice;

            //displays a list of all the product details
            System.out.println("Server received Product Details: " + proProduct);

            //displays what databse is connected to currently
            System.out.println("Connected to the database " + databaseName);

            // sends message to client that product has been added
            output.writeUTF("Server says: Product has been added");

            System.out.println("Product has been added to database");

            query1 = "INSERT INTO products " + "VALUES (null, '" + proName + "', '" + proType + "', '" + proPrice + "')";
            stmt.executeUpdate(query1);

            //recieves product details from the client and combines  them into a single string
            proName = input.readUTF();
            proType = input.readUTF();
            proPrice = (double) input.readDouble();
            proProduct = proName + " " + proType + " " + proPrice;

            //displays a list of all the product details
            System.out.println("Server received Product Details: " + proProduct);

            //displays what databse is connected to currently
            System.out.println("Connected to the database " + databaseName);

            // sends message to client that product has been added
            output.writeUTF("Server says: Product has been added");

            // query to add products to the database
            query1 = "INSERT INTO products " + "VALUES (null, '" + proName + "', '" + proType + "', '" + proPrice + "')";
            stmt.executeUpdate(query1);

            // confirmation message
            System.out.println("Product has been added to database");
            inc+=1;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {

        }

        //

    }while (inc !=3);
   //ss.close();  // terminates the server socket if client sends exit
    }
}
