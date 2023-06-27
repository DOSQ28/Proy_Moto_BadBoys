package com.badBoys.controlador;

import com.badBoys.dao.ClientesDAO;
import com.badBoys.dao.ClientesDAOimpl;
import com.badBoys.dao.EmpleadosDAO;
import com.badBoys.dao.EmpleadosDAOimpl;
import com.badBoys.dao.MotocicletasDAO;
import com.badBoys.dao.MotocicletasDAOimpl;
import com.badBoys.dao.VentasDAO;
import com.badBoys.dao.VentasDAOimpl;
import com.badBoys.modelo.Clientes;
import com.badBoys.modelo.Empleados;
import com.badBoys.modelo.Motocicletas;
import com.badBoys.modelo.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            VentasDAO dao = new VentasDAOimpl();
            EmpleadosDAO daoEmp = new EmpleadosDAOimpl();
            ClientesDAO daoCli = new ClientesDAOimpl();
            MotocicletasDAO daoMoe = new MotocicletasDAOimpl();
            int id; //edita o eliminar
            List<Empleados> lista_empleados = null;
            List<Clientes> lista_clientes = null;
            List<Motocicletas> lista_motocicletas = null;
            //opracion de adicion, edicion,eliminacion
            Ventas venta = new Ventas();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_empleados = daoEmp.getlAll();
                    lista_clientes = daoCli.getlAll();
                    lista_motocicletas = daoMoe.getlAll();
                    request.setAttribute("lista_empleados", lista_empleados);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("lista_motocicletas", lista_motocicletas);
                    //objeto venta 
                    request.setAttribute("venta", venta); //esta vacio este es otro
                    request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    venta = dao.getById(id);
                    lista_empleados = daoEmp.getlAll();
                    lista_clientes = daoCli.getlAll();
                    lista_motocicletas = daoMoe.getlAll();
                    request.setAttribute("lista_empleados", lista_empleados);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("lista_motocicletas", lista_motocicletas);
                    request.setAttribute("venta", venta); //esta vacio
                    request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                    break;
                case "view":
                    List<Ventas> lista = dao.getlAll();
                    request.setAttribute("ventas", lista);//atributo ventas
                    //enviar a la vista
                    request.getRequestDispatcher("ListVentas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VentasDAO dao = new VentasDAOimpl();
        // si es 0 es nuevo
        int id = Integer.parseInt(request.getParameter("id"));
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        int id_moto = Integer.parseInt(request.getParameter("id_moto"));
        String fecha = request.getParameter("fecha");
        double total = Double.parseDouble(request.getParameter("total"));

        Ventas venta = new Ventas();
        venta.setCod_ventas(id);
        venta.setId_empleado(id_empleado);
        venta.setId_cliente(id_cliente);
        venta.setId_moto(id_moto);
        venta.setFecha(ConvierteFecha(fecha));
        venta.setTotal(total);
        if (id == 0) {
            //nuevo           
            try {
                dao.insert(venta);
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        } else {
            //MODIFICAR                         
            try {
                dao.update(venta);
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
        response.sendRedirect("VentaControlador");
    }

    Date ConvierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return fechaBD;
    }
}
