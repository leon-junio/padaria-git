/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Ingredientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOIngredientes {

    /**
     * Método que busca no banco de dados a lista de ingredientes
     *
     * @return A lista de ingredientes
     */
    public ArrayList<Ingredientes> getLista() {
        String sql = "select * from Ingredientes";
        ArrayList<Ingredientes> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Ingredientes obj = new Ingredientes();
                obj.setIdIngrediente(rs.getInt("idIngredientes"));
                obj.setNome(rs.getString("nome"));
                obj.setPeso(rs.getInt("peso"));
                obj.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
                obj.setForn(obj.getFornecedorObj());
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
    public boolean incluir(Ingredientes obj) {
        String sql = "insert into Ingredientes (nome,peso,Fornecedor_idFornecedor) values (?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setInt(2, obj.getPeso());
            cod.setInt(3, obj.getFornecedor());
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
     *
     * @param obj O objeto desajado que vai ser atualizado
     * @return True se der certo e false se não der certo
     */
    public boolean alterar(Ingredientes obj) {
        String sql = "update Ingredientes set nome = ?,peso=?, fornecedor_Idfornecedor = ? where idIngredientes = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setInt(2, obj.getPeso());
            cod.setInt(3, obj.getFornecedor());
            cod.setInt(4, obj.getIdIngrediente());
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
     *
     * @param obj O objeto desajado que vai ser removido
     * @return True se der certo e false se não der certo
     */
    public boolean remover(Ingredientes obj) {
        String sql = "delete from Ingredientes where idIngredientes = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdIngrediente());
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
     *
     * @param id A primary key do objeto
     * @return O objeto pronto para uso
     */
    public Ingredientes localizar(int id) {
        String sql = "select * from ingredientes where idIngredientes = ?";
        Ingredientes obj = new Ingredientes();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdIngrediente(rs.getInt("idIngredientes"));
                obj.setNome(rs.getString("nome"));
                obj.setPeso(rs.getInt("peso"));
                obj.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
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
    public ArrayList<Ingredientes> localizarNome(String sql) {

        try {
            ArrayList<Ingredientes> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Ingredientes obj = new Ingredientes();
                obj.setIdIngrediente(rs.getInt("idIngredientes"));
                obj.setNome(rs.getString("nome"));
                obj.setPeso(rs.getInt("peso"));
                obj.setFornecedor(rs.getInt("Fornecedor_idFornecedor"));
                obj.setForn(obj.getFornecedorObj());
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }
}
