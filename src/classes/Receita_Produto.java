/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Leon Jr
 */
public class Receita_Produto {
    private int produto;
    private int receita;
    private int idReceita_do_Produto;

    public int getIdReceita_do_Produto() {
        return idReceita_do_Produto;
    }

    public void setIdReceita_do_Produto(int idReceita_do_Produto) {
        this.idReceita_do_Produto = idReceita_do_Produto;
    }
    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getReceita() {
        return receita;
    }

    public void setReceita(int receita) {
        this.receita = receita;
    }

 
    
}
