
package com.badBoys.dao;

import com.badBoys.modelo.Clientes;
import com.badBoys.utiles.ConexcionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAOimpl extends ConexcionDB implements ClientesDAO {

    @Override
    public void insert(Clientes cli) throws Exception {
         try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO clientes (ci,nombres,apellidos,celular)  VALUES(?,?,?,?)");
            ps.setString(1, cli.getCi());
            ps.setString(2, cli.getNombres());
            ps.setString(3,cli.getApellidos());
            ps.setString(4,cli.getCelular());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Clientes cli) throws Exception {
    try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("UPDATE clientes  SET ci=?,nombres=?,apellidos=?,celular=? WHERE cod_cliente=?");
            ps.setString(1, cli.getCi());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getApellidos());
            ps.setString(4, cli.getCelular());
            ps.setInt(5, cli.getCod_cliente());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM clientes WHERE cod_cliente=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Clientes getById(int id) throws Exception {
    Clientes cli= new Clientes();
         try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM clientes WHERE cod_cliente=?");                        
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setCi(rs.getString("ci"));
                cli.setNombres(rs.getString("nombres"));                
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCelular(rs.getString("celular"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
         return cli;
    }

    @Override
    public List<Clientes> getlAll() throws Exception {
    List<Clientes> lista=null;
        try {
            this.conectar();            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM clientes");
            ResultSet rs=ps.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
                Clientes cli= new Clientes();
                cli.setCod_cliente(rs.getInt("cod_cliente"));
                cli.setCi(rs.getString("ci"));                
                cli.setNombres(rs.getString("nombres"));                
                cli.setApellidos(rs.getString("apellidos"));
                cli.setCelular(rs.getString("celular"));
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
