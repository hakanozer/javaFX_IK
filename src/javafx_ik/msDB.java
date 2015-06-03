package javafx_ik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class msDB {

    private Statement st;
    private Connection conn;
    private final String url = "jdbc:sqlserver://localhost;";//1443 mssql kullandıgı port numaraısı
    private final String dbName = "ik";
    private final String userName = "sa";
    private final String userPass = "12345678";

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
    
    public void kapat(){
        try {
            if(!st.isClosed()){
                st.close();
                conn.close();
                System.out.println("MsSql Bağlantısı Kapatıldı.");
            } else {
                System.out.println("Connection zaten kapalı.");
            }
        } catch (SQLException ex) {
            System.err.println("MSSQL Bağlatısı Kapatma Hatası : " + ex);
        }
    } 
}
