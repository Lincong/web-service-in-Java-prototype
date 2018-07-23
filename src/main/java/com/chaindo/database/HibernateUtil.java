package com.chaindo.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory ;
    static {
        // TODO
        String hibernatePropsFilePath = "/Users/lincongli/Desktop/startup/backend-prototype/gradle-practice/src/main/resources/hibernate.cfg.xml";
        File hibernatePropsFile = new File(hibernatePropsFilePath);
        Configuration config = new Configuration().configure(hibernatePropsFile);
        config.addAnnotatedClass(com.chaindo.database.UserTest.class);

        ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(servReg);
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
