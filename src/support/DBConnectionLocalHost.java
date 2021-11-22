package support;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabricio.pretto
 */
import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnectionLocalHost {

    private static DBConnectionLocalHost instancia = null;
    private Connection conexao = null;

    public DBConnectionLocalHost() {
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            //prop.load(new FileInputStream("C:\\Users\\Eduardo Back\\Documents\\NetBeansProjects\\RecDesp\\db.properties"));
            String dbdriver = "org.postgresql.Driver";//prop.getProperty("db.driver");
            String dburl = "jdbc:postgresql://localhost:5432/gerenciaarqsoftwareback";
            String dbuser = "postgres";//prop.getProperty("db.user");
            String dbsenha = "postgres";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Retorna instância
    public static DBConnectionLocalHost getInstance() {
        if (instancia == null) {
            instancia = new DBConnectionLocalHost();
        }
        return instancia;
    }

    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}