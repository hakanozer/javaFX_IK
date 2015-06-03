package javafx_ik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class msDB {

    Statement st;
    Connection conn;
    String url = "jdbc:sqlserver://localhost;";//1443 mssql kullandıgı port numaraısı
    String dbName = "proje";
    String userName = "sa";
    String userPass = "12345678";

    public Statement baglan() {

        try {
            conn = DriverManager.getConnection(url + "databasename=" + dbName + ";user=" + userName + ";password=" + userPass);
            System.out.println("MSSQL Bağlantısı Başarılı");
            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("MSSQL Bağlantısı Başarısız");
        }
        return st;
    }
    
    
    
    
}
