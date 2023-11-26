package ru.otus.pro.psannikov.hibernate.util;


import org.hibernate.SessionFactory;
import ru.otus.pro.psannikov.hibernate.enums.SessionFactoryType;

import static ru.otus.pro.psannikov.hibernate.configurations.AnnotationBasedSessionFactory.getAnnotationBasedSessionFactory;
import static ru.otus.pro.psannikov.hibernate.configurations.JavaBasedSessionFactory.getJavaBasedSessionFactory;
import static ru.otus.pro.psannikov.hibernate.configurations.XmlBasedSessionFactory.getXmlBasedSessionFactory;

public class HibernateUtilImpl implements HibernateUtil {

	@Override
	public SessionFactory buildSessionFactory(SessionFactoryType type) {
		return switch (type) {
			case ANNOTATION_BASED -> getAnnotationBasedSessionFactory();
			case JAVA_BASED -> getJavaBasedSessionFactory();
			case XML_BASED -> getXmlBasedSessionFactory();
		};
	}
}