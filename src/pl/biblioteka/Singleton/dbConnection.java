package pl.biblioteka.Singleton;

import java.sql.*;

public class dbConnection {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/books?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private final static  String username = "root";
    private final static String password = "password";
    private static Connection connection;
    private static dbConnection dbConnection = null;
    private dbConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch ( SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    public static dbConnection getInstance() throws SQLException {
        if (dbConnection == null) {
            dbConnection = new dbConnection();
        }
        return dbConnection;
    }
    public static Connection getConnection(){
        return connection;
    }
    public ResultSet executeSelect(PreparedStatement ps) throws SQLException {
        Statement stmt = connection.createStatement();
        String[] query = ps.toString().split(":");
        ResultSet result = stmt.executeQuery(query[1]);
        return result;

    }
}
