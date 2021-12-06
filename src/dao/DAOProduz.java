/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Produz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOProduz {

    /**
     * Método que busca no banco de dados a lista de produção
     *
     * @return A lista de produção
     */
    public ArrayList<Produz> getLista() {
        String sql = "select * from Produz";
        ArrayList<Produz> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Produz obj = new Produz();
                obj.setFuncionario(rs.getInt("Funcionario_IdFuncionario"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
                obj.setIdProduz(rs.getInt("idProduz"));
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
    public boolean incluir(Produz obj) {
        String sql = "insert into Produz (Funcionario_Idfuncionario,Produto_Idproduto) values (?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getFuncionario());
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
    public boolean alterar(Produz obj) {
        String sql = "update Produz set Funcionario_IdFuncionario = ?,  Produto_IdProduto=? where idProduz = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getFuncionario());
            cod.setInt(2, obj.getProduto());
            cod.setInt(3, obj.getIdProduz());
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
    public boolean remover(Produz obj) {
        String sql = "delete from Produz where idProduz = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdProduz());
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
    public Produz localizar(int id) {
        String sql = "select * from Produz where idProduz = ?";
        Produz obj = new Produz();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setFuncionario(rs.getInt("Funcionario_IdFuncionario"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
                obj.setIdProduz(rs.getInt("idProduz"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
}
