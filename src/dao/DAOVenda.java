/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOVenda {

    /**
     * Método que busca no banco de dados a lista de vendas
     *
     * @return A lista de vendas
     */

    public ArrayList<Venda> getLista() {
        String sql = "select * from Venda";
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Venda obj = new Venda();
                obj.setIdVenda(rs.getInt("idVenda"));
                obj.setFuncionario(rs.getInt("Funcionario_idFuncionario"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setCliente(rs.getInt("idCliente"));
                obj.setPagamento(rs.getInt("Pagamento_idPagamento"));
                obj.setCli(obj.getClienteObj());
                obj.setFunc(obj.getFuncionarioObj());
                obj.setPag(obj.getPagamentoObj());
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
    public boolean incluir(Venda obj) {
        String sql = "insert into Venda (preco,Funcionario_idFuncionario,Pagamento_idPagamento,idCliente) values (?,?,?,?)";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(2, obj.getFuncionario());
            cod.setFloat(1, obj.getPreco());
            cod.setInt(3, obj.getPagamento());
            cod.setInt(4, obj.getCliente());
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
    public boolean alterar(Venda obj) {
        String sql = "update Venda set preco = ?,Funcionario_IdFuncionario=?,Pagamento_idPagamento=?,idCliente=? where idVenda = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(2, obj.getFuncionario());
            cod.setFloat(1, obj.getPreco());
            cod.setInt(3, obj.getPagamento());
            cod.setInt(4, obj.getCliente());
            cod.setInt(5, obj.getIdVenda());
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
    public boolean remover(Venda obj) {
        String sql = "delete from Venda where idVenda = ?";
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, obj.getIdVenda());
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
    public Venda localizar(int id) {
        String sql = "select * from Venda where idVenda = ?";
        Venda obj = new Venda();
        try {
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1, id);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                obj.setIdVenda(rs.getInt("idVenda"));
                obj.setFuncionario(rs.getInt("Funcionario_idFuncionario"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setPagamento(rs.getInt("Pagamento_idPagamento"));
                obj.setCliente(rs.getInt("idCliente"));
                obj.setCli(obj.getClienteObj());
                obj.setFunc(obj.getFuncionarioObj());
                obj.setPag(obj.getPagamentoObj());
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
    public ArrayList<Venda> localizarNome(String sql) {

        try {
            ArrayList<Venda> result = new ArrayList<>();
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while (rs.next()) {
                Venda obj = new Venda();
                obj.setIdVenda(rs.getInt("idVenda"));
                obj.setFuncionario(rs.getInt("Funcionario_idFuncionario"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setPagamento(rs.getInt("Pagamento_idPagamento"));
                obj.setCliente(rs.getInt("idCliente"));
                obj.setCli(obj.getClienteObj());
                obj.setFunc(obj.getFuncionarioObj());
                obj.setPag(obj.getPagamentoObj());
                result.add(obj);
            }
            return result;
        } catch (SQLException ex) {
            System.out.println("Erro de SQL " + ex.getMessage());
            return null;
        }
    }
}
