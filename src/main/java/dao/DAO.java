package dao;

import java.util.List;

public interface DAO {
    Object get(int id);
    List<Object> getAll();
    void save(Object object);
}
