package model;

import model.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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


        Course bp = new Course("IX10 Basic Physics", kth);
        model.saveCourse(bp);
        Course cs = new Course("ID1212 Computer Science", ltu);
        model.saveCourse(cs);
        Course nt = new Course("IT1234 Network Technology", su);
        model.saveCourse(nt);

        User fb = new User("frodo", "pw");
        model.saveUser(fb);
        User bb = new User("bilbo", "pw");
        model.saveUser(bb);
        User g = new User("gandalf", "pw");
        model.saveUser(g);

        Review r1 = new Review(model.getCourse("IX10 Basic Physics").get(0),
                                model.getUser("frodo").get(0),
                                3,4,2,5,
                                "Boring coure, good teacher!");

        System.out.println("Schools in DB: " + model.getAllScools());
        System.out.println("Courses in DB: " + model.getAllCourses());
        System.out.println("Users in DB: " + model.getAllUsers());
        System.out.println("Reviews in DB: " + model.getAllReviews());

    }

    public void saveSchool(School school){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(school);
        session.getTransaction().commit();
    }

    public List<School> getSchool(String name){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<School> schoolList = session.createQuery("from School s where s.name='" + name + "'").getResultList();
        session.getTransaction().commit();
        return schoolList;
    }

    public List<School> getAllScools(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<School> schoolList = session.createQuery("from School").getResultList();
        session.getTransaction().commit();
        return schoolList;
    }

    public void saveCourse(Course course){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }

    public List<Course> getCourse(String name){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Course> courseList = session.createQuery("from Course c where c.name='" + name + "'").getResultList();
        session.getTransaction().commit();
        return courseList;
    }

    public List<Course> getAllCourses(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Course> courseList = session.createQuery("from Course").getResultList();
        session.getTransaction().commit();
        return courseList;
    }

    public void saveUser(User user){
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public List<User> getUser(String username){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User u where u.username='" + username + "'").getResultList();
        session.getTransaction().commit();
        return userList;
    }

    public List<User> getAllUsers(){
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return userList;
    }
}
