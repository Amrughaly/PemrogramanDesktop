/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Keyborad;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thinkpad
 */
public class DBHelper {
    
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DB = "keyboard";
    public static final String MyConn = "jdbc:mysl://localhost/"+DB+"?user="+USER+"&password="+PASSWORD;
    private static String SQConn;
    public static Connection getConnection(String driver) throws SQLException{
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    //            Class.forName("com.mysql.cj.jdbc.Driver");
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQConn);
                    System.out.println("Koneksi Berhasil");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library belum ada");
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Koneksi Gagal");
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MyConn);
                    System.out.println("Koneksi berhasil");
                } catch (ClassNotFoundException ex) {
                  System.out.println("Library belum ada");
        //        Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex){
        //        Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Koneksi gagal");
                }
            }
        }
        return conn;
    }
}
