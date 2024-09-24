import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionImpl implements DbConnection {

        @Override
        public void insert() {

        }

        @Override
        public void update() {

        }

        @Override
        public void select() {

        }

        @Override
        public void delete() {

        }

        public void showData(Connection connection) {
            if (connection != null){
                    try {
                        String request = "SELECT * FROM public.products";
                            Statement statement = connection.createStatement();

                            ResultSet resultSet = statement.executeQuery(request);
                            while(resultSet.next()) {
                                    long id = resultSet.getLong("id");
                                    String model = resultSet.getString("model");
                                    double price = resultSet.getDouble("price");

                                    System.out.println("Id -" + id + ", model - " + model + ", price -" + price);
                            }
                    } catch (SQLException e) {
                            System.out.println("Failed to load data from db. Please, try again later");
                            throw new RuntimeException(e);
                }
            }
        }
    }