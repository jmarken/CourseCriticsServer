package view;

import common.CourseDTO;
import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();



        try{
            UserDTO userBefore = new UserDTO("gimli", "moria");
            controller.createUser(userBefore);
            System.out.println(controller.login(userBefore));
            UserDTO userAfter = new UserDTO("gimli", "middleearth");
            controller.updateUser(userAfter);
            System.out.println(controller.login(userBefore));
            System.out.println(controller.login(userAfter));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
