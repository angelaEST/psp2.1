package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.mundo.Integracion;
import edu.uniandes.ecos.presentacion.PaintingText;
import java.util.Scanner;

public class App {

     /**
     * Método principal para la ejecución del programa. Solicita por consola los datos iniciales para el cálculo a aplicar.
     * @param args 
     */
    public static void main(String[] args) {
        Calculo calculo = new Calculo();
        Integracion integracion = new Integracion();
        Scanner capturaDatos = new Scanner(System.in);
        
        int numSeg;
        double p;
        double dof;
        do {
            System.out.println("\n Ingrese el número inicial de segmentos, debe ser un número par : ");
            numSeg = capturaDatos.nextInt();
        } while (numSeg % 2 != 0);

        do {
            System.out.println("\n Utilice (,) como separador. Ingrese el valor para p, debe ser mayor a cero : ");
            p = capturaDatos.nextDouble();
        } while (p <= 0);

        do {
            System.out.println("\n Ingrese el valor para dof, debe ser mayor a cero : ");
            dof = capturaDatos.nextDouble();
        } while (dof <= 0);

        integracion.setDof(dof);
        integracion.setNumSeg(numSeg);
        integracion.setP(p);
        integracion.setValX(1.0);
        
        double resultadoIntegracion = calculo.cargarIntegracionNumerica(integracion);
        PaintingText paintingText = new PaintingText();
        paintingText.colorearResultado(resultadoIntegracion);

    }
}
