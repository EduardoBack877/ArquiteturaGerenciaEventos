/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Events;
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
import static screens.Login.userId;
import support.DBConnection;
import support.DBConnectionLocalHost;
import support.IDAOT;

/**
 *
 * @author dudub
 */
public class EventsDAO implements IDAOT<Events> {

     ResultSet resultadoQ = null;
     ResultSet resultadoQ1 = null;
     ResultSet resultadoQ3 = null;
     ResultSet resultadoQ8 = null;
    
    @Override
    public boolean save(Events o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Events o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Events> consultAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Events> consult(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cancelEvent(int user, int event) {
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "UPDATE userhasevents "
                    + "SET status = 'Canceled' "
                    + "WHERE iduser = " + user + " AND idevent = " + event;
            st2.executeUpdate(sql3);
            st3.executeUpdate(sql3);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void insertUserHasEvents(int user, int event) {
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "INSERT INTO userhasevents VALUES ("
                    + "default,'Y','Registered','Y'," + user + "," + event + ")";
            resultadoQ3 = st2.executeQuery(sql3);
            resultadoQ3 = st3.executeQuery(sql3);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
             public String returnEventDescription(int id) {
        String description = "";
        try {
            Statement st = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT description as description "
                    + "FROM events "
                    + "WHERE id = " + id;
            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
            description = resultadoQ.getString("description");
            }

        } catch (Exception e) {
            System.out.println("Error to find description: " + e);
        }
        
        return description;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
        public void saveAttendance(int user, int event) {
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            String sql33 = "UPDATE userhasevents "
                    + "SET quickcheckin = 'N',"
                    + "active = 'Y' "
                    + "WHERE iduser = " + user + " AND idevent = " + event;
            resultadoQ8 = st2.executeQuery(sql33);
            resultadoQ8 = st3.executeQuery(sql33);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    public int returnDateDiffCurrentDateVsEventDate(int event) {
        int days = 0;
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "SELECT eventdate - CURRENT_DATE as days "
                    + "FROM events "
                    + "WHERE id = " + event;
            resultadoQ3 = st2.executeQuery(sql3);
            resultadoQ3 = st3.executeQuery(sql3);
            while (resultadoQ3.next()) {
               days = resultadoQ3.getInt("days");
            }
            return days;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 654564654;
        }
    }
    
    
    
    @Override
    public Events consultId(int id) {
       Events u = null;

        try {
            String p;
            Statement st = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            System.out.println("aqu");
            String sql1 = "SELECT id, description, location, category, to_char(eventdate, 'dd/MM/yyyy') as eventdate, starttime, endtime, appperiodstartdate, appperiodenddate, status "
                    + "FROM events "
                    + "WHERE status = 'Available' and id = " + id
                    + "ORDER BY eventdate DESC";
            System.out.println("CONSULTA USUARIO");
            System.out.println("SQL: " + sql1);
            //int aux = Integer.parseInt(resultadoQ1.getString("status"));
            resultadoQ1 = st.executeQuery(sql1);
            resultadoQ1 = st3.executeQuery(sql1);
            if (resultadoQ1.next()) {
                
                u = new Events();
                System.out.println("1");
                u.setId(resultadoQ1.getInt("id"));
                u.setDescription(resultadoQ1.getString("description"));
                u.setLocation(resultadoQ1.getString("location"));
                u.setCategory(resultadoQ1.getString("category"));
                u.setEventdate(resultadoQ1.getString("eventdate"));
                u.setStarttime(resultadoQ1.getString("starttime"));
                u.setEndtime(resultadoQ1.getString("endtime"));
                u.setAppperiodstartdate(resultadoQ1.getString("appperiodstartdate"));
                u.setAppperiodenddate(resultadoQ1.getString("appperiodenddate"));
                u.setStatus(resultadoQ1.getString("status"));
            }
             
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário: " + e);
        }

        return u; 
    }
  
       public int consultComboEventStatus (int id) {
            int idaux = 0;
        try {
            Statement st2 = DBConnectionLocalHost.getInstance().getConnection().createStatement();
            Statement st3 = DBConnection.getInstance().getConnection().createStatement();
            String sql3 = "SELECT status FROM events WHERE id = " + id;
            resultadoQ3 = st2.executeQuery(sql3);
            resultadoQ3 = st3.executeQuery(sql3);
            String aux = "";
            while (resultadoQ3.next()) {
               aux = resultadoQ3.getString("status");
               if (aux.equals("Available")) {
                   idaux = 1;
               } else if (aux.equals("Application Period Closed")) {
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
    
    
    
    
    
    
    
    
     public void popularTabela (JTable tabela, String criterio) {
    int numColunas = 7;
        User u = new User();
        IfrUserRegister ifru = new IfrUserRegister();
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[numColunas];
        cabecalho[0] = "Id";
        cabecalho[1] = "Description";
        cabecalho[2] = "Location";
        cabecalho[3] = "Category";
        cabecalho[4] = "Event Date";
        cabecalho[5] = "Start Time";
        cabecalho[6] = "End Time";
        
             
        
        int lin = 0;
        
       
        //efetua consulta na tabela
        try {
            resultadoQ = DBConnectionLocalHost.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT id, "
                    + "description, "
                    + "location, "
                    + "category, "
                    + "to_char(eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "starttime, "
                    + "endtime "
                    + "FROM events " 
                    + "WHERE description ILIKE '%" + criterio + "%'"
                    + "ORDER BY id");
            
            resultadoQ = DBConnection.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT id, "
                    + "description, "
                    + "location, "
                    + "category, "
                    + "to_char(eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "starttime, "
                    + "endtime "
                    + "FROM events " 
                    + "WHERE description ILIKE '%" + criterio + "%'"
                    + "ORDER BY id");
            
            
              resultadoQ.last();
            int numRegistros = resultadoQ.getRow();
            resultadoQ.beforeFirst();
            
            dadosTabela = new Object[numRegistros][numColunas];
         
            while (resultadoQ.next()) {
                System.out.println("entrei no while");
                dadosTabela[lin][0] = resultadoQ.getString("id");
                dadosTabela[lin][1] = resultadoQ.getString("description");
                dadosTabela[lin][2] = resultadoQ.getString("location");
                dadosTabela[lin][3] = resultadoQ.getString("category");
                dadosTabela[lin][4] = resultadoQ.getString("eventdate");
                dadosTabela[lin][5] = resultadoQ.getString("starttime");
                dadosTabela[lin][6] = resultadoQ.getString("endtime");
                
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
     
     public void popularTabela2 (JTable tabela, String criterio) {
    int numColunas = 7;
        User u = new User();
        IfrUserRegister ifru = new IfrUserRegister();
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[numColunas];
        cabecalho[0] = "Id";
        cabecalho[1] = "Description";
        cabecalho[2] = "Location";
        cabecalho[3] = "Category";
        cabecalho[4] = "Event Date";
        cabecalho[5] = "Start Time";
        cabecalho[6] = "End Time";
        
             
        
        int lin = 0;
        
       
        //efetua consulta na tabela
        try {
            resultadoQ = DBConnectionLocalHost.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT DISTINCT events.id, "
                    + "events.description, "
                    + "events.location, "
                    + "events.category, "
                    + "to_char(events.eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "events.starttime, "
                    + "events.endtime "
                    + "FROM events "
                    + "JOIN userhasevents ON events.id = userhasevents.idevent "
                    + "JOIN userr on userr.id = userhasevents.iduser "
                    + "WHERE description ILIKE '%" + criterio + "%' AND userhasevents.status = 'Registered' AND userhasevents.iduser = " + userId
                    + "ORDER BY id");
            
            resultadoQ = DBConnection.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT DISTINCT events.id, "
                    + "events.description, "
                    + "events.location, "
                    + "events.category, "
                    + "to_char(events.eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "events.starttime, "
                    + "events.endtime "
                    + "FROM events "
                    + "JOIN userhasevents ON events.id = userhasevents.idevent "
                    + "JOIN userr on userr.id = userhasevents.iduser "
                    + "WHERE description ILIKE '%" + criterio + "%' AND userhasevents.status = 'Registered' AND userhasevents.iduser = " + userId
                    + "ORDER BY id");
            
            
            
              resultadoQ.last();
            int numRegistros = resultadoQ.getRow();
            resultadoQ.beforeFirst();
            
            dadosTabela = new Object[numRegistros][numColunas];
         
            while (resultadoQ.next()) {
                System.out.println("entrei no while");
                dadosTabela[lin][0] = resultadoQ.getString("id");
                dadosTabela[lin][1] = resultadoQ.getString("description");
                dadosTabela[lin][2] = resultadoQ.getString("location");
                dadosTabela[lin][3] = resultadoQ.getString("category");
                dadosTabela[lin][4] = resultadoQ.getString("eventdate");
                dadosTabela[lin][5] = resultadoQ.getString("starttime");
                dadosTabela[lin][6] = resultadoQ.getString("endtime");
                
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
     
     public void popularTabela3 (JTable tabela, String dataevent) {
    int numColunas = 7;
        User u = new User();
        IfrUserRegister ifru = new IfrUserRegister();
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[numColunas];
        cabecalho[0] = "Id";
        cabecalho[1] = "Description";
        cabecalho[2] = "Location";
        cabecalho[3] = "Category";
        cabecalho[4] = "Event Date";
        cabecalho[5] = "Start Time";
        cabecalho[6] = "End Time";
        
             
        
        int lin = 0;
        
        
        String sqlt = "SELECT events.id, "
                    + "events.description, "
                    + "events.location, "
                    + "events.category, "
                    + "to_char(events.eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "events.starttime, "
                    + "events.endtime "
                    + "FROM events "
                    + "WHERE to_char(events.eventdate, 'dd/MM/yyyy') = " +dataevent
                    + " ORDER BY id";
            
            System.out.println("está executando este comando = " + sqlt);
        
           
       
        //efetua consulta na tabela
        try {
            resultadoQ = DBConnectionLocalHost.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT DISTINCT events.id, "
                    + "events.description, "
                    + "events.location, "
                    + "events.category, "
                    + "to_char(events.eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "events.starttime, "
                    + "events.endtime "
                    + "FROM events "
                    + "WHERE to_char(events.eventdate, 'dd/MM/yyyy') = '" + dataevent + "' "
                    + "ORDER BY id");
            
            resultadoQ = DBConnection.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
  ResultSet.CONCUR_READ_ONLY).executeQuery(""
                    + "SELECT DISTINCT events.id, "
                    + "events.description, "
                    + "events.location, "
                    + "events.category, "
                    + "to_char(events.eventdate, 'dd/MM/yyyy') as eventdate, "    
                    + "events.starttime, "
                    + "events.endtime "
                    + "FROM events "
                    + "WHERE to_char(events.eventdate, 'dd/MM/yyyy') = '" + dataevent + "' "
                    + "ORDER BY id");
            
            
            
              resultadoQ.last();
            int numRegistros = resultadoQ.getRow();
            resultadoQ.beforeFirst();
            
            dadosTabela = new Object[numRegistros][numColunas];
         
            while (resultadoQ.next()) {
                System.out.println("entrei no while");
                dadosTabela[lin][0] = resultadoQ.getString("id");
                dadosTabela[lin][1] = resultadoQ.getString("description");
                dadosTabela[lin][2] = resultadoQ.getString("location");
                dadosTabela[lin][3] = resultadoQ.getString("category");
                dadosTabela[lin][4] = resultadoQ.getString("eventdate");
                dadosTabela[lin][5] = resultadoQ.getString("starttime");
                dadosTabela[lin][6] = resultadoQ.getString("endtime");
                
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
