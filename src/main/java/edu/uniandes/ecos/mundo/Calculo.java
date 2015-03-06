/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

/**
 * Contiene los m�todos ejecutados para aplicar c�lculos matem�ticos
 *
 * @author Angela Edith Su�rez Torres
 */
public class Calculo {

    /**
     * Calcula gamma de un valor entero
     *
     * @param valor
     * @return entero valor resultante de factorial
     */
    public int calcularGamma(double valor) {
        double n = valor - 1;
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = resultado * i;
        }
        return resultado;
    }

    /**
     * Calcula gamma de una fracci�n
     *
     *
     * @param valor
     * @return double valor resultante de factorial para fracci�n
     */
    public double calcularGammaFraccion(double valor) {
        double n = valor - 1;
        double resultado = 1;
        for (double i = n; i > 0; i--) {
            if (i == 0.5) {
                resultado = resultado * Math.sqrt(Math.PI) * i;
            } else {
                resultado = resultado * i;
            }
        }
        return resultado;
    }

    /**
     * Valida si el c�lculo de Gamma debe aplicarse a un entero o a una fracci�n
     *
     *
     * @param valor
     * @return resultado de c�lculo de Gamma aplicado a entero o a fracci�n
     */
    public double validarCalculoGamma(double valor) {
        double resultado = 0;
        if (valor % 1 != 0) {
            resultado = calcularGammaFraccion(valor);
        } else {
            resultado = calcularGamma(valor);
        }
        return resultado;
    }

    /**
     * Aplica la ecuaci�n para el c�lculo de la integraci�n num�rica
     *
     * @param x Valor que toma x con cada iteraci�n para la funci�n
     * @param dof Grado de libertad
     * @param multiplicador Factor por el cual la funci�n ser� multiplicada
     * @param ancho El ancho contiene el valor resultante de x en su �ltima
     * iteraci�n / el n�mero de segmentos ingresado
     * @return double, valor resultante de la funci�n aplicada
     */
    public double calcularSerie(double x, double dof, int multiplicador, double ancho) {
        return (ancho / 3) * (multiplicador * (((validarCalculoGamma((dof + 1) / 2)) / ((Math.pow((dof * Math.PI), 0.5))
                * (validarCalculoGamma(dof / 2)))) * (Math.pow((1 + (Math.pow(x, 2)) / dof),
                        -((dof + 1) / 2)))));
    }

    /**
     * M�todo que retorna el valor de x resultante del aplicar ajuste sobre distribuci�n en p para
     * integraci�n num�rica
     *
     * @param integracion El Objeto Integracion tiene los atributos capturados
     * por consola
     * @return
     */
    public double cargarIntegracionNumerica(Integracion integracion) {
        double p = 0;
        double error = 0.00030;

        double numeroDegmentos = integracion.getNumSeg();
        boolean iteracionAdicional = false;
        double x = getX(integracion.getValX(), true);
        do {
            p = 0;
            for (int i = 0; i <= numeroDegmentos; i++) {
                double ancho = x / numeroDegmentos;
                int multiplicador;
                double xi = ancho * i;
                if (i == 0 || i == numeroDegmentos) {
                    multiplicador = 1;
                } else if (i % 2 != 0) {
                    multiplicador = 4;
                } else {
                    multiplicador = 2;
                }
                p = p + calcularSerie(xi, integracion.getDof(), multiplicador, ancho);
            }
            if (p > integracion.getP() && p < integracion.getP() + error) {
                return x;
            } else {
                iteracionAdicional = true;
                if (p < integracion.getP()) {
                    x = getX(x, true);
                } else {
                    x = getX(x, false);
                }
            }
        } while (iteracionAdicional);

        return x;
    }

    /**
     * Retorna x seg�n x axtual
     * @param xActual
     * @param add
     * @return x decrementado o incrementado
     */
    public double getX(double xActual, boolean add) {
        double ajuste = 0.0000025;
        if (add) {
            return xActual + ajuste;
        } else {
            return xActual - ajuste;
        }

    }
}
