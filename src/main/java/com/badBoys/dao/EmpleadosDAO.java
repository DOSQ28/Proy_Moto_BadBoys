package com.badBoys.dao;

import com.badBoys.modelo.Empleados;
import java.util.List;

public interface EmpleadosDAO {

    public void insert(Empleados emp) throws Exception;

    public void update(Empleados emp) throws Exception;

    public void delete(int id) throws Exception;

    public Empleados getById(int id) throws Exception;

    public List<Empleados> getlAll() throws Exception;
}
