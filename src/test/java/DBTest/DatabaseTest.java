package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args) {
        // to build connection with database
        //we need three thimgs url, username and password
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        //we need to establish connection to database
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statemnt to send sql queries
            Statement statement = conn.createStatement();//now we can execute queries
            //when we send any query to the database then db send returns
            //results set(tables with rows and column)
            ResultSet rset = statement.executeQuery("select FirstName,LastName from person");//rset is results getting from database
            rset.next();

            String fName = rset.getString("FirstName");
            String lName = rset.getString("LastName");
            System.out.println(fName + " " + lName);
            rset.next();

            fName = rset.getString("FirstName");
            lName = rset.getString("LastName");


            System.out.println(fName + " " + lName);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*try {
            //we need to establish the connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statement to send sql queries
            Statement statement = conn.createStatement();
           //when we send any query to the database then db returns
            //result set ( tables with rows and columns)
           ResultSet rset = statement.executeQuery("select FirstName, LastName from person");

        } catch (SQLException e) {
           e.printStackTrace();
        }*/
    }


}
