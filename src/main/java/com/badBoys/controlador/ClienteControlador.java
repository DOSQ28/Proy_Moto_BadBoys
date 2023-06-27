package com.badBoys.controlador;

import com.badBoys.dao.ClientesDAO;
import com.badBoys.dao.ClientesDAOimpl;
import com.badBoys.modelo.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Clientes cli = new Clientes();
            int id;
            ClientesDAO dao = new ClientesDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";            
            switch (action) {
                case "add":
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cli = dao.getById(id);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ClienteControlador");
                    break;
                case "view":
                    //Obtener la lista de registros
                    List<Clientes> lista = dao.getlAll();
                    request.setAttribute("clientes", lista);
                    request.getRequestDispatcher("ListClientes.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClientesDAO dao = new ClientesDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String ci = request.getParameter("ci");
        String nom = request.getParameter("nombres");
        String ap = request.getParameter("apellidos");
        String cel = request.getParameter("celular");
        Clientes cli = new Clientes();
        cli.setCod_cliente(id);
        cli.setCi(ci);
        cli.setNombres(nom);
        cli.setApellidos(ap);
        cli.setCelular(cel);
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
        response.sendRedirect("ClienteControlador");
    }
}
