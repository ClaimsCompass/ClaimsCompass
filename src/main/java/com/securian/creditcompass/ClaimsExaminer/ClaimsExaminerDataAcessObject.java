package com.securian.creditcompass.ClaimsExaminer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClaimsExaminerDataAcessObject implements ClaimsExaminerDataAccessInterface {
    public ClaimsExaminerDataAcessObject() {

    }
    public static void main(String[] args) {
        ClaimsExaminerDataAcessObject examinerObj = new ClaimsExaminerDataAcessObject();
        Connection con=connect_to_db("ClaimsCompassMain","securian","hello");
//        examinerObj.read(con,"claims_examiner", "janeDoe");
//        examinerObj.delete(con, "claims_examiner", "johnDoe");

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

    @Override
    public String create() {
        return null;
    }


    public List<String> read(Connection con, String tName, String username)
    {
        Statement stmt;
        ResultSet rs;
        try {
            stmt=con.createStatement();
            String query="select * from "+tName+" where username ='"+username+"';";

            rs=stmt.executeQuery(query);
            List<String> claimExaminer = new ArrayList<>();

            while(rs.next()) {
                String rowUsername = rs.getString("username");
                claimExaminer.add(rowUsername);
                String rowFirstName = rs.getString("first_name");
                claimExaminer.add(rowFirstName);
                String rowPassword = rs.getString("password");
                claimExaminer.add(rowPassword);
            }
            System.out.println(claimExaminer);
            return claimExaminer;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<String> update() {
        return null;
    }


    public boolean delete(Connection con,String tName,String username)
    {
        Statement stmt;

        try {
            String query="delete from "+tName+" where username = '"+username+"';";
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Row deleted successfully!");
            return true;

        }
        catch (Exception e)
        {
            System.out.println("Exception caught in deleteTable");
            return false;
        }
    }
}
