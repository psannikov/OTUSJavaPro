package ru.otus.pro.psannikov.nosql.cassandra.schema;

public interface CassandraSchemaInitializer {
    void initSchema();
    void dropSchemaIfExists();
}
