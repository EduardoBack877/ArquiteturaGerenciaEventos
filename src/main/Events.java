package main;

import screens.Login;
import support.DBConnection;
import java.sql.Statement;
import screens.MainWindow;


public class Events {
        public static void main(String[] args) {
        new Login(null, true).setVisible(true);  
    }
}
