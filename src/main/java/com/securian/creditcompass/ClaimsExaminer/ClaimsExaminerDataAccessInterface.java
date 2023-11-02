package com.securian.creditcompass;

import java.sql.Connection;
import java.util.List;

public interface DataAccessInterface {

    // This method allows you to create a new record in the database containing
    // all of the claimsExaminer's attributes.
    // It returns the id of the record created in the database.
    String create();

    List<String> read(Connection con, String tName, String username);

    List<String> update();

    boolean delete(Connection con,String tName,String username);

}
