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

public class DBConnection {

    private static DBConnection instancia = null;
    private Connection conexao = null;

    public DBConnection() {
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            //prop.load(new FileInputStream("C:\\Users\\Eduardo Back\\Documents\\NetBeansProjects\\RecDesp\\db.properties"));
            String dbdriver = "org.postgresql.Driver";//prop.getProperty("db.driver");
            String dburl = "jdbc:postgresql://ec2-3-214-121-14.compute-1.amazonaws.com:5432/d2gcqgu3ij9eek";
            String dbuser = "gojatuztmsagzq";//prop.getProperty("db.user");
            String dbsenha = "d06b4345b759f8c4829ce33af418d426ea23ce215e3cb242166bfb1e28ad87b1";

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
    public static DBConnection getInstance() {
        if (instancia == null) {
            instancia = new DBConnection();
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