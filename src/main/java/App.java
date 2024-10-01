public class App {
    public static void main(String[] args) {
        DbConnectionImpl connection = new DbConnectionImpl();
        connection.showData(connection.connect());
        connection.insert(new Product("LagaGovna", 150_000_000));
    }
}
