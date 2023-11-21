package ru.otus.pro.psannikov.jdbc.crm.repository;

import ru.otus.pro.psannikov.jdbc.core.repository.DataTemplate;
import ru.otus.pro.psannikov.jdbc.core.repository.DataTemplateException;
import ru.otus.pro.psannikov.jdbc.core.repository.executor.DbExecutor;
import ru.otus.pro.psannikov.jdbc.crm.model.Client;
import ru.otus.pro.psannikov.jdbc.crm.model.Manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ManagerDataTemplateJdbc implements DataTemplate<Manager> {
    private final DbExecutor dbExecutor;

    public ManagerDataTemplateJdbc(DbExecutor dbExecutor) {
        this.dbExecutor = dbExecutor;
    }
    @Override
    public Optional<Manager> findById(Connection connection, long id) {
        return dbExecutor.executeSelect(connection, "select no, label, param1 from manager where no  = ?", List.of(id), rs -> {
            try {
                if (rs.next()) {
                    return new Manager(rs.getLong("no"), rs.getString("label"), rs.getString("param1"));
                }
                return null;
            } catch (SQLException e) {
                throw new DataTemplateException(e);
            }
        });
    }

    @Override
    public List<Manager> findAll(Connection connection) {
        return dbExecutor.executeSelect(connection, "select * from manager", Collections.emptyList(), rs -> {
            var managerList = new ArrayList<Manager>();
            try {
                while (rs.next()) {
                    managerList.add(new Manager(rs.getLong("no"), rs.getString("label"), rs.getString("param1")));
                }
                return managerList;
            } catch (SQLException e) {
                throw new DataTemplateException(e);
            }
        }).orElseThrow(() -> new RuntimeException("Unexpected error"));
    }

    @Override
    public long insert(Connection connection, Manager manager) {
        try {
            return dbExecutor.executeStatement(connection,
                    "insert into manager(label, param1) values (?,?)",
                    List.of(manager.getLabel(), manager.getParam1()));
        } catch (Exception e) {
            throw new DataTemplateException(e);
        }
    }

    @Override
    public void update(Connection connection, Manager manager) {
        try {
            dbExecutor.executeStatement(connection, "update manager set label = ? where id = ?",
                    List.of(manager.getLabel(), manager.getNo()));
        } catch (Exception e) {
            throw new DataTemplateException(e);
        }
    }
}
