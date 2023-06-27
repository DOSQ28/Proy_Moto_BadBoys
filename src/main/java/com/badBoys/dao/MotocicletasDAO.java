
package com.badBoys.dao;

import com.badBoys.modelo.Motocicletas;
import java.util.List;

public interface MotocicletasDAO {
    public void insert(Motocicletas mot) throws Exception;

    public void update(Motocicletas mot) throws Exception;

    public void delete(int id) throws Exception;

    public Motocicletas getById(int id) throws Exception;

    public List<Motocicletas> getlAll() throws Exception;
}
