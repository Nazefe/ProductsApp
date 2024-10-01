import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionImpl implements DbConnection {



    @Override
    public void insert(Product product) {
            try {
                var request = "INSERT INTO public.products(id, model, price) VALUES(?, ?, ?)";
                var connection = connect();
                var prepareStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
                prepareStatement.setLong(1, 12);
                prepareStatement.setString(2, product.getProductName());
                prepareStatement.setDouble(3, product.getPrice());

                prepareStatement.executeUpdate();

                System.out.println("Data insert successfully!");
            } catch (SQLException e) {
                System.out.println("Data insertion failed. Please, try again!");
                System.out.println(e);
        }
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