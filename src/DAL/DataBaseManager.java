//for database operations
package src.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private Connection connection;


    	
    public DataBaseManager(String databaseUrl, String username, String password) {
    	username = "root";
		password = "";
    	    try {
    	        Class.forName("com.mysql.cj.jdbc.Driver"); // Use the driver class
    	        connection = DriverManager.getConnection(databaseUrl, username, password);
    	    } catch (ClassNotFoundException | SQLException e) {
    	        e.printStackTrace();
    	    }
    	}

    

    public Connection getConnection() {
        return connection;
       }

    public void close() {
        try {
            if (connection != null) {
            	System.out.println("Poems Imported Successfully");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

