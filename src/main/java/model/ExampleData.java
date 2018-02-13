package model;

import model.Entity.Course;
import model.Entity.Review;
import model.Entity.School;
import model.Entity.User;
import org.hibernate.SessionFactory;

public class ExampleData {
    public void enterStuff(){
        try {
            Factory factory = new Factory();
            SessionFactory sessionFactory = factory.getFactory();
            DBOperations dbo = new DBOperations(factory, sessionFactory);
            School kth = new School("KTH");
            dbo.saveSchool(kth);
            School su = new School("Stockholms Universitet");
            dbo.saveSchool(su);
            School ltu = new School("Lunds Tekniska Universitet");
            dbo.saveSchool(ltu);


            Course bp = new Course("IX10 Basic Physics", kth);
            dbo.saveCourse(bp);
            Course cs = new Course("ID1212 Computer Science", ltu);
            dbo.saveCourse(cs);
            Course nt = new Course("IT1234 Network Technology", su);
            dbo.saveCourse(nt);

            User fb = new User("frodo", "pw");
            dbo.saveUser(fb);
            User bb = new User("bilbo", "pw");
            dbo.saveUser(bb);
            User g = new User("gandalf", "pw");
            dbo.saveUser(g);

            Review r1 = new Review(dbo.getCourse("IX10 Basic Physics"),
                    dbo.getUser("frodo"),
                    3, 4, 2, 5,
                    "Boring course, good teacher!");
            dbo.saveReview(r1);
            Review r2 = new Review(dbo.getCourse("ID1212 Computer Science"),
                    dbo.getUser("gandalf"),
                    1, 2, 3, 2,
                    "Boring course, good teacher!");
            dbo.saveReview(r2);
            Review r3 = new Review(dbo.getCourse("IX10 Basic Physics"),
                    dbo.getUser("gandalf"),
                    4, 4, 4, 3,
                    "Boring course, good teacher!");
            dbo.saveReview(r3);

            System.out.println("Schools in DB: " + dbo.getAllScools());
            System.out.println("Courses in DB: " + dbo.getAllCourses());
            System.out.println("Users in DB: " + dbo.getAllUsers());
            System.out.println("Reviews in DB: ");
            for (Review review : dbo.getAllReviews()) {
                System.out.println("---------------------------------------");
                System.out.println("Course: " + review.getCourse().getName() +
                        "\nUser: " + review.getUser().getUsername() +
                        "\nQuality: " + review.getQuality() +
                        "\nRelevance: " + review.getRelevance() +
                        "\nDifficulty: " + review.getDifficulty() +
                        "\nTeaching: " + review.getTeaching() +
                        "\nComment: " + review.getComment());
                System.out.println("---------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
