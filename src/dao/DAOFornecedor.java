/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOFornecedor {

    /**
     * Método que busca no banco de dados a lista de funcionarios
     *
     * @return A lista de funcionarios
     */
    public ArrayList<Fornecedor> getLista() {
        String sql = "select * from fornecedor";
        ArrayList<Fornecedor> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setSetor(rs.getString("setor"));
                obj.setEndereco(rs.getString("endereco"));
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
    public boolean incluir(Fornecedor obj) {
        String sql = "insert into fornecedor (nome,setor,endereco) values (?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setString(2, obj.getSetor());
            cod.setString(3, obj.getEndereco());
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
    public boolean alterar(Fornecedor obj) {
        String sql = "update fornecedor set nome = ?, setor=?, endereco = ? where idFornecedor = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setString(2, obj.getSetor());
            cod.setString(3, obj.getEndereco());
            cod.setInt(4, obj.getIdFornecedor());
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
    public boolean remover(Fornecedor obj) {
        String sql = "delete from fornecedor where idFornecedor = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdFornecedor());
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
    public Fornecedor localizar(int id) {
        String sql = "select * from Fornecedor where idFornecedor = ?";
        Fornecedor obj = new Fornecedor();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setSetor(rs.getString("setor"));
                obj.setEndereco(rs.getString("endereco"));
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
    public ArrayList<Fornecedor> localizarNome(String sql) {

        try {
            ArrayList<Fornecedor> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setIdFornecedor(rs.getInt("idFornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setSetor(rs.getString("setor"));
                obj.setEndereco(rs.getString("endereco"));
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }
}
