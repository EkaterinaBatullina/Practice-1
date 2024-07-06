import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javalab_2024_db",
                    "postgres", "eka_rina16");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from auto");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String number = resultSet.getString("number");
                int driverId = resultSet.getInt("driver_id");

                System.out.println(name + " " + number + " " + driverId);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}