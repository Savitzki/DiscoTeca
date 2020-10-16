package model.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marina Savitzki
 * @param <T>
 */
public interface InterfaceDAO<T> {

    //CRUD
    public abstract boolean create(T objeto) throws SQLException;

    public abstract List<T> read() throws SQLException;

    public abstract List<T> read(int id) throws SQLException;

    public abstract List<T> read(String string, int id) throws SQLException;

    public abstract boolean update(T objeto, int id) throws SQLException;

    public abstract boolean delete(int id) throws SQLException;

}
