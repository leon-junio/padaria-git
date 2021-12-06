/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Receita_Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOReceita_Produto {

    /**
     * Método que busca no banco de dados a lista de receitas de produtos
     *
     * @return A lista de receitas de produtos
     */
    public ArrayList<Receita_Produto> getLista() {
        String sql = "select * from Receita_do_Produto";
        ArrayList<Receita_Produto> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Receita_Produto obj = new Receita_Produto();
                obj.setReceita(rs.getInt("Receita_IdReceita"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
                obj.setIdReceita_do_Produto(rs.getInt("idReceita_Produto"));
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
    public boolean incluir(Receita_Produto obj) {
        String sql = "insert into Receita_do_Produto (Receita_Idreceita,Produto_Idproduto) values (?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getReceita());
            cod.setInt(2, obj.getProduto());
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
    public boolean alterar(Receita_Produto obj) {
        String sql = "update Receita_do_Produto set Receita_Idreceita = ?,Produto_IdProduto=? where idReceita_Produto = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getReceita());
            cod.setInt(2, obj.getProduto());
            cod.setInt(3, obj.getIdReceita_do_Produto());
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
    public boolean remover(Receita_Produto obj) {
        String sql = "delete from Receita_do_Produto where idReceita_Produto = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdReceita_do_Produto());
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
    public Receita_Produto localizar(int id) {
        String sql = "select * from Receita_do_Produto where idReceita_Produto = ?";
        Receita_Produto obj = new Receita_Produto();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setReceita(rs.getInt("Receita_IdReceita"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
                obj.setIdReceita_do_Produto(rs.getInt("idReceita_Produto"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
}
