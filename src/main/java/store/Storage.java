package store;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 20:21
 * To change this template use File | Settings | File Templates.
 */

public interface Storage <T> {

    public Collection<T> getAllValues();
    public int add(T user);
    public void deleteAll();
    void delete(int id );
    void edit(T user);
    T getById(int id);
    public Collection<T> getAllObjById(int id);
    public void close();
    public Collection<T> getAllClientsWithSameType(String type);

}

