package com.badBoys.controlador;

import com.badBoys.dao.EmpleadosDAO;
import com.badBoys.dao.EmpleadosDAOimpl;
import com.badBoys.modelo.Empleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/EmpleadoControlador"})
public class EmpleadoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Empleados emp = new Empleados();
            int id;
            EmpleadosDAO dao = new EmpleadosDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    emp = dao.getById(id);
                    request.setAttribute("empleado", emp);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EmpleadoControlador");
                    break;
                case "view":
                    //Obtener la lista de registros
                    System.out.println("view");
                    List<Empleados> lista = dao.getlAll();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("ListEmpleados.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmpleadosDAO dao = new EmpleadosDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String ci = request.getParameter("ci");
        String nom = request.getParameter("nombres");
        String ap = request.getParameter("apellidos");
        String cel = request.getParameter("celular");
        String dir = request.getParameter("direccion");
        Empleados cli = new Empleados();
        cli.setCod_empleado(id);
        cli.setCi(ci);
        cli.setNombres(nom);
        cli.setApellidos(ap);
        cli.setCelular(cel);
        cli.setDireccion(dir);
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(cli);

            } catch (Exception ex) {
                System.out.println("Error al insertar" + ex.getMessage());
            }
        } else {
            //edicion del registro
            try {
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al Editar" + ex.getMessage());
            }
        }
        response.sendRedirect("EmpleadoControlador");
    }

}
