package ru.otus.pro.psannikov.hibernate;

import jakarta.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.otus.pro.psannikov.hibernate.dtos.BankDto;
import ru.otus.pro.psannikov.hibernate.entities.Bank;
import ru.otus.pro.psannikov.hibernate.entities.City;
import ru.otus.pro.psannikov.hibernate.entities.Email;
import ru.otus.pro.psannikov.hibernate.enums.SessionFactoryType;
import ru.otus.pro.psannikov.hibernate.util.HibernateUtilImpl;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Random;

public class HibernateOtusExampleMain {

	private static final Log LOGGER = LogFactory.getLog(MethodHandles.lookup().lookupClass());

	public static void main(String[] args) {

		SessionFactory sessionFactory = new HibernateUtilImpl()
				.buildSessionFactory(SessionFactoryType.JAVA_BASED);

		//insertNewBank(sessionFactory);
		//insertNewCity(sessionFactory);
		//insertNewEmail(sessionFactory);
		//selectBank(sessionFactory);


		sessionFactory.close();

	}

	private static void insertNewBank(SessionFactory sessionFactory) {

		Bank bank = generateRandomBank();

		//start transaction
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Bank merged = session.merge(bank);
		session.getTransaction().commit();

		LOGGER.info("A new Bank with id " + merged.getId() + " has been created!");
		// close transaction
		session.close();

	}

	private static void insertNewCity(SessionFactory sessionFactory) {

		City city = new City();
		city.setName("Samara");

		//start transaction
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		City merged = session.merge(city);
		session.getTransaction().commit();

		LOGGER.info("A new City with id " + merged.getId() + " has been created!");
		// close transaction
		session.close();

	}

	private static void insertNewEmail(SessionFactory sessionFactory) {

		Email email = new Email();
		email.setInbox("my@inbox.com");

		//start transaction
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Email merged = session.merge(email);
		session.getTransaction().commit();

		LOGGER.info("A new Email with id " + merged.getId() + " has been created!");
		// close transaction
		session.close();

	}

	private static void selectBank(SessionFactory sessionFactory) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createNativeQuery("SELECT b.id, b.name, b.city FROM Bank b", Bank.class);

		List<Bank> rows = query.getResultList();

		rows.stream()
			.map(row -> BankDto.builder()
			.id(row.getId())
			.name(row.getName())
			.build())
			.forEach(build -> LOGGER.info("A Bank with id " + build.getId() + " has been selected!"));

		session.close();

	}

	private static Bank generateRandomBank() {
		return Bank.builder().name("SuperBank_" + new Random(100).nextInt()).build();
	}

}