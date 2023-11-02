package com.securian.creditcompass.ClaimsExaminer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionClass {
    public static void main(String[] args) {

        Connection con=connect_to_db("ClaimsCompassMain","securian","hello");
        readTable(con,"claims_examiner", "bob");

    }
    public static Connection connect_to_db(String dbname, String user, String pass)
    {
        Connection con_obj=null;
        String url="jdbc:postgresql://localhost:5432/";

        try
        {
            con_obj= DriverManager.getConnection(url+dbname,user,pass);
            if(con_obj!=null)
            {
                System.out.println("Connection established successfully !");
            }
            else
            {
                System.out.println("Connection failed !!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con_obj;
    }
    // Change to attribute later
    public static void read(Connection con,String tName, String username)
    {
        Statement stmt;
        ResultSet rs;
        try {
            stmt=con.createStatement();
            String query="select * from "+tName+" where username ='"+username+"';";

            rs=stmt.executeQuery(query);

            System.out.println("First Name\t\tUsername\t\tPassword");
            System.out.println("---------------------------");
            while(rs.next())
            {
                System.out.print(rs.getString("username")+"\t\t");
                System.out.print(rs.getString("first_name")+"\t\t\t");
                System.out.println(rs.getString("password"));

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
