package pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;

public class TestMyDB {
    public static void main (String [] args){
        MyDB db = new MyDB("localhost", 3306, "mydb");
        db.setUser ("root");
        db.setPassword ("qwertyQWERTY228");
        Connection conn = db.getConnection();
        if (conn != null)
            System.out.println("Polaczenie z baza danych nawiazane");
        db.closeConnection();
        System.out.println("Polaczenie z baza zakonczone");
    }
}
