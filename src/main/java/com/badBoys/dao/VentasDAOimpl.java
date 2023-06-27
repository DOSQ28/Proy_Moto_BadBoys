package com.badBoys.dao;

import com.badBoys.modelo.Ventas;
import com.badBoys.utiles.ConexcionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentasDAOimpl extends ConexcionDB implements VentasDAO {

    @Override
    public void insert(Ventas ven) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ventas (id_empleado,id_cliente,id_moto,fecha,total)  VALUES(?,?,?,?,?)");
            ps.setInt(1, ven.getId_empleado());
            ps.setInt(2, ven.getId_cliente());
            ps.setInt(3, ven.getId_moto());
            ps.setDate(4, ven.getFecha());
            ps.setDouble(5, ven.getTotal());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Ventas ven) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ventas SET id_empleado=?,id_cliente=?,id_moto=?,fecha=?,total=? WHERE cod_ventas=?");
            ps.setInt(1, ven.getId_empleado());
            ps.setInt(2, ven.getId_cliente());
            ps.setInt(3, ven.getId_moto());
            ps.setDate(4, ven.getFecha());
            ps.setDouble(5, ven.getTotal());
            ps.setDouble(6, ven.getCod_ventas());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ventas WHERE cod_ventas=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Ventas getById(int id) throws Exception {
        Ventas mo = new Ventas();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM ventas WHERE cod_ventas=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mo.setCod_ventas(rs.getInt("cod_ventas"));
                mo.setId_empleado(rs.getInt("id_empleado"));
                mo.setId_cliente(rs.getInt("id_cliente"));
                mo.setId_moto(rs.getInt("id_moto"));
                mo.setFecha(rs.getDate("fecha"));
                mo.setTotal(rs.getDouble("total"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mo;
    }

    @Override
    public List<Ventas> getlAll() throws Exception {
        List<Ventas> lista = null;
        try {
            this.conectar();
            String sql = "SELECT V.* ,CONCAT(E.nombres ,' ',E.apellidos) AS empleado,concat(c.nombres,' ',c.apellidos) cliente,concat(m.descripcion,' ',m.color,' ',m.placa) motocicleta ";
            sql += "FROM VENTAS V JOIN empleado E ON(V.id_empleado=E.cod_empleado) ";
            sql += " JOIN clientes c ON(c.cod_cliente=V.id_cliente) JOIN motocicletas m ON(m.cod_moto=V.id_moto) ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Ventas ven = new Ventas();
                ven.setCod_ventas(rs.getInt("cod_ventas"));
                ven.setId_empleado(rs.getInt("id_empleado"));                
                ven.setId_cliente(rs.getInt("id_cliente"));                
                ven.setId_moto(rs.getInt("id_moto"));                
                ven.setFecha(rs.getDate("fecha"));
                ven.setTotal(rs.getDouble("total"));
                ven.setEmpleado(rs.getString("empleado"));
                ven.setCliente(rs.getString("cliente"));
                ven.setMotocicleta(rs.getString("motocicleta"));
                lista.add(ven);
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
