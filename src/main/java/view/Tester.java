package view;

import common.CourseDTO;
import common.ReviewDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();



        try{
            System.out.println(controller.getCourseReviews("LI2010 Physiology I"));
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}
