package view;

import common.UserDTO;
import controller.Controller;

public class Tester {
    public static void main(String[] args) {
        Controller controller = new Controller();

        UserDTO user = new UserDTO("arwen", "password");

        try{
            controller.registerUser(user);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(controller.verifyUser(user));

    }
}
