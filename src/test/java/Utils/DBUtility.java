package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet rset;
    private static ResultSetMetaData rSetMetaData;

    //this methoid create connection to database, execute my query and return object or results
    public static ResultSet getResultSet(String sqlQuery) {
        try {
            conn = DriverManager.getConnection(ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));

            statement = conn.createStatement();
            rset = statement.executeQuery(sqlQuery);


        } catch (SQLException e) {
            e.printStackTrace();

        }

        return rset;//result set
    }
//this method will return will return the object of metadata
    public static ResultSetMetaData getrSetMetaDa(String query)// returnning meta data coumn details
    {
        rset=getResultSet(query);
        rSetMetaData=null;
        //we use this line to get the data in tabular formet so that we can use these in coumn keys and values for
        //retrival operation
        try {
            rSetMetaData=rset.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

     return rSetMetaData;// what are couln, keys all info rows..to get info
    }
//this method is extracting data which will be store in list of maps
    public static List<Map<String,String>>getListOfMapsFromRset(String query)
    {
       rSetMetaData= getrSetMetaDa(query);
       List<Map<String,String>>listFromRset=new ArrayList<>();
        try{
       while(rset.next()) {//check row
           Map<String, String> map = new LinkedHashMap<>();
           //  Map<String,String>map=new LinkedHashMap<>();//taking care of insertion of data is important
           //iterate over colums
           for (int i = 1; i < rSetMetaData.getColumnCount(); i++) {//row go through all columns
               //fetching key and value from the column
               String key = rSetMetaData.getColumnName(i);
               String value = rset.getString(key);//values against key
               map.put(key, value);// adding key and value

           }
           System.out.println(map);
           listFromRset.add(map);
       }
        }catch (SQLException e){
            e.printStackTrace();
        } finally{
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatemnt(statement);
            DBUtility.closeConnection(conn);
        }

        return listFromRset;



      //always close db
        //order to make connection
        //connection
        //statement
        //resultset
//sequence of closing
        //close result
        //close ststment
        // close connection


       }
       public static  void closeResultSet(ResultSet rset){
        if(rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }


    }

    static void closeStatemnt(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

public  static void closeConnection(Connection conn){
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}




}