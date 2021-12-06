/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.DAOCardapio;

/**
 *
 * @author Leon Jr
 */
public class Produto {
    private int idProduto;
    private String nome;
    private float preco;
    private int codigo;
    private int cardapio;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return nome; 
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Cardapio getCard() {
        return card;
    }

    public void setCard(Cardapio card) {
        this.card = card;
    }
    private Cardapio card;
    public int getCardapio() {
        return cardapio;
    }
    public Cardapio getCardapioObj(int id){
    DAOCardapio dao = new DAOCardapio();
    return dao.localizar(id);
    }
    public void setCardapio(int cardapio) {
        this.cardapio = cardapio;
    }
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
