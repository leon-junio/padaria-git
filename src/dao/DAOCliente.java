/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOCliente {

    /**
     * Método que busca no banco de dados a lista de clientes
     *
     * @return A lista de clientes
     */
    public List<Cliente> getLista() {
        String sql = "select * from cliente";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setData_nasc(rs.getString("data_nasc"));

                lista.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
        }
        return lista;
    }

    /**
     * Método que inclui um objeto na banco de dados
     *
     * @param cliente O objeto desajado que vai ser adicionado
     * @return True se der certo e false se não der certo
     */
    public boolean incluir(Cliente cliente) {
        String sql = "insert into cliente (nome,cpf,endereco,data_nasc) values (?,?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, cliente.getNome());
            cod.setString(2, cliente.getCPF());
            cod.setString(3, cliente.getEndereco());
            cod.setString(4, cliente.getData_nasc());
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
     * @param cliente O objeto desajado que vai ser atualizado
     * @return True se der certo e false se não der certo
     */
    public boolean alterar(Cliente cliente) {
        String sql = "update cliente set nome =?, cpf=?,endereco=?,data_nasc =? where idCliente = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setString(1, cliente.getNome());
            cod.setString(2, cliente.getCPF());
            cod.setString(3, cliente.getEndereco());
            cod.setString(4, cliente.getData_nasc());
            cod.setInt(5, cliente.getIdCliente());
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
     * @param cliente O objeto desajado que vai ser removido
     * @return True se der certo e false se não der certo
     */
    public boolean remover(Cliente cliente) {
        String sql = "delete from cliente where idCliente = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, cliente.getIdCliente());
            System.out.println("Passou");
            if (cod.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
                System.out.println("Passou 2");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não excluido com sucesso");
                System.out.println("Passou 3");
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
    public Cliente localizar(int id) {
        String sql = "select * from cliente where idCliente = ?";
        Cliente cliente = new Cliente();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setData_nasc(rs.getString("data_nasc"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                return cliente;
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
    public ArrayList<Cliente> localizarNome(String sql) {

        try {
            ArrayList<Cliente> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setData_nasc(rs.getString("data_nasc"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                result.add(cliente);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }

}
