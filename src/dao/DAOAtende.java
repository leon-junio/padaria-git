/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Atende;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon Jr
 */
public class DAOAtende {
    /**
     * Método que busca no banco de dados a lista de atendimentos
     *
     * @return A lista de atendimentos
     */
    public ArrayList<Atende> getLista(){
        String sql = "select * from Atende";
        ArrayList <Atende> lista = new ArrayList<>();
        try{
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            ResultSet rs = cod.executeQuery();
            while(rs.next()){
                Atende obj  = new Atende();
                obj.setCliente(rs.getInt("Cliente_IdCliente"));
                obj.setFuncionario(rs.getInt("Funcionario_idFuncionario"));
                obj.setIdAtende(rs.getInt("idAtende"));
                lista.add(obj);
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL "+ex.getMessage());
        }
        return lista;
    }
    /**
     * Método que inclui um objeto na banco de dados
     * @param obj O objeto desajado que vai ser adicionado
     * @return True se der certo e false se não der certo
     */
    public boolean incluir(Atende obj){
        String sql = "insert into Atende (Cliente_IdCliente,Funcionario_idFuncionario) values (?,?)";
        try{
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1,obj.getCliente());
            cod.setInt(2,obj.getFuncionario());
            if(cod.executeUpdate()>0){
                return true;
            }else{
                 return false;
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL "+ex.getMessage());
            return false;
        }
    }
    /**
     * Método que atualiza um objeto na banco de dados
     * @param obj O objeto desajado que vai ser atualizado
     * @return True se der certo e false se não der certo
     */
     public boolean alterar(Atende obj){
        String sql = "update Atende set Cliente_idCliente = ?,Funcionario_Idfuncionario=? where idAtende = ?";
        try{
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1,obj.getCliente());
            cod.setInt(2,obj.getFuncionario());
            cod.setInt(3,obj.getIdAtende());
            if(cod.executeUpdate()>0){
                return true;
            }else{
                 return false;
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL "+ex.getMessage());
            return false;
        }
    }
     /**
     * Método que remove um objeto na banco de dados
     * @param obj O objeto desajado que vai ser removido
     * @return True se der certo e false se não der certo
     */
     public boolean remover(Atende obj){
        String sql = "delete from Atende where idAtende = ?";
        try{
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1,obj.getIdAtende());
            if(cod.executeUpdate()>0){
                JOptionPane.showMessageDialog(null,"excluido com sucesso");
                return true;
            }else{
                 JOptionPane.showMessageDialog(null,"não excluido com sucesso");
                 return false;
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL "+ex.getMessage());
            return false;
        }
    }
    
     
     
     /**
      * Método que localiza um objeto dentro do banco de dados 
      * @param id A primary key do objeto
      * @return O objeto pronto para uso
      */
     public Atende localizar(int id){
         String sql = "select * from Atende where idAtende = ?";
         Atende obj = new Atende();
         try{
            PreparedStatement cod = Conexao.getPreparedStatement(sql);
            cod.setInt(1,id);
            ResultSet rs = cod.executeQuery();
            while(rs.next()){
                obj.setCliente(rs.getInt("Cliente_IdCliente"));
                obj.setFuncionario(rs.getInt("Funcionario_idFuncionario"));
                obj.setIdAtende(rs.getInt("idAtende"));
                return obj;
            }
        }catch(SQLException ex){
            System.out.println("Erro de SQL "+ex.getMessage());
            return null;
        }
         return null;
     } 
}
