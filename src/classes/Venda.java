/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.DAOCliente;
import dao.DAOFuncionario;
import dao.DAOPagamento;

/**
 *
 * @author Leon Jr
 */
public class Venda {
    private float preco;
    private int pagamento;
    private int idVenda;
    private int funcionario;
    private int cliente;
    
    private Pagamento pag;
    private Cliente cli;
    private Funcionario func;

    public Pagamento getPag() {
        return pag;
    }

    public void setPag(Pagamento pag) {
        this.pag = pag;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
    
    
    
    public Cliente getClienteObj(){
        DAOCliente dao = new DAOCliente();
        Cliente f = dao.localizar(cliente);
        return f;
    }
    
    
    
    public Pagamento getPagamentoObj(){
        DAOPagamento dao = new DAOPagamento();
        Pagamento f = dao.localizar(pagamento);
        return f;
    }
    
    
    
     public Funcionario getFuncionarioObj(){
        DAOFuncionario dao = new DAOFuncionario();
        Funcionario f = dao.localizar(funcionario);
        return f;
    }
    
    
    
    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

   
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    
    
}
