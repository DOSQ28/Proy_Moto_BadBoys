package com.badBoys.utiles;

import com.badBoys.dao.VentasDAO;
import com.badBoys.dao.VentasDAOimpl;
import com.badBoys.modelo.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RespCSV", urlPatterns = {"/RespCSV"})
public class RespCSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/csv");
        response.setHeader("Content-Disposition", "attachment;filename=archivo.csv");
        PrintWriter out = response.getWriter();
        VentasDAO dao = new VentasDAOimpl();
        try {
            List<Ventas> lista = dao.getlAll();
            try {
            for (int i = 0; i < lista.size(); i++) {                
                    out.println(lista.get(i).getCod_ventas()+";"+lista.get(i).getCliente()+";"+lista.get(i).getEmpleado()+";"+lista.get(i).getFecha()+";"+lista.get(i).getId_moto()+";"+lista.get(i).getTotal()+";"+lista.size());                                   
            }
                } finally {
                    out.close();
                }
        } catch (Exception ex) {
            System.out.println("Error :"+ex.getMessage());
        }
    }

}
