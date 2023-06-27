
package com.badBoys.dao;

import com.badBoys.modelo.Clientes;
import java.util.List;


public interface ClientesDAO {
    public void insert(Clientes cliente) throws Exception;

    public void update(Clientes cliente) throws Exception;

    public void delete(int id) throws Exception;

    public Clientes getById(int id) throws Exception;

    public List<Clientes> getlAll() throws Exception;
}
