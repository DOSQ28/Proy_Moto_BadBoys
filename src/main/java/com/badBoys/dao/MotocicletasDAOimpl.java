package com.badBoys.dao;

import com.badBoys.modelo.Empleados;
import com.badBoys.modelo.Motocicletas;
import com.badBoys.utiles.ConexcionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MotocicletasDAOimpl extends ConexcionDB implements MotocicletasDAO {

    @Override
    public void insert(Motocicletas mo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO motocicletas (descripcion,placa,marca,tipo,color,precio)  VALUES(?,?,?,?,?,?)");
            //ps.setString(1, mo.getImg());
            ps.setString(1, mo.getDescripcion());
            ps.setString(2, mo.getPlaca());
            ps.setString(3, mo.getMarca());
            ps.setString(4, mo.getTipo());
            ps.setString(5, mo.getColor());
            ps.setInt(6, mo.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Motocicletas mo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE motocicletas  SET descripcion=?,placa=?,marca=?,tipo=?,color=?,precio=? WHERE cod_moto=?");
            //ps.setString(1, mo.getImg());
            ps.setString(1, mo.getDescripcion());
            ps.setString(2, mo.getPlaca());
            ps.setString(3, mo.getMarca());
            ps.setString(4, mo.getTipo());
            ps.setString(5, mo.getColor());
            ps.setInt(6, mo.getPrecio());
            ps.setInt(7, mo.getCod_moto());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM motocicletas WHERE cod_moto=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Motocicletas getById(int id) throws Exception {
        Motocicletas mo = new Motocicletas();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM motocicletas WHERE cod_moto=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mo.setCod_moto(rs.getInt("cod_moto"));
                mo.setDescripcion(rs.getString("descripcion"));
                mo.setPlaca(rs.getString("placa"));
                mo.setMarca(rs.getString("marca"));
                mo.setTipo(rs.getString("tipo"));
                mo.setColor(rs.getString("color"));
                mo.setPrecio(rs.getInt("precio"));
            //    mo.setImg(rs.getString("img"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return mo;
    }

    @Override
    public List<Motocicletas> getlAll() throws Exception {
        List<Motocicletas> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM motocicletas");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Motocicletas cli = new Motocicletas();
                cli.setCod_moto(rs.getInt("cod_moto"));
                cli.setDescripcion(rs.getString("descripcion"));
                cli.setPlaca(rs.getString("placa"));
                cli.setTipo(rs.getString("marca"));
                cli.setColor(rs.getString("tipo"));
                cli.setPrecio(rs.getInt("precio"));
            //    cli.setImg(rs.getString("img"));
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
