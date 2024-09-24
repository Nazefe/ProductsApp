public class App {
    public static void main(String[] args) {
        DbConnectionImpl connection = new DbConnectionImpl();

            connection.showData(connection.connect());
    }
}
