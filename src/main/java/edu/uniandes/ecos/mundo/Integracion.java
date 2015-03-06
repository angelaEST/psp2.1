/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

/**
 * Contiene los atributos principales relacionados con el cálculo de la integración
 * @author Angela Edith Suárez Torres
 */
public class Integracion {
    
    private int numSeg;
    private double valX;
    private double dof;
    private double p;
 
    
    /**
     * Método por el cual se obtiene el valor para el número de segmentos
     * @return 
     */
    public int getNumSeg() {
        return numSeg;
    }

    /**
     * Método a partir del cual se  envía  el valor para el número de segmentos
     * @param numSeg 
     */
    public void setNumSeg(int numSeg) {
        this.numSeg = numSeg;
    }

    /**
     * Método a partir del cual se  obtiene  el valor para x
     * @return 
     */
    public double getValX() {
        return valX;
    }

    /**
     * Método a partir del cual se  envía  el valor para x
     * @param valX 
     */
    public void setValX(double valX) {
        this.valX = valX;
    }

    /**
     * Método por el cual se obtiene el valor para dof
     * @return 
     */
    public double getDof() {
        return dof;
    }

    /**
     * Método a partir del cual se  envía  el valor para dof
     * @param dof 
     */
    public void setDof(double dof) {
        this.dof = dof;
    }

    /**
     * Método por el cual se obtiene el valor para p
     * @return 
     */
    public double getP() {
        return p;
    }

    /**
     * Método a partir del cual se  envía  el valor para p
     * @param p 
     */
    public void setP(double p) {
        this.p = p;
    }
    
    
    
}
