package ru.otus.pro.psannikov.hibernate.configurations;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.otus.pro.psannikov.hibernate.entities.Bank;

import java.lang.invoke.MethodHandles;

public class XmlBasedSessionFactory {

    private static final Log LOGGER = LogFactory.getLog(MethodHandles.lookup().lookupClass());

    public static SessionFactory getXmlBasedSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("xml-based/hibernate.cfg.xml");

            configuration.addAnnotatedClass(Bank.class);

            LOGGER.info("Hibernate Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
            .build();

            LOGGER.info("Hibernate serviceRegistry created");

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            LOGGER.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}