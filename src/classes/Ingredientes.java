/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.DAOFornecedor;

/**
 *
 * @author Leon Jr
 */
public class Ingredientes {
    private String nome;
    private int peso;
    private int idIngrediente;
    private int fornecedor;
    private Fornecedor forn;

    public Fornecedor getForn() {
        return forn;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public void setForn(Fornecedor forn) {
        this.forn = forn;
    }
    public Fornecedor getFornecedorObj(){
        DAOFornecedor dao = new DAOFornecedor();
        Fornecedor f = dao.localizar(fornecedor);
        return f;
    }
    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

   

}
