/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOFuncionario {

    /**
     * Método que busca no banco de dados a lista de funcionarios
     *
     * @return A lista de funcionarios
     */
    public ArrayList<Funcionario> getLista() {
        String sql = "select * from Funcionario";
        ArrayList<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setIdFunc(rs.getInt("idFuncionario"));
                obj.setTipo(rs.getString("tipo"));
                obj.setCPF(rs.getString("CPF"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNome(rs.getString("nome"));
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
    public boolean incluir(Funcionario obj) {
        String sql = "insert into Funcionario (nome,CPF,endereco,tipo) values (?,?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setString(2, obj.getCPF());
            cod.setString(3, obj.getEndereco());
            cod.setString(4, obj.getTipo());
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
    public boolean alterar(Funcionario obj) {
        String sql = "update Funcionario set nome = ?, CPF=?, endereco = ?, tipo=? where idFuncionario = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, obj.getNome());
            cod.setString(2, obj.getCPF());
            cod.setString(3, obj.getEndereco());
            cod.setString(4, obj.getTipo());
            cod.setInt(5, obj.getIdFunc());
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
    public boolean remover(Funcionario obj) {
        String sql = "delete from Funcionario where idFuncionario = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdFunc());
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
    public Funcionario localizar(int id) {
        String sql = "select * from Funcionario where idFuncionario = ?";
        Funcionario obj = new Funcionario();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdFunc(rs.getInt("idFuncionario"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("CPF"));
                obj.setEndereco(rs.getString("Endereco"));
                obj.setTipo(rs.getString("tipo"));
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
    public ArrayList<Funcionario> localizarNome(String sql) {

        try {
            ArrayList<Funcionario> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setIdFunc(rs.getInt("idFuncionario"));
                obj.setTipo(rs.getString("tipo"));
                obj.setCPF(rs.getString("CPF"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNome(rs.getString("nome"));
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }
}
