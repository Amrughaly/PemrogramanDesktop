/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Keyborad;

import Model_Keyboard.Keyboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thinkpad
 */
public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addKeyboard(Keyboard kyb){
        String insertKyb = "INSERT INTO 'table_keyboard'('','tanggal_pembelian', 'merek', 'harga','jenis','warna')"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertKyb);
            stmtInsert.setString(1, kyb.gettanggal_pembelian());
            stmtInsert.setString(2, kyb.getmerek());
            stmtInsert.setString(3, kyb.getharga());
            stmtInsert.setString(4, kyb.getjenis());
            stmtInsert.setString(5, kyb.getwarna());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}