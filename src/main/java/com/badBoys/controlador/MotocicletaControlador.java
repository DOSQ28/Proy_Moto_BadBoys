
package com.badBoys.controlador;

import com.badBoys.dao.MotocicletasDAO;
import com.badBoys.dao.MotocicletasDAOimpl;
import com.badBoys.modelo.Motocicletas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MotocicletaControlador", urlPatterns = {"/MotocicletaControlador"})
public class MotocicletaControlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
            Motocicletas mot = new Motocicletas();
            int id;
            MotocicletasDAO dao = new MotocicletasDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("motocicleta", mot);
                    request.getRequestDispatcher("Motocicletas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    mot = dao.getById(id);
                    request.setAttribute("motocicleta", mot);
                    request.getRequestDispatcher("Motocicletas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("MotocicletaControlador");
                    break;
                case "view":
                    //Obtener la lista de registros
                    System.out.println("view");
                    List<Motocicletas> lista = dao.getlAll();
                    request.setAttribute("motocicletas", lista);
                    request.getRequestDispatcher("ListMotocicletas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MotocicletasDAO dao = new MotocicletasDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String des = request.getParameter("descripcion");
        String pla = request.getParameter("placa");
        String mar = request.getParameter("marca");
        String tipo = request.getParameter("tipo");
        String col = request.getParameter("color");
        int pre = Integer.parseInt(request.getParameter("precio"));
        //String img = request.getParameter("img");
        Motocicletas mo = new Motocicletas();        
        mo.setCod_moto(id);
        mo.setDescripcion(des);
        mo.setPlaca(pla);
        mo.setMarca(mar);
        mo.setTipo(tipo);
        mo.setColor(col);
        mo.setPrecio(pre);
        //mo.setImg(img);
       
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(mo);

            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion del registro
            try {
                dao.update(mo);
            } catch (Exception ex) {
                System.out.println("Error al Editar" + ex.getMessage());
            }
        }
        response.sendRedirect("MotocicletaControlador");
    }

}
