/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angela Edith Suárez Torres
 */
public class PaintingWeb {

    /**
     * Presenta al usuario los campos para ingresar el valor de p, número de segmentos y el valor dof, o grados de libertad
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    public static void presentarOpcion(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP2 INTEGRACION NUMERICA!</h1>");

        pw.println("<body><form action=\"integracion\" method=\"post\">");
        pw.println("</br><table><tr><td>Valor para p :</td>");
        pw.println("<td><input type=\"text\" id=\"cantidadX\" name=\"valp\"></td></tr></br>");
        pw.println("</br><tr><td>Valor para número de segmentos :</td>");
        pw.println("<td><input type=\"text\" id=\"cantidadseg\" name=\"segmento\"></td></tr></br>");
        pw.println("</br><tr><td><Use como separador (.) el punto. Valor para dof :</td>");
        pw.println("<td><input type=\"text\" id=\"cantidaddof\" name=\"dof\"></td></tr></table></br>");
        pw.println("<input type=\"submit\" id=\"acepta\" name=\"acepta\" value=\"Calcular x esperado\">");
        pw.println("</form></body>");
        pw.println("</html>");

    }

    /**
     * Presenta por pantalla el resltado del x ajustado
     * @param req
     * @param resp
     * @param valor
     * @throws ServletException
     * @throws IOException 
     */
    public static void showResults(HttpServletRequest req, HttpServletResponse resp, Double valor, boolean error)
            throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("<html><head><title>PSP2INTEGRACION NUMERICA!</title></head>");
        pw.println("<h1>Resultado: </h1></br>");
        pw.println("<body>");
        pw.println("<table>");
        if(!error ){
        pw.println("<tr><td>******** El resultado para x es:  " + valor + "  ********</td></tr>");
        }else{
        pw.println("<tr><td>******** Utilice como separador (.) punto ********</td></tr>");
        }
        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");

    }
}
