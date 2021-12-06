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
public class Cardapio {
   private String tipo;
   private int numero;
   private int idCardapio;

    
    @Override
    public String toString() {
        return getTipo();
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the idCardapio
     */
    public int getIdCardapio() {
        return idCardapio;
    }

    /**
     * @param idCardapio the idCardapio to set
     */
    public void setIdCardapio(int idCardapio) {
        this.idCardapio = idCardapio;
    }
    
    
}
