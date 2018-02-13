package model;

import common.ErrorMessages;
import model.Entity.Course;
import model.Entity.Review;
import model.Entity.School;
import model.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DBOperations {
    private Factory factory = new Factory();
    private SessionFactory sessionFactory = factory.getFactory();
    Session session = sessionFactory.getCurrentSession();

    public DBOperations(Factory factoryObj, SessionFactory factory) {
        this.factory = factoryObj;
        this.sessionFactory = factory;
    }

    public void saveSchool(School school){
        try{
            if(getSchool(school.getName()) == null){
                session = sessionFactory.getCurrentSession();
                session.beginTransaction();
                session.save(school);
                session.getTransaction().commit();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public School getSchool(String name){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        School school = new School();
        try{
            school = (School) session.createQuery("from School s where s.name='" + name + "'").getResultList().get(0);
        }catch (IndexOutOfBoundsException e){
            school = null;
        }
        session.getTransaction().commit();
        return school;
    }

    public List<School> getSchools(String name){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<School> schoolList = session.createQuery("from School s where s.name='" + name + "'").getResultList();
        session.getTransaction().commit();
        return schoolList;
    }

    public List<School> getAllScools(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<School> schoolList = session.createQuery("from School").getResultList();
        session.getTransaction().commit();
        return schoolList;
    }

    public void saveCourse(Course course) throws Error.SaveCourseException{
        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        }catch (javax.persistence.PersistenceException cve){
            throw new Error.SaveCourseException(ErrorMessages.SAVE_COURSE_FAILED.getErrorMessage());
        }

    }

    public Course getCourse(String name){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Course course = new Course();
        try{
            course = (Course) session.createQuery("from Course c where c.name='" + name + "'").getResultList().get(0);
        }catch (IndexOutOfBoundsException e){
            course = null;
        }
        session.getTransaction().commit();
        return course;
    }

    public List<Course> getCourses(String name){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Course> courseList = session.createQuery("from Course c where c.name='" + name + "'").getResultList();
        session.getTransaction().commit();
        return courseList;
    }

    public List<Course> getAllCourses(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Course> courseList = session.createQuery("from Course").getResultList();
        session.getTransaction().commit();
        return courseList;
    }

    public void saveUser(User user) throws Error.SaveUserException{
        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (javax.persistence.PersistenceException cve){
            throw new Error.SaveUserException(ErrorMessages.SAVE_USER_FAILED.getErrorMessage());
        }

    }

    public List<User> getUser(String username){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User u where u.username='" + username + "'").getResultList();
        session.getTransaction().commit();
        return userList;
    }

    public List<User> getAllUsers(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> userList = session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        return userList;
    }

    public void saveReview(Review review) throws Error.SaveReviewException{
        try{
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(review);
            session.getTransaction().commit();
        }catch (javax.persistence.PersistenceException cve){
            throw new Error.SaveReviewException(ErrorMessages.SAVE_REVIEW_FAILED.getErrorMessage());
        }

    }

    public List<Review> getReviews(String coursename){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Review> reviewList = session.createQuery("from Review r where r.course_name='" + coursename + "'").getResultList();
        session.getTransaction().commit();
        return reviewList;
    }

    public List<Review> getAllReviews(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Review> reviewList = session.createQuery("from Review").getResultList();
        session.getTransaction().commit();
        return reviewList;
    }

}
