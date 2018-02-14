package view;

import common.CourseDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();



        try{
            System.out.println(controller.getSchools());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
