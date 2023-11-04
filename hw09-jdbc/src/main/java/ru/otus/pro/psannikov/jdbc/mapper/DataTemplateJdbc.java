package ru.otus.pro.psannikov.jdbc.mapper;

import ru.otus.pro.psannikov.jdbc.core.repository.DataTemplate;
import ru.otus.pro.psannikov.jdbc.core.repository.executor.DbExecutor;
import ru.otus.pro.psannikov.jdbc.crm.model.ClassesName;
import ru.otus.pro.psannikov.jdbc.crm.model.Client;
import ru.otus.pro.psannikov.jdbc.crm.model.Manager;
import ru.otus.pro.psannikov.jdbc.crm.repository.ClientDataTemplateJdbc;
import ru.otus.pro.psannikov.jdbc.crm.repository.ManagerDataTemplateJdbc;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * Сохратяет объект в базу, читает объект из базы
 */
public class DataTemplateJdbc<T> implements DataTemplate<T> {

    private final DbExecutor dbExecutor;
    private final EntitySQLMetaData entitySQLMetaData;
    private Class templateClass;

    public DataTemplateJdbc(DbExecutor dbExecutor, EntitySQLMetaData entitySQLMetaData, Class templateClass) {
        this.dbExecutor = dbExecutor;
        this.entitySQLMetaData = entitySQLMetaData;
        this.templateClass = templateClass;
    }

    @Override
    public Optional<T> findById(Connection connection, long id) {
        if (templateClass.getSimpleName().equals(ClassesName.CLIENT.getTitle())) {
            DataTemplate<Client> clientDataTemplateJdbc = new ClientDataTemplateJdbc(dbExecutor);
            return (Optional<T>) clientDataTemplateJdbc.findById(connection,id);
        }
        if (templateClass.getSimpleName().equals(ClassesName.MANAGER.getTitle())) {
            DataTemplate<Manager> managerDataTemplate = new ManagerDataTemplateJdbc(dbExecutor);
            return (Optional<T>) managerDataTemplate.findById(connection,id);
        }
        throw new UnsupportedOperationException();}

    @Override
    public List<T> findAll(Connection connection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long insert(Connection connection, T object) {
        if (templateClass.getSimpleName().equals(ClassesName.CLIENT.getTitle())) {
            DataTemplate<Client> clientDataTemplateJdbc = new ClientDataTemplateJdbc(dbExecutor);
            return clientDataTemplateJdbc.insert(connection, (Client) object);
        } else if (templateClass.getSimpleName().equals(ClassesName.MANAGER.getTitle())) {
            DataTemplate<Manager> managerDataTemplate = new ManagerDataTemplateJdbc(dbExecutor);
            return managerDataTemplate.insert(connection, (Manager) object);
        }
        {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void update(Connection connection, T client) {
        throw new UnsupportedOperationException();
    }
}
