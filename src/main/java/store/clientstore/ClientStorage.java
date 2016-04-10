package store.clientstore;

import models.clients.IClient;
import store.Storage;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 04.04.16
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public interface ClientStorage extends Storage<IClient> {

    @Override
    Collection<IClient> getAllValues();

    @Override
    int add(IClient user);

    @Override
    void deleteAll();

    @Override
    void delete(int id);

    @Override
    void edit(IClient user);

}
