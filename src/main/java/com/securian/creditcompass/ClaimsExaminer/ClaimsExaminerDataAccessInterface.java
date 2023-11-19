package com.securian.creditcompass.ClaimsExaminer;

import java.sql.Connection;
import java.util.List;

public interface ClaimsExaminerDataAccessInterface {

    // This method allows you to create a new record in the database containing
    // the claimsExaminer's attributes.
    // It returns the id of the record created in the database.
    String create();

    List<String> read(Connection con, String tName, String username);

    List<String> update();

    boolean delete(Connection con,String tName,String username);

}
