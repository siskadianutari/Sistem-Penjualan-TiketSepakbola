
package Main;

import Database.Koneksi;
import View.Admin;
//import View.Admin;
import java.sql.SQLException;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        new Admin().show();
        new Koneksi();
    }

}
