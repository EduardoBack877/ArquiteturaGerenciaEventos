/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.UserHasEvents;
import java.sql.Statement;
import java.util.ArrayList;
import static screens.Login.userId;
import support.DBConnection;
import support.IDAOT;

/**
 *
 * @author dudub
 */
public class UserHasEventsDAO implements IDAOT<UserHasEvents> {

    @Override
    public boolean save(UserHasEvents o) {
        try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            String sql = "";
            
           
                 sql = "INSERT INTO userhasevents VALUES ("
                        + "default,"
                        + "NULL,"
                        + "'Registered',"
                        + "'Y',"
                        + userId + ","
                        + o.getIdevent() + ")";
           
            System.out.println("SQL: " + sql);

            int resultado1 = st.executeUpdate(sql);

            return resultado1 > 0;

        } catch (Exception e) {
            System.out.println("Erro ao salvar inscrição: " + e);
            return false;
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
