package com.cluster;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MyHibernateDBUtil {

	private static final SessionFactory sf = buildSessiongFactory();

	private static SessionFactory buildSessiongFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();

		Properties properties = configuration.getProperties();

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();

		StandardServiceRegistry sr = srb.applySettings(properties).build();

		SessionFactory sessionFactory = configuration.buildSessionFactory(sr);

		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

}
