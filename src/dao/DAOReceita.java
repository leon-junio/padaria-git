/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Receita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOReceita {

    /**
     * Método que busca no banco de dados a lista de receitas
     *
     * @return A lista de receitas
     */
    public ArrayList<Receita> getLista() {
        String sql = "select * from Receita";
        ArrayList<Receita> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Receita obj = new Receita();
                obj.setIdReceita(rs.getInt("idReceita"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setDescricao(rs.getString("descricao"));
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
    public boolean incluir(Receita obj) throws SQLException {
        String sql = "insert into Receita (nome,preco,descricao,idReceita) values (?,?,?,?)";
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setFloat(2, obj.getPreco());
            cod.setString(3, obj.getDescricao());
            cod.setInt(4, obj.getIdReceita());
            if (cod.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        }

    /**
     * Método que atualiza um objeto na banco de dados
     *
     * @param obj O objeto desajado que vai ser atualizado
     * @return True se der certo e false se não der certo
     */
    public boolean alterar(Receita obj) throws SQLException {
        String sql = "update Receita set nome = ?,preco=?,descricao=? where idReceita = ?";
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setFloat(2, obj.getPreco());
            cod.setString(3, obj.getDescricao());
            cod.setInt(4, obj.getIdReceita());
            if (cod.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
    }

    /**
     * Método que remove um objeto na banco de dados
     *
     * @param obj O objeto desajado que vai ser removido
     * @return True se der certo e false se não der certo
     */
    public boolean remover(Receita obj) {
        String sql = "delete from Receita where idReceita = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdReceita());
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
    public Receita localizar(int id) {
        String sql = "select * from Receita where idReceita = ?";
        Receita obj = new Receita();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdReceita(rs.getInt("idReceita"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setDescricao(rs.getString("descricao"));
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
    public ArrayList<Receita> localizarNome(String sql) {

        try {
            ArrayList<Receita> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Receita obj = new Receita();
                obj.setIdReceita(rs.getInt("idReceita"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setDescricao(rs.getString("descricao"));
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }
}
