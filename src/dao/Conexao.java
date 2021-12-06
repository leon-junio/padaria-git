/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leon Jr
 */
public class Conexao {
    private static final String banco = "jdbc:mysql://localhost:3306/padaria_leon";
    private static final String user = "root";
    private static final String senha = "";
    private static final String driver = "com.mysql.jdbc.Driver";
    public static Connection conexao = null;
    /**
     * Construtor da classe
     */
    public Conexao() {

    }
    /**
     * Método que verifica a conexão
     * @return O estado da conexao
     */
    public static boolean conectionState(){
         if (conexao != null) {
             return true;
         }else{
             return false;
         }
    }
    /**
     * Método para conectar ao banco de dados
     * @return A conexão realizada
     */
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName(driver);
                conexao = (Connection) DriverManager.getConnection(banco, user, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro de conexão");
            } catch (SQLException ex) {
                System.out.println("Nao encontrou o banco");
            }
        }
        return conexao;
    }
    /**
     * Método para mandar comandos sql para o banco
     * @param sql Comando em sql que vai ser executado
     * @return A execução do comando
     */
    public static PreparedStatement getPreparedStatement(String sql){
        if(conexao==null){
            getConexao();
        }
        try{
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro no codigo");
        }
        return null;
    }
    
    
    
    
    
}
