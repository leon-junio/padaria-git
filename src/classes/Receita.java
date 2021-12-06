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
public class Receita {
    private String nome,descricao;
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private float preco;
    private int idReceita;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }
    
}
