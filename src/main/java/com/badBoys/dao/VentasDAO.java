
package com.badBoys.dao;

import com.badBoys.modelo.Ventas;
import java.util.List;

public interface VentasDAO {
public void insert(Ventas ven) throws Exception;

    public void update(Ventas ven) throws Exception;

    public void delete(int id) throws Exception;

    public Ventas getById(int id) throws Exception;

    public List<Ventas > getlAll() throws Exception;        
}
