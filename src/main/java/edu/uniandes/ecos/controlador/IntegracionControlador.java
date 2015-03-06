/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.mundo.Integracion;

import edu.uniandes.ecos.presentacion.PaintingWeb;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author Angela Edith Suarez Torres
 */
public class IntegracionControlador extends HttpServlet {

    /**
     * Método que arranca servidor de prueba-
     * @param args 
     */
    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new IntegracionControlador()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(IntegracionControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
     /**
     * Heredado de javax.servlet.http.HttpServlet, es el método ejecutado cuando el servlet recibe una petición de tipo GET.
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PaintingWeb.presentarOpcion(req, resp);

    }

    @Override
    /**
     * Heredado de javax.servlet.http.HttpServlet, es el método ejecutado cuando el servlet recibe una petición de tipo POST
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integracion integracion = new Integracion();
        Calculo calculo = new Calculo();
        String p = req.getParameter("valp");
        String numSeg = req.getParameter("segmento");
        String dof = req.getParameter("dof");
       try{
        integracion.setDof(Double.valueOf(dof));
        integracion.setNumSeg(Integer.valueOf(numSeg));
        integracion.setP(Double.valueOf(p));
        integracion.setValX(1.0);

        double resultadoIntegracion = calculo.cargarIntegracionNumerica(integracion);
        
        PaintingWeb.showResults(req, resp, resultadoIntegracion,false);
       }catch(NumberFormatException exception){
           System.err.println("Utilice punto(.) como separador de decimales");
           PaintingWeb.showResults(req, resp, 0d,true);
       }
    }
}
