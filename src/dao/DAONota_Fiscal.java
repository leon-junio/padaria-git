/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Nota_Fiscal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAONota_Fiscal {

    /**
     * Método que busca no banco de dados a lista de nota_fiscal
     *
     * @return A lista de nota_fiscal
     */
    public ArrayList<Nota_Fiscal> getLista() {
        String sql = "select * from Nota_Fiscal";
        ArrayList<Nota_Fiscal> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Nota_Fiscal obj = new Nota_Fiscal();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setVenda(rs.getInt("Venda_idVenda"));
                obj.setIdNotaFiscal(rs.getInt("idNota_Fiscal"));
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
    public boolean incluir(Nota_Fiscal obj) {
        String sql = "insert into nota_fiscal (codigo,Venda_idVenda) values (?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getCodigo());
            cod.setInt(2, obj.getVenda());
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
    public boolean alterar(Nota_Fiscal obj) {
        String sql = "update Nota_Fiscal set codigo = ?,Venda_idVenda=? where idNota_Fiscal = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getCodigo());
            cod.setInt(2, obj.getVenda());
            cod.setInt(3, obj.getIdNotaFiscal());
            if (cod.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "atualizado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "não atualizado com sucesso");
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
    public boolean remover(Nota_Fiscal obj) {
        String sql = "delete from Nota_Fiscal where idNota_Fiscal = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdNotaFiscal());
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
    public Nota_Fiscal localizar(int id) {
        String sql = "select * from Nota_Fiscal where idNota_Fiscal = ?";
        Nota_Fiscal obj = new Nota_Fiscal();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setCodigo(rs.getInt("codigo"));
                obj.setVenda(rs.getInt("Venda_idVenda"));
                obj.setIdNotaFiscal(rs.getInt("idNota_Fiscal"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
}
