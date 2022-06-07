package pl.lublin.wsei.java.cwiczenia;

import java.sql.*;
import java.util.Properties;

public class MyDB {
    private Connection conn = null;
    private String user;
    private String password;
    private String host;
    private Number port;
    private String dbName;
    private Statement statement = null;

    public MyDB(String _host, Number _port, String _dbName) {
        this.host = _host;
        this.port = _port;
        this.dbName = _dbName;
    }

    private void connect() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
//            conn = DriverManager.getConnection(jdbcString, connectionProps);
            conn = DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Błąd podłączenia do bazy: " + jdbcString);
            System.out.println("Komunikat błędu: " + e.getSQLState());
            conn = null;
        }
        System.out.println("Connected to database " + dbName);
    }

    public Connection getConnection() {
        if (conn == null)
            connect();
        return conn;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void closeConnection() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Blad przy zamykaniu polaczenia bazodanowego: " + e.getMessage());
            }
        conn = null;
    }

    public ResultSet selectData(String selectStatament) {
        if ((conn != null) && (statement != null))
            try {
                return statement.executeQuery(selectStatament);
            } catch (SQLException e) {
                System.out.println("Blad realizacji zapytania: " + selectStatament + ", " + e.getMessage());
            }
        return null;
    }
}

















