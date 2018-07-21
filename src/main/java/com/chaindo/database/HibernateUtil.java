package com.chaindo.database;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory ;
    static {
        String hibernatePropsFilePath = "/Users/lincongli/Desktop/startup/backend-prototype/gradle-practice/src/resources/hibernate.cfg.xml";
        File hibernatePropsFile = new File(hibernatePropsFilePath);
        Configuration configuration = new Configuration().configure(hibernatePropsFile);
        System.out.println("**********");
        System.out.println(configuration.toString());
        System.out.println("**********");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
