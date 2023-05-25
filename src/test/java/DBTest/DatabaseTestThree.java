package DBTest;

import Utils.ConfigReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTestThree {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";




        try {
           // Connection conn = DriverManager.getConnection(ConfigReader.getPropertyValue("urldb",)url, username, password);
            Connection conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection is created for DB");
            //create statment to send sql queries
            Statement statement = conn.createStatement();
            String query="select * from person;";
            ResultSet rset=statement.executeQuery(query);
            ResultSetMetaData rsmdata=rset.getMetaData();

            //extract data from results and store it in java data structure

            List<Map<String,String>>listFromRset=new ArrayList<>();
          // iterate throughs rows
            while(rset.next())//rows
            {
                Map<String,String>map=new LinkedHashMap<>();//taking care of insertion of data is important
                //iterate over colums
                for (int i = 1; i <rsmdata.getColumnCount() ; i++) {
                    //fetching key and value from the column
                    String key= rsmdata.getColumnName(i);
                    String value=rset.getString(key);//values against key
                    map.put(key,value);// adding key and value

                }
                System.out.println(map);
                listFromRset.add(map);

            }







        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
