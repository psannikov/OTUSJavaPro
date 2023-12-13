package ru.otus.pro.psannikov.hibernate.util;

import org.hibernate.SessionFactory;
import ru.otus.pro.psannikov.hibernate.enums.SessionFactoryType;

public interface HibernateUtil {
    SessionFactory buildSessionFactory(SessionFactoryType type);
}