package model;

import model.Entity.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Model {
    private Factory factoryObj = new Factory();
    private SessionFactory factory = factoryObj.getFactory();
    Session session = factory.getCurrentSession();

    //FOR TESTING
    public static void main(String[] args) {
        Model model = new Model();
        School kth = new School("KTH");
        model.saveSchool(kth);
        School su = new School("Stockholms Universitet");
        model.saveSchool(su);
        School ltu = new School("Lunds Tekniska Universitet");
        model.saveSchool(ltu);

    }

    public void saveSchool(School school){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(school);
        session.getTransaction().commit();
    }
}
