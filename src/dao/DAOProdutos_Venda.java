/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Produtos_Venda;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOProdutos_Venda {

    /**
     * Método que busca no banco de dados a lista de Produtos da Venda
     *
     * @return A lista de Produtos da Venda
     */
    public ArrayList<Produtos_Venda> getLista() {
        String sql = "select * from Produtos_Venda";
        ArrayList<Produtos_Venda> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Produtos_Venda obj = new Produtos_Venda();
                obj.setIdProdutosVenda(rs.getInt("idProdutos_Venda"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setData(rs.getString("data"));
                obj.setNome(rs.getString("nome_produto"));
                obj.setVenda(rs.getInt("Venda_idVenda"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
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
    public boolean incluir(Produtos_Venda obj) {
        String sql = "insert into Produtos_Venda (quantidade,preco,data,Venda_idVenda,Produto_idProduto,nome_Produto) values (?,?,?,?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getQuantidade());
            cod.setFloat(2, (float) obj.getPreco());
            cod.setString(3, obj.getData());
            cod.setInt(4, obj.getVenda());
            cod.setInt(5, obj.getProduto());
            cod.setString(6, obj.getNome());
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
    public boolean alterar(Produtos_Venda obj) {
        String sql = "update Produtos_Venda set quantidade = ?,preco=?, data=?,Venda_idVenda=?, Produto_idProduto=?,nome_produto=? where idProdutos_Venda = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getQuantidade());
            cod.setFloat(2, obj.getPreco());
            cod.setString(3, obj.getData());
            cod.setInt(4, obj.getVenda());
            cod.setInt(5, obj.getProduto());
            cod.setString(6, obj.getNome());
            cod.setInt(7, obj.getIdProdutosVenda());
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
    public boolean remover(Produtos_Venda obj) {
        String sql = "delete from Produtos_Venda where idProdutos_Venda = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdProdutosVenda());
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
    public Produtos_Venda localizar(int id) {
        String sql = "select * from Produto where idProdutos_Venda = ?";
        Produtos_Venda obj = new Produtos_Venda();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdProdutosVenda(rs.getInt("idProdutos_Venda"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setData(rs.getString("data"));
                obj.setVenda(rs.getInt("Venda_idVenda"));
                obj.setNome(rs.getString("nome_produto"));
                obj.setProduto(rs.getInt("Produto_idProduto"));
                return obj;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
        return null;
    }
}
