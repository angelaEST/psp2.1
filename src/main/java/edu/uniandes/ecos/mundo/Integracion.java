/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

/**
 * Contiene los atributos principales relacionados con el c�lculo de la integraci�n
 * @author Angela Edith Su�rez Torres
 */
public class Integracion {
    
    private int numSeg;
    private Double valX;
    private Double dof;
    private Double p;
 
    
    /**
     * M�todo por el cual se obtiene el valor para el n�mero de segmentos
     * @return 
     */
    public int getNumSeg() {
        return numSeg;
    }

    /**
     * M�todo a partir del cual se  env�a  el valor para el n�mero de segmentos
     * @param numSeg 
     */
    public void setNumSeg(int numSeg) {
        this.numSeg = numSeg;
    }

    /**
     * M�todo a partir del cual se  obtiene  el valor para x
     * @return 
     */
    public double getValX() {
        return valX;
    }

    /**
     * M�todo a partir del cual se  env�a  el valor para x
     * @param valX 
     */
    public void setValX(double valX) {
        this.valX = valX;
    }

    /**
     * M�todo por el cual se obtiene el valor para dof
     * @return 
     */
    public Double getDof() {
        return dof;
    }

    /**
     * M�todo a partir del cual se  env�a  el valor para dof
     * @param dof 
     */
    public void setDof(Double dof) {
        this.dof = dof;
    }

    /**
     * M�todo por el cual se obtiene el valor para p
     * @return 
     */
    public Double getP() {
        return p;
    }

    /**
     * M�todo a partir del cual se  env�a  el valor para p
     * @param p 
     */
    public void setP(Double p) {
        this.p = p;
    }
    
    
    
}
