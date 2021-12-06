/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOPagamento {

    /**
     * Método que busca no banco de dados a lista de pagamentos
     *
     * @return A lista de pagamentos
     */
    public ArrayList<Pagamento> getLista() {
        String sql = "select * from Pagamento";
        ArrayList<Pagamento> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Pagamento obj = new Pagamento();
                obj.setIdPagamento(rs.getInt("idPagamento"));
                obj.setTipoPagamento(rs.getString("tipo"));
                obj.setValor(rs.getFloat("valor"));
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
    public boolean incluir(Pagamento obj) {
        String sql = "insert into Pagamento (tipo,valor,idPagamento) values (?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getTipoPagamento());
            cod.setFloat(2, (float) obj.getValor());
            cod.setInt(3, obj.getIdPagamento());
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
    public boolean alterar(Pagamento obj) {
        String sql = "update Pagamento set tipo = ?,valor=? where idPagamento  = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getTipoPagamento());
            cod.setFloat(2, (float) obj.getValor());
            cod.setInt(3, obj.getIdPagamento());
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
    public boolean remover(Pagamento obj) {
        String sql = "delete from Pagamento where idPagamento = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdPagamento());
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
    public Pagamento localizar(int id) {
        String sql = "select * from Pagamento where idPagamento = ?";
        Pagamento obj = new Pagamento();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdPagamento(rs.getInt("idPagamento"));
                obj.setTipoPagamento(rs.getString("tipo"));
                obj.setValor(rs.getFloat("valor"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
}
