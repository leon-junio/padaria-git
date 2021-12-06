/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOProdutos {

    /**
     * Método que busca no banco de dados a lista de produtos
     *
     * @return A lista de produtos
     */
    public ArrayList<Produto> getLista() {
        String sql = "select * from Produto";
        ArrayList<Produto> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setCodigo(rs.getInt("codigo"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setCardapio(rs.getInt("idCardapio"));
                obj.setCard(obj.getCardapioObj(obj.getCardapio()));
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
    public boolean incluir(Produto obj) {
        String sql = "insert into Produto (nome,preco,codigo,idCardapio,quantidade) values (?,?,?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setFloat(2, (float) obj.getPreco());
            cod.setInt(3, obj.getCodigo());
            cod.setInt(4, obj.getCardapio());
            cod.setInt(5, obj.getQuantidade());
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
    public boolean alterar(Produto obj) {
        String sql = "update Produto set nome = ?,preco=?,codigo=?,idCardapio=?,quantidade=? where idProduto = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setFloat(2, (float) obj.getPreco());
            cod.setInt(3, obj.getCodigo());
            cod.setInt(4, obj.getCardapio());
            cod.setInt(5, obj.getQuantidade());
            cod.setInt(6, obj.getIdProduto());
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
    public boolean remover(Produto obj) {
        String sql = "delete from Produto where idProduto = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdProduto());
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
    public Produto localizar(int id) {
        String sql = "select * from Produto where idProduto = ?";
        Produto obj = new Produto();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setCodigo(rs.getInt("codigo"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setCardapio(rs.getInt("idCardapio"));
                obj.setCard(obj.getCardapioObj(obj.getCardapio()));
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
    public ArrayList<Produto> localizarNome(String sql) {

        try {
            ArrayList<Produto> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setCodigo(rs.getInt("codigo"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setCardapio(rs.getInt("idCardapio"));
                obj.setCard(obj.getCardapioObj(obj.getCardapio()));
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }

}
