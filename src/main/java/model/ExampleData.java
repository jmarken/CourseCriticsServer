package model;

import model.Entity.Course;
import model.Entity.Review;
import model.Entity.School;
import model.Entity.User;

public class ExampleData {
    public void enterStuff(){
        try {
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

            Review r1 = new Review(model.getCourse("IX10 Basic Physics"),
                    model.getUser("frodo").get(0),
                    3, 4, 2, 5,
                    "Boring course, good teacher!");
            model.saveReview(r1);
            Review r2 = new Review(model.getCourse("ID1212 Computer Science"),
                    model.getUser("gandalf").get(0),
                    1, 2, 3, 2,
                    "Boring course, good teacher!");
            model.saveReview(r2);
            Review r3 = new Review(model.getCourse("IX10 Basic Physics"),
                    model.getUser("gandalf").get(0),
                    4, 4, 4, 3,
                    "Boring course, good teacher!");
            model.saveReview(r3);

            System.out.println("Schools in DB: " + model.getAllScools());
            System.out.println("Courses in DB: " + model.getAllCourses());
            System.out.println("Users in DB: " + model.getAllUsers());
            System.out.println("Reviews in DB: ");
            for (Review review : model.getAllReviews()) {
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
