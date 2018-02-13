package model;

import model.Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
    private static SessionFactory factory = new Configuration().configure()
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .addAnnotatedClass(School.class)
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        Factory.factory = factory;
    }

    public Factory() {
    }
}
