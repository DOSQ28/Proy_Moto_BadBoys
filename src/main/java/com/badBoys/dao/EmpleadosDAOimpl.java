package com.badBoys.dao;

import com.badBoys.modelo.Empleados;
import com.badBoys.utiles.ConexcionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDAOimpl extends ConexcionDB implements EmpleadosDAO {

    @Override
    public void insert(Empleados emp) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO empleado (ci,nombres,apellidos,celular,direccion)  VALUES(?,?,?,?,?)");
            ps.setString(1, emp.getCi());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getCelular());
            ps.setString(5, emp.getDireccion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Empleados emp) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE empleado  SET ci=?,nombres=?,apellidos=?,celular=?,direccion=? WHERE cod_empleado=?");
            ps.setString(1, emp.getCi());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getCelular());
            ps.setString(5, emp.getDireccion());
            ps.setInt(6, emp.getCod_empleado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM empleado WHERE cod_empleado=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Empleados getById(int id) throws Exception {
        Empleados cli = new Empleados();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM empleado WHERE cod_empleado=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cli.setCod_empleado(rs.getInt("cod_empleado"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCelular(rs.getString("celular"));
                cli.setDireccion(rs.getString("direccion"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Empleados> getlAll() throws Exception {
        List<Empleados> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM empleado");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Empleados cli = new Empleados();
                cli.setCod_empleado(rs.getInt("cod_empleado"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCelular(rs.getString("celular"));
                cli.setDireccion(rs.getString("direccion"));
                lista.add(cli);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
