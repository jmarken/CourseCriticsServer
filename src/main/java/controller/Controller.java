package controller;

import common.CourseDTO;
import common.UserDTO;
import model.Model;

public class Controller {
    Model model = new Model();

    public void registerUser(UserDTO registerUser) throws Exception{
        try {
            model.registerUser(registerUser);
        }catch (Exception ex){
            throw ex;
        }

    }

    public Boolean login(UserDTO userDTO){
        return model.login(userDTO);
    }

    public void createCourse(CourseDTO courseDTO) throws Exception{
        try{
            model.createCourse(courseDTO);
        }catch (Exception e){
            throw e;
        }
    }


}
