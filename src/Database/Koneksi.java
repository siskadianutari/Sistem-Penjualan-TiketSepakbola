
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */


public class Koneksi {
    private Connection connect;
    private Statement db;
    private String database = "siska06954";
    
    public Koneksi(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Class Driver Ditemukan");
            try{
      connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","siska06954","siska");
                System.out.println("Koneksi Database Sukses");
                
            }catch(SQLException se){
                System.out.println("Koneksi Database Gagal : "+se);
            }
        }catch(ClassNotFoundException err){
            System.out.println("Class Driver tidak ditemukan,terjadi kesalahan pada : "+err);
        }
    }
    public ResultSet GetData(String sql){
        try{
            db=connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
        }catch(SQLException e){
            return null;
        }
    }
    public int ManipulasiData(String sql){
        try{
            db=connect.createStatement();
            return db.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

