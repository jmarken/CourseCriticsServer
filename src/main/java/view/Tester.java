package view;

import common.CourseDTO;
import common.ReviewDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();



        try{
            System.out.println(controller.getCourse("ID1001 Network Engineering"));
            System.out.println(controller.getCourses());


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
