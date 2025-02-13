package com.wipro.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    private static SessionFactory sessionFactory;

    public static SessionFactory provideSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.configure("resources/hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
