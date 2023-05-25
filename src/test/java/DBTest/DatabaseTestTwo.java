package DBTest;

import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {
        // to build connection with database
        //we need three thimgs url, username and password
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statemnt to send sql queries
            Statement statement = conn.createStatement();//now we can execute queries

          //  ResultSet rset=statement.executeQuery("Select FirstName,lastName from person");
        // ResultSet rset= statement.executeQuery("select firstname, lastname, age, city " +
      //  "from person where city not null;");
            ResultSet rset = statement.executeQuery("select firstname, lastname, age, city " +
                   "from person where city is not null;");
          ResultSetMetaData metaData=rset.getMetaData();
        //print all the column header value
            for (int i = 1; i <=metaData.getColumnCount() ; i++) {
                String columnName=metaData.getColumnName(i);
                System.out.println(columnName);
            }

//we want to loop every coluumn and every row


            while(rset.next()){// for rows moving
                for (int i = 1; i <=metaData.getColumnCount() ; i++) {//moving column
                   String value= rset.getString((metaData.getColumnName(i)));
                    System.out.println(value+ " ");
                }
                //just to chnage the line sstatement
                System.out.println();
            }






          /*ResultSet rset = statement.executeQuery("select firstname, lastname, age, city" +
                    "from person where city is not null;");
            //ResultSetMetaData - object that contains information about the result
            //information such as in  the table how many columns are there,
            //name of the columns, rows and number of the rows
            ResultSetMetaData metaData = rset.getMetaData();*/

           /* while(rset.next()){
                String fName = rset.getString("FirstName");
                String lName = rset.getString("LastName");
                //String gender = rset.getString("Gender");
               // System.out.println(fName + " " + lName);
            }
*/
            //ResultSetMetaData- object that contains information about result
            //information how many columns , names of coulombs, rows and number,







        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
