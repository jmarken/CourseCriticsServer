package view;

import common.CourseDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();

        UserDTO user = new UserDTO("arwen", "password");

        CourseDTO courseDTO = new CourseDTO("ET01 Movie Theories", "KTH");
        System.out.println(courseDTO);

        //DUPE
        //CourseDTO courseDTO = new CourseDTO("IX10 Basic Physics", "KTH");

        try{

            controller.createCourse(courseDTO);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
