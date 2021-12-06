/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOCardapio {

    /**
     * Método que busca no banco de dados a lista de cardapios
     *
     * @return A lista de cardapios
     */
    public ArrayList<Cardapio> getLista() {
        String sql = "select * from Cardapio";
        ArrayList<Cardapio> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Cardapio obj = new Cardapio();
                obj.setIdCardapio(rs.getInt("idCardapio"));
                obj.setTipo(rs.getString("tipo"));
                obj.setNumero(rs.getInt("numero"));
                lista.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
        }
        return lista;
    }

    /**
     * Método que inclui um objeto na banco de dados
     *
     * @param obj O objeto desajado que vai ser adicionado
     * @return True se der certo e false se não der certo
     */
    public boolean incluir(Cardapio obj) {
        String sql = "insert into cardapio (tipo,numero) values (?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getTipo());
            cod.setInt(2, obj.getNumero());
            if (cod.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return false;
        }
    }
/**
     * Método que atualiza um objeto na banco de dados
     * @param obj O objeto desajado que vai ser atualizado
     * @return True se der certo e false se não der certo
     */
    public boolean alterar(Cardapio obj) {
        String sql = "update Cardapio set tipo = ?,numero=? where idCardapio = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getTipo());
            cod.setInt(2, obj.getNumero());
            cod.setInt(3, obj.getIdCardapio());
            if (cod.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return false;
        }
    }
/**
     * Método que remove um objeto na banco de dados
     * @param obj O objeto desajado que vai ser removido
     * @return True se der certo e false se não der certo
     */
    public boolean remover(Cardapio obj) {
        String sql = "delete from Cardapio where idCardapio = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdCardapio());
            if (cod.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "excluido com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "não excluido com sucesso");
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return false;
        }
    }
/**
      * Método que localiza um objeto dentro do banco de dados 
      * @param id A primary key do objeto
      * @return O objeto pronto para uso
      */
    public Cardapio localizar(int id) {
        String sql = "select * from Cardapio where idCardapio = ?";
        Cardapio obj = new Cardapio();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdCardapio(rs.getInt("idCardapio"));
                obj.setTipo(rs.getString("tipo"));
                obj.setNumero(rs.getInt("numero"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
    /**
     * Método que localiza uma lista de objetos no banco de dados por base no
     * nome
     *
     * @param sql Comando em sql que vai ser executado para localizar a lista
     * @return A lista pronta com todos os nomes localizados
     */
    public ArrayList<Cardapio> localizarNome(String sql) {

        try {
            ArrayList<Cardapio> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Cardapio obj = new Cardapio();
                obj.setIdCardapio(rs.getInt("idCardapio"));
                obj.setTipo(rs.getString("tipo"));
                obj.setNumero(rs.getInt("numero"));
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }

}
