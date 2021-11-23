/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.UserHasEvents;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static screens.Login.userId;
import support.DBConnection;
import support.DBConnectionLocalHost;
import support.IDAOT;

/**
 *
 * @author dudub
 */
public class UserHasEventsDAO implements IDAOT<UserHasEvents> {

    @Override
    public boolean save(UserHasEvents o) {
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            String sql = "";
            
           
                 sql = "INSERT INTO userhasevents VALUES ("
                        + "default,"
                        + "NULL,"
                        + "'Registered',"
                        + "'N',"
                        + userId + ","
                        + o.getIdevent() + ")";
           
            System.out.println("SQL: " + sql);

            int resultado1 = st2.executeUpdate(sql);
            resultado1 = st.executeUpdate(sql);

            return resultado1 > 0;

        } catch (Exception e) {
            System.out.println("Erro ao salvar inscrição: " + e);
            return false;
        }
    }
    
    public void InsertModeOff(String linha)  {
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            st2.executeUpdate(linha);
            st.executeUpdate(linha);
            System.out.println("entrei aqui no insertmode 2");
        } catch (SQLException ex) {
            Logger.getLogger(UserHasEventsDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("entrei aqui no insertmode 3");
        }
    }
    
    
    
    

    @Override
    public boolean update(UserHasEvents o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserHasEvents> consultAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UserHasEvents> consult(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserHasEvents consultId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
