import org.postgresql.Driver;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DbConnection {

    default Connection connect(){
       try{
           Class.forName("org.postgresql.Driver");
           Connection connection = DriverManager.getConnection(
                   "jdbc:postgresql://localhost:5432/products db", "postgres", "admin"
           );
           System.out.println("Connection succeed!");
           return connection;
       }
       catch (ClassNotFoundException | SQLException e) {
           System.out.println("Connection failed! Please try again!");
           return null;
       }
    }
    void insert(Product product);

    void update();

    void select();

    void delete();
}
