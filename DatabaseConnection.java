import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
     String ConnectionString="jdbc:sqlserver//Blacky,Database=courier_management;IntegratedSecurity=true";   
    try{
        try(Connection connection=DriverManager.getConnection(ConnectionString))
        {
            System.out.println("Connection established");
        }
    }catch(SQLException e)
    {
        System.out.println("Error connecting to the database");
        e.printStackTrace();
    }
    }
    }

