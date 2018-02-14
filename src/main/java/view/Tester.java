package view;

import common.CourseDTO;
import common.ReviewDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();



        try{
            ReviewDTO review = new ReviewDTO("ID1212 Computer Science",
                    "frodo",
                    1,2,3,4,
                    "This is a comment!");
            controller.createReview(review);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
