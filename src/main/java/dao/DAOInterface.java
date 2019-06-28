package dao;

import java.util.List;

public interface DAOInterface {
    Object get(int id);
    List<Object> getAll();
    void save(Object object);
}
