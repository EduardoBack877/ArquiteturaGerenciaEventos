/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import screens.IfrUserRegister;
import support.DBConnection;
import support.IDAOT;

/**
 *
 * @author dudub
 */
public class UserDAO implements IDAOT<User> {
 
    ResultSet resultadoQ = null;
    ResultSet resultadoQ1 = null;
    ResultSet resultadoQ2 = null;
    ResultSet resultadoQ3 = null;
    ResultSet resultadoQ4 = null;
    ResultSet resultadoQ5 = null;
    public boolean autentication(String login, String password) {

        try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM userr "
                    + "WHERE "
                    + "email = '" + login + "' AND "
                    + "password = '" + password + "'";

            System.out.println("SQL: " + sql);

            resultadoQ = st.executeQuery(sql);

            return resultadoQ.next();

        } catch (Exception e) {
            System.out.println("Authentication Error: " + e);
            return false;
        }
    }
    
        public int consultComboGenre (int id) {
            int idaux = 0;
        try {
            Statement st2 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "SELECT genre FROM userr WHERE id = " + id;
            resultadoQ3 = st2.executeQuery(sql3);
            String aux = "";
            while (resultadoQ3.next()) {
               aux = resultadoQ3.getString("genre");
               if (aux.equals("M")) {
                   idaux = 1;
               } else if (aux.equals("F")) {
                   idaux = 2;
               } else {
                   idaux = 3;
               }   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return idaux;
    }
    
        
        
        
        
        public int consultComboActive (int id) {
            int idaux = 0;
        try {
            Statement st2 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "SELECT active FROM userr WHERE id = " + id;
            resultadoQ5 = st2.executeQuery(sql3);
            String aux = "";
            while (resultadoQ5.next()) {
               aux = resultadoQ5.getString("active");
               if (aux.equals("A")) {
                   idaux = 1;
               } else if (aux.equals("I")) {
                   idaux = 2;
               }   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return idaux;
    }
    
        
     public String returnpassword (int id) {
         String passaux = null;
        try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT password "
                    + "FROM userr "
                    + "WHERE "
                    + "id = " + id;
            resultadoQ2 = st.executeQuery(sql);

            if (resultadoQ2.next()) {
                passaux = resultadoQ2.getString("password");
            };
            return passaux;
            
        } catch (Exception e) {
            System.out.println("Erro ao retornar senha: " + e);
            return "";
        }
    }
    
    public boolean savewithoutmd5 (User u) {
           try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            String sql = "";
            
           
                 sql = "UPDATE userr "
                        + "SET name = '" + u.getName() + "',"
                        + "email = '" + u.getEmail()+ "',"
                        + "password = '" + u.getPassword()  + "',"
                        + "cpf = '" + u.getCpf()+ "',"
                        + "phone = '" + u.getPhone()+ "',"
                        + "birthdate = '" + u.getBirthdate()+ "',"
                        + "genre = '" + u.getGenre()+ "',"
                        + "active = '" + u.getActive()+ "' "
                        + "WHERE id = " + u.getId();
           
            System.out.println("SQL: " + sql);

            int resultado1 = st.executeUpdate(sql);

            return resultado1 > 0;

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e);
            return false;
        }
     
    }
     
     
     
     


    @Override
    public boolean save(User u) {
           try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            String sql = "";
            
             if (u.getId() == 0) {
                  sql = "INSERT INTO userr VALUES ( "
                    + "default, "
                    +  "'" + u.getName() + "',"
                    +  "'" + u.getEmail() + "',"
                    +  "md5('" + u.getPassword() + "'),"
                    +  "'" + u.getCpf() + "',"
                    +  "'" + u.getPhone() + "',"    
                    +  "'" + u.getBirthdate() + "',"
                    +  "'" + u.getGenre() + "',"
                    +  "'" + u.getActive()+ "'"  
                    + ")";
                  
             } else {
                 sql = "UPDATE userr "
                    + "SET name = '" + u.getName() + "',"
                    + "email = '" + u.getEmail() + "',"
                    + "password = md5('" + u.getPassword() + "'),"
                    + "cpf = '" + u.getCpf() + "',"
                    + "phone = '" + u.getPhone() + "',"    
                    + "birthdate = '" + u.getBirthdate() + "',"
                    + "genre = '" + u.getGenre() + "',"
                    + "active = '" + u.getActive()+ "' "  
                    + "WHERE id = " + u.getId();
            }
             

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return resultado > 0;

        } catch (Exception e) {
            System.out.println("Erro ao salvar usuário: " + e);
            return false;
        }
    
    }

    @Override
    public boolean update(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();

            String sql = "UPDATE userr "
                    + "SET active = 'I' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Problems to delete user: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<User> consultAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> consult(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User consultId(int id) {
        User u = null;

        try {
            String p;
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            System.out.println("aqu");
            String sql1 = "SELECT id, name, email, password, cpf, phone, to_char(birthdate, 'dd/MM/yyyy') as birthdate ,genre, active "
                    + "FROM userr "
                    + "WHERE id = " + id;
            System.out.println("CONSULTA USUARIO");
            System.out.println("SQL: " + sql1);
            //int aux = Integer.parseInt(resultadoQ1.getString("status"));
            resultadoQ1 = st.executeQuery(sql1);
            if (resultadoQ1.next()) {
                u = new User();
                System.out.println("1");
                u.setId(resultadoQ1.getInt("id"));
                u.setName(resultadoQ1.getString("name"));
                u.setEmail(resultadoQ1.getString("email"));
                u.setPassword(resultadoQ1.getString("password"));
                u.setCpf(resultadoQ1.getString("cpf"));
                u.setPhone(resultadoQ1.getString("phone"));
                u.setBirthdate(resultadoQ1.getString("birthdate"));
                u.setGenre(resultadoQ1.getString("genre"));
                u.setActive(resultadoQ1.getString("active"));
            }
             
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário: " + e);
        }

        return u;
    }
    
    
    public boolean setDataStyle () {
      try {
            Statement st = DBConnection.getInstance().getConnection().createStatement();
            String sql = "";
                  sql = "set datestyle to DMY";

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return resultado > 0;

        } catch (Exception e) {
            System.out.println("Erro ao salvar datastyle: " + e);
            return false;
        }
        }
    
    
   public void popularTabela (JTable tabela, String criterio) {
    int numColunas = 4;
        User u = new User();
        IfrUserRegister ifru = new IfrUserRegister();
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[numColunas];
        cabecalho[0] = "Id";
        cabecalho[1] = "Name";
        cabecalho[2] = "Login";
        cabecalho[3] = "Active";
        
        int lin = 0;
        
       
        //efetua consulta na tabela
        try {
            resultadoQ = DBConnection.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT id, "
                    + "name, "
                    + "email, "
                    + "active "
                    + "FROM userr " 
                    + "WHERE name ILIKE '%" + criterio + "%'"
                    + "ORDER BY id");
            
            String sqlteste = "SELECT id, name, email, active "
                    + "FROM userr "
                    + "WHERE name ILIKE '%" + criterio + "%'"
                    + "ORDER BY id";
            System.out.println(sqlteste);
            
            System.out.println("cheguei aqui");
            // captura a linha = num de registros
            // retorna para o inicio
  
              resultadoQ.last();
            int numRegistros = resultadoQ.getRow();
            resultadoQ.beforeFirst();
            
            dadosTabela = new Object[numRegistros][numColunas];
         
            while (resultadoQ.next()) {
                System.out.println("entrei no while");
                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("name");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("active");
                
                      lin++;}
         
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
}
   

  